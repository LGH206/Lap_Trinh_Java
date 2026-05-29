package com.horseracing.controller;

import com.horseracing.dto.RegistrationDTO;
import com.horseracing.service.interfaces.IParticipationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

// Controller dieu huong toan bo request lien quan den Dang ky thi dau (Registration)
@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private final IParticipationService participationService;

    // Inject Service thong qua Constructor
    @Autowired
    public RegistrationController(IParticipationService participationService) {
        this.participationService = participationService;
    }

    // GET /registration/form : Hien thi form dang ky dua cho ngua
    @GetMapping("/form")
    public String showForm() {
        return "registration/form";
    }

    // POST /registration/create : Chu ngua dang ky ngua cua minh cho tran dua
    @PostMapping("/create")
    public String handleCreate(HttpSession session,
                               @RequestParam("raceId") int raceId,
                               @RequestParam("horseId") int horseId,
                               @RequestParam(value = "notes", required = false) String notes,
                               Model model) {
        if (!hasRole(session, "HORSE_OWNER")) {
            return "redirect:/login";
        }
        try {
            int ownerId = (int) session.getAttribute("userId");
            int regId = participationService.registerHorseForRace(raceId, horseId, ownerId, notes);
            return "redirect:/registration/my?msg=registered&id=" + regId;
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "registration/form";
        }
    }

    // POST /registration/confirm : Chu ngua xac nhan cho phep ngua tham gia tran dua
    @PostMapping("/confirm")
    public String handleConfirm(HttpSession session,
                                @RequestParam("id") int id,
                                Model model) {
        if (!hasRole(session, "HORSE_OWNER")) {
            return "redirect:/login";
        }
        try {
            int ownerId = (int) session.getAttribute("userId");
            participationService.confirmParticipation(id, ownerId);
            return "redirect:/registration/my?msg=confirmed";
        } catch (Exception e) {
            return "redirect:/registration/my?error=" + e.getMessage();
        }
    }

    // POST /registration/withdraw : Chu ngua rut dang ky dua truoc khi bat dau
    @PostMapping("/withdraw")
    public String handleWithdraw(HttpSession session,
                                 @RequestParam("id") int id,
                                 @RequestParam("reason") String reason) {
        if (!hasRole(session, "HORSE_OWNER")) {
            return "redirect:/login";
        }
        try {
            int ownerId = (int) session.getAttribute("userId");
            participationService.withdrawRegistration(id, ownerId, reason);
            return "redirect:/registration/my?msg=withdrawn";
        } catch (Exception e) {
            return "redirect:/registration/my?error=" + e.getMessage();
        }
    }

    // POST /registration/approve : Admin phe duyet don dang ky dua
    @PostMapping("/approve")
    public String handleApprove(HttpSession session,
                                @RequestParam("id") int id,
                                @RequestParam(value = "notes", required = false) String notes) {
        if (!hasRole(session, "ADMIN")) {
            return "error/403";
        }
        participationService.approveRegistration(id, notes);
        return "redirect:/registration/pending?msg=approved";
    }

    // POST /registration/reject : Admin tu choi don dang ky dua
    @PostMapping("/reject")
    public String handleReject(HttpSession session,
                               @RequestParam("id") int id,
                               @RequestParam("reason") String reason) {
        if (!hasRole(session, "ADMIN")) {
            return "error/403";
        }
        participationService.rejectRegistration(id, reason);
        return "redirect:/registration/pending?msg=rejected";
    }

    // GET /registration/my : Xem danh sach dang ky dua cua rieng Chu Ngua
    @GetMapping("/my")
    public String handleMyRegistrations(HttpSession session, Model model) {
        if (!hasRole(session, "HORSE_OWNER")) {
            return "redirect:/login";
        }
        int ownerId = (int) session.getAttribute("userId");
        List<RegistrationDTO> list = participationService.getRegistrationsByOwner(ownerId);
        model.addAttribute("registrations", list);
        return "registration/my-registrations";
    }

    // GET /registration/race : Lay danh sach dang ky dua cua mot tran dua cu the
    @GetMapping("/race")
    public String handleByRace(@RequestParam("raceId") int raceId, Model model) {
        List<RegistrationDTO> list = participationService.getRegistrationsByRace(raceId);
        model.addAttribute("registrations", list);
        model.addAttribute("raceId", raceId);
        return "registration/race-registrations";
    }

    // GET /registration/jockey : Xem danh sach cac tran dua ma Jockey duoc phan cong
    @GetMapping("/jockey")
    public String handleByJockey(HttpSession session,
                                 @RequestParam(value = "jockeyId", required = false) Integer jockeyId,
                                 Model model) {
        if (jockeyId == null) {
            jockeyId = (Integer) session.getAttribute("jockeyId");
        }
        if (jockeyId == null) {
            return "redirect:/login";
        }
        List<RegistrationDTO> list = participationService.getRegistrationsByJockey(jockeyId);
        model.addAttribute("registrations", list);
        return "registration/jockey-races";
    }

    // GET /registration/pending : Admin xem danh sach don dang ky dang cho duyet
    @GetMapping("/pending")
    public String handlePending(HttpSession session, Model model) {
        if (!hasRole(session, "ADMIN")) {
            return "error/403";
        }
        List<RegistrationDTO> list = participationService.getPendingRegistrations();
        model.addAttribute("registrations", list);
        return "registration/pending";
    }

    // GET /registration/detail : Hien thi chi tiet don dang ky thi dau
    @GetMapping("/detail")
    public String handleDetail(@RequestParam("id") int id, Model model) {
        RegistrationDTO dto = participationService.getRegistrationById(id);
        if (dto == null) {
            return "error/404";
        }
        model.addAttribute("registration", dto);
        return "registration/detail";
    }

    // Kiem tra phan quyen cua nguoi dung trong session va tu dong gia lap de test doc lap Module 3
    private boolean hasRole(HttpSession session, String role) {
        if (session == null) return false;
        
        // Gia lap thong tin dang nhap neu session chua co de chay thu nghiem doc lap
        if (session.getAttribute("role") == null) {
            if ("HORSE_OWNER".equals(role)) {
                session.setAttribute("userId", 2);    // User owner1 (Nguyen Van A)
                session.setAttribute("role", "HORSE_OWNER");
            } else if ("ADMIN".equals(role)) {
                session.setAttribute("userId", 1);    // User admin1
                session.setAttribute("role", "ADMIN");
            } else if ("JOCKEY".equals(role)) {
                session.setAttribute("userId", 3);    // User jockey1 (Le Thi B)
                session.setAttribute("jockeyId", 1);
                session.setAttribute("role", "JOCKEY");
            }
        }
        
        return role.equals(session.getAttribute("role"));
    }
}
