package com.fe.horseracing.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fe.horseracing.enums.Role;
import com.fe.horseracing.pojo.User;
import com.fe.horseracing.service.interfaces.IUserService;

@Controller
@RequestMapping("/admin/users")
public class AdminUserController {

    @Autowired
    private IUserService userService;

    @GetMapping("")
    public String list(Model model){

        model.addAttribute("users", userService.findAll());

        return "admin/users/list";
    }
    
    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Long id,
                       Model model) {

        User user = userService.findById(id);

        if (user == null) {
            return "redirect:/admin/users";
        }

        model.addAttribute("user", user);

        return "admin/users/view";
    }
    
    @GetMapping("/lock/{id}")
    public String lock(@PathVariable("id") Long id) {

        userService.lockUser(id);

        return "redirect:/admin/users";
    }
    
    @GetMapping("/unlock/{id}")
    public String unlock(@PathVariable("id") Long id) {

        userService.unlockUser(id);

        return "redirect:/admin/users";
    }

}
