package com.fe.horseracing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.fe.horseracing.pojo.User;
import com.fe.horseracing.pojo.Spectator; // Ví dụ default role
import com.fe.horseracing.service.AuthService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Trả về trang login.html (Thymeleaf)
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, 
                        @RequestParam String password, 
                        HttpSession session, 
                        Model model) {
        User user = authService.login(username, password);
        if (user != null) {
            session.setAttribute("loggedInUser", user);
            return "redirect:/"; // Redirect về trang chủ sau khi login
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register"; // Trả về trang register.html
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Spectator user, Model model) {
        // Tạm thời hardcode Spectator vì abstract class User không thể instantiate.
        // Trong thực tế, UI sẽ có chọn Role hoặc mặc định là Spectator.
        try {
            authService.register(user, "SPECTATOR");
            return "redirect:/auth/login?registered=true";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/auth/login?logout=true";
    }
}
