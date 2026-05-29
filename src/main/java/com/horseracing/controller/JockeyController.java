package com.horseracing.controller;

import com.horseracing.dto.JockeyDTO;
import com.horseracing.entity.Jockey;
import com.horseracing.service.interfaces.IJockeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;

// Controller dieu huong toan bo request lien quan den Jockey bang Spring MVC
@Controller
@RequestMapping("/jockey")
public class JockeyController {

    private final IJockeyService jockeyService;

    // Inject Service thong qua Constructor
    @Autowired
    public JockeyController(IJockeyService jockeyService) {
        this.jockeyService = jockeyService;
    }

    // GET /jockey/register : Hien thi form dang ky
    @GetMapping("/register")
    public String showRegisterForm() {
        return "jockey/register"; // Tra ve file view /WEB-INF/views/jockey/register.jsp
    }

    // POST /jockey/register : Thuc hien dang ky jockey moi
    @PostMapping("/register")
    public String handleRegister(@ModelAttribute Jockey jockey,
                                 @RequestParam("password") String password,
                                 Model model) {
        try {
            int jockeyId = jockeyService.registerJockey(jockey, password);
            if (jockeyId <= 0) {
                throw new RuntimeException("He thong khong the tao Jockey. Vui long kiem tra lai thong tin.");
            }
            model.addAttribute("successMessage", "Dang ky thanh cong! ID Jockey: " + jockeyId);
            return "redirect:/jockey/list?msg=registered";
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "jockey/register";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Dang ky that bai: " + e.getMessage());
            return "jockey/register";
        }
    }

    // GET /jockey/profile : Xem thong tin trang ca nhan cua Jockey
    @GetMapping("/profile")
    public String viewProfile(HttpSession session, Model model) {
        if (!isLoggedInAs(session, "JOCKEY")) {
            return "redirect:/login";
        }
        int userId = (int) session.getAttribute("userId");
        JockeyDTO dto = jockeyService.getJockeyByUserId(userId);
        if (dto == null) {
            model.addAttribute("errorMessage", "Khong tim thay thong tin Jockey");
            return "error/404";
        }
        model.addAttribute("jockey", dto);
        return "jockey/profile";
    }

    // GET /jockey/profile/update : Show form cap nhat thong tin
    @GetMapping("/profile/update")
    public String showUpdateForm(HttpSession session, Model model) {
        if (!isLoggedInAs(session, "JOCKEY")) {
            return "redirect:/login";
        }
        int userId = (int) session.getAttribute("userId");
        JockeyDTO dto = jockeyService.getJockeyByUserId(userId);
        model.addAttribute("jockey", dto);
        return "jockey/update-profile";
    }

    // POST /jockey/profile/update : Thuc hien cap nhat thong tin ca nhan
    @PostMapping("/profile/update")
    public String handleUpdateProfile(HttpSession session,
                                      @ModelAttribute Jockey jockey,
                                      Model model) {
        if (!isLoggedInAs(session, "JOCKEY")) {
            return "redirect:/login";
        }
        try {
            int userId = (int) session.getAttribute("userId");
            JockeyDTO current = jockeyService.getJockeyByUserId(userId);
            
            jockey.setJockeyId(current.getJockeyId());
            jockey.setUserId(userId);

            boolean updated = jockeyService.updateProfile(jockey);
            if (updated) {
                return "redirect:/jockey/profile?msg=updated";
            } else {
                model.addAttribute("errorMessage", "Cap nhat ho so that bai");
                return "jockey/update-profile";
            }
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Loi: " + e.getMessage());
            return "jockey/update-profile";
        }
    }

    // GET /jockey/list : Lay danh sach toan bo Jockey (dung cho Admin / Chu Ngua)
    @GetMapping("/list")
    public String listAll(Model model) {
        List<JockeyDTO> jockeys = jockeyService.getAllJockeys();
        model.addAttribute("jockeys", jockeys);
        return "jockey/list";
    }

    // GET /jockey/available : Lay danh sach cac Jockey dang san sang nhan lich
    @GetMapping("/available")
    public String listAvailable(Model model) {
        List<JockeyDTO> jockeys = jockeyService.getAvailableJockeys();
        model.addAttribute("jockeys", jockeys);
        return "jockey/available";
    }

    // GET /jockey/detail : Xem thong tin chi tiet cua mot Jockey cu the
    @GetMapping("/detail")
    public String viewDetail(@RequestParam("id") int id, Model model) {
        JockeyDTO dto = jockeyService.getJockeyById(id);
        if (dto == null) {
            return "error/404";
        }
        model.addAttribute("jockey", dto);
        return "jockey/detail";
    }

    // Phuong thuc ho tro kiem tra quyen va tu dong gia lap dang nhap (giup demo doc lap Module 3)
    private boolean isLoggedInAs(HttpSession session, String role) {
        if (session == null) return false;
        
        // Neu chua co thong tin dang nhap, tu dong gia lap de giup ban chay thu nghiem doc lap Module 3
        if (session.getAttribute("role") == null) {
            if ("JOCKEY".equals(role)) {
                session.setAttribute("userId", 3);    // Lien ket den User 'jockey1' (Le Thi B)
                session.setAttribute("jockeyId", 1);  // ID Jockey tuong ung
                session.setAttribute("role", "JOCKEY");
            } else if ("HORSE_OWNER".equals(role)) {
                session.setAttribute("userId", 2);    // Lien ket den User 'owner1' (Nguyen Van A)
                session.setAttribute("role", "HORSE_OWNER");
            } else if ("ADMIN".equals(role)) {
                session.setAttribute("userId", 1);    // Admin User
                session.setAttribute("role", "ADMIN");
            }
        }
        
        String sessionRole = (String) session.getAttribute("role");
        return role.equals(sessionRole);
    }
}
