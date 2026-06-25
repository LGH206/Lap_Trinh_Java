package com.fe.horseracing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.fe.horseracing.pojo.User;
import com.fe.horseracing.service.UserService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String showProfile(HttpSession session, Model model) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser == null) {
            return "redirect:/auth/login";
        }
        
        // Refresh data from DB
        User userProfile = userService.getUserProfile(loggedInUser.getUserId());
        model.addAttribute("user", userProfile);
        return "profile"; // Trả về trang profile.html
    }

    @PostMapping("/profile/update")
    public String updateProfile(@ModelAttribute User updatedUser, HttpSession session, Model model) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser == null) {
            return "redirect:/auth/login";
        }
        
        try {
            updatedUser.setUserId(loggedInUser.getUserId()); // Đảm bảo chỉ update chính user đang login
            userService.updateProfile(updatedUser);
            
            // Cập nhật lại session
            User refreshedUser = userService.getUserProfile(loggedInUser.getUserId());
            session.setAttribute("loggedInUser", refreshedUser);
            
            model.addAttribute("success", "Profile updated successfully");
            return "redirect:/user/profile?success=true";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "redirect:/user/profile?error=true";
        }
    }
    
    // API cho Admin quản lý Users
    @GetMapping("/admin/users")
    public String listAllUsers(HttpSession session, Model model) {
        // Có thể thêm check Role Admin ở đây nếu không dùng Filter
        model.addAttribute("users", userService.getAllUsers());
        return "admin/user_list";
    }
}
