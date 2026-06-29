package com.fe.horseracing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.fe.horseracing.service.interfaces.IUserService;

@Controller
public class LoginController {

    private IUserService userService;

    @Autowired
    public LoginController(IUserService userService) {
        this.userService = userService;
    }
    
    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }
}