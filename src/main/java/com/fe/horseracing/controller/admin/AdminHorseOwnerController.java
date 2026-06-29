package com.fe.horseracing.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fe.horseracing.enums.Role;
import com.fe.horseracing.pojo.HorseOwner;
import com.fe.horseracing.service.interfaces.IHorseOwnerService;
import com.fe.horseracing.service.interfaces.IUserService;

@Controller
@RequestMapping("/admin/owners")
public class AdminHorseOwnerController {

    @Autowired
    private IHorseOwnerService horseOwnerService;
    private IUserService userService;

    @GetMapping("")
    public String list(Model model){

        model.addAttribute("owners", horseOwnerService.findAll());
        return "admin/owners/list";
    }
    
    @GetMapping("/add")
    public String add(Model model) {

        model.addAttribute("owner", new HorseOwner());
        return "admin/owners/form";
    } 
    
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id,
                       Model model) {

        HorseOwner owner = horseOwnerService.findById(id);

        if (owner == null)
            return "redirect:/admin/owners";

        model.addAttribute("owner", owner);

        return "admin/owners/form";
    }
    
    @PostMapping("/save")
    public String save(
            @ModelAttribute("owner") HorseOwner owner,
            @RequestParam(value = "confirmPassword", required = false)
            String confirmPassword,
            Model model) {

        if (owner.getUserId() == null) {

            String error = horseOwnerService.register(owner, confirmPassword);

            if (error != null) {
                model.addAttribute("owner", owner);
                model.addAttribute("error", error);
                return "admin/owners/form";
            }

        } else {

            horseOwnerService.update(owner);

        }
        return "redirect:/admin/owners";
    }
    
    @GetMapping("/disable/{id}")
    public String disable(@PathVariable Long id){

        userService.lockUser(id);

        return "redirect:/admin/owners";

    }
    
    @GetMapping("/enable/{id}")
    public String enable(@PathVariable Long id){

        userService.unlockUser(id);

        return "redirect:/admin/owners";

    }

}