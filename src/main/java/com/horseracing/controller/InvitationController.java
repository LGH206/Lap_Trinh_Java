package com.horseracing.controller;

import com.horseracing.dto.InvitationDTO;
import com.horseracing.service.interfaces.IInvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

// Controller dieu huong toan bo request lien quan den Loi moi Jockey (Invitation)
@Controller
@RequestMapping("/invitation")
public class InvitationController {

    private final IInvitationService invitationService;

    // Inject Service thong qua Constructor
    @Autowired
    public InvitationController(IInvitationService invitationService) {
        this.invitationService = invitationService;
    }

    // POST /invitation/send : Chu ngua gui loi moi den mot Jockey
    @PostMapping("/send")
    public String handleSend(HttpSession session,
                             @RequestParam("registrationId") int registrationId,
                             @RequestParam("jockeyId") int jockeyId,
                             @RequestParam("message") String message,
                             @RequestParam(value = "daysValid", defaultValue = "3") int daysValid) {
        if (!hasRole(session, "HORSE_OWNER")) {
            return "redirect:/login";
        }
        try {
            int ownerId = (int) session.getAttribute("userId");
            invitationService.sendInvitation(registrationId, ownerId, jockeyId, message, daysValid);
            return "redirect:/invitation/sent?msg=sent";
        } catch (Exception e) {
            return "redirect:/invitation/sent?error=" + e.getMessage();
        }
    }

    // POST /invitation/accept : Jockey dong y loi moi tu Chu Ngua
    @PostMapping("/accept")
    public String handleAccept(HttpSession session,
                               @RequestParam("id") int id,
                               @RequestParam(value = "responseMessage", required = false) String responseMessage) {
        if (!hasRole(session, "JOCKEY")) {
            return "redirect:/login";
        }
        try {
            int jockeyId = (int) session.getAttribute("jockeyId");
            invitationService.acceptInvitation(id, jockeyId, responseMessage);
            return "redirect:/invitation/inbox?msg=accepted";
        } catch (Exception e) {
            return "redirect:/invitation/inbox?error=" + e.getMessage();
        }
    }

    // POST /invitation/decline : Jockey tu choi loi moi tu Chu Ngua
    @PostMapping("/decline")
    public String handleDecline(HttpSession session,
                                @RequestParam("id") int id,
                                @RequestParam(value = "responseMessage", required = false) String responseMessage) {
        if (!hasRole(session, "JOCKEY")) {
            return "redirect:/login";
        }
        try {
            int jockeyId = (int) session.getAttribute("jockeyId");
            invitationService.declineInvitation(id, jockeyId, responseMessage);
            return "redirect:/invitation/inbox?msg=declined";
        } catch (Exception e) {
            return "redirect:/invitation/inbox?error=" + e.getMessage();
        }
    }

    // POST /invitation/cancel : Chu Ngua huy loi moi da gui cho Jockey
    @PostMapping("/cancel")
    public String handleCancel(HttpSession session,
                               @RequestParam("id") int id) {
        if (!hasRole(session, "HORSE_OWNER")) {
            return "redirect:/login";
        }
        try {
            int ownerId = (int) session.getAttribute("userId");
            invitationService.cancelInvitation(id, ownerId);
            return "redirect:/invitation/sent?msg=cancelled";
        } catch (Exception e) {
            return "redirect:/invitation/sent?error=" + e.getMessage();
        }
    }

    // GET /invitation/inbox : Jockey xem danh sach hop thu loi moi nhan duoc
    @GetMapping("/inbox")
    public String handleInbox(HttpSession session, Model model) {
        if (!hasRole(session, "JOCKEY")) {
            return "redirect:/login";
        }
        int jockeyId = (int) session.getAttribute("jockeyId");
        List<InvitationDTO> all = invitationService.getAllInvitationsForJockey(jockeyId);
        List<InvitationDTO> pending = invitationService.getPendingInvitationsForJockey(jockeyId);
        
        model.addAttribute("allInvitations", all);
        model.addAttribute("pendingInvitations", pending);
        return "invitation/inbox";
    }

    // GET /invitation/sent : Chu ngua xem danh sach cac loi moi da gui
    @GetMapping("/sent")
    public String handleSent(HttpSession session, Model model) {
        if (!hasRole(session, "HORSE_OWNER")) {
            return "redirect:/login";
        }
        int ownerId = (int) session.getAttribute("userId");
        List<InvitationDTO> sent = invitationService.getSentInvitationsByOwner(ownerId);
        
        model.addAttribute("sentInvitations", sent);
        return "invitation/sent";
    }

    // GET /invitation/detail : Xem chi tiet thong tin loi moi
    @GetMapping("/detail")
    public String handleDetail(@RequestParam("id") int id, Model model) {
        InvitationDTO dto = invitationService.getInvitationDetail(id);
        if (dto == null) {
            return "error/404";
        }
        model.addAttribute("invitation", dto);
        return "invitation/detail";
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
