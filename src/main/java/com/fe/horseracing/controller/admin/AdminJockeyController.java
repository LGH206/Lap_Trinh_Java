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

import com.fe.horseracing.pojo.Jockey;
import com.fe.horseracing.service.interfaces.IJockeyService;
import com.fe.horseracing.service.interfaces.IUserService;

@Controller
@RequestMapping("/admin/jockeys")
public class AdminJockeyController {
	
    private IJockeyService jockeyService;
    private IUserService userService;

    @Autowired
    public AdminJockeyController(
            IJockeyService jockeyService,
            IUserService userService) {

        this.jockeyService = jockeyService;
        this.userService = userService;
    }
    
    @GetMapping("")
    public String list(Model model){

        model.addAttribute(
                "jockeys",
                jockeyService.findAll());

        return "admin/jockeys/list";
    }
    
    @GetMapping("/add")
    public String add(Model model){

        model.addAttribute("jockey", new Jockey());
        return "admin/jockeys/form";
    }
    
    @PostMapping("/save")
    public String save(

            @ModelAttribute("jockey")
            Jockey jockey,

            @RequestParam(value="confirmPassword", required=false)
            String confirmPassword,

            Model model){

        if(jockey.getUserId()==null){

            String error= jockeyService.register( jockey, confirmPassword);

            if(error!=null){

                model.addAttribute( "jockey", jockey);
                model.addAttribute("error", error);

                return "admin/jockeys/form";
            }
        }else{
            jockeyService.update(jockey);

        }
        return "redirect:/admin/jockeys";
    }
    
    @GetMapping("/edit/{id}")
    public String edit(

            @PathVariable Long id,

            Model model){

        Jockey jockey= jockeyService.findById(id);

        if(jockey==null)
            return "redirect:/admin/jockeys";

        model.addAttribute("jockey", jockey);
        return "admin/jockeys/form";
    }
    
    @GetMapping("/unlock/{id}")
    public String unlock(@PathVariable Long id){
        userService.unlockUser(id);
        return "redirect:/admin/jockeys";
    }
}
