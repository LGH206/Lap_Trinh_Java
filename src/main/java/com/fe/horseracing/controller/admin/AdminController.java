package com.fe.horseracing.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fe.horseracing.service.interfaces.IHorseService;
import com.fe.horseracing.service.interfaces.IRaceService;
import com.fe.horseracing.service.interfaces.ITournamentService;
import com.fe.horseracing.service.interfaces.IUserService;

@Controller
public class AdminController {

    private final IUserService userService;
    private final IHorseService horseService;
    private final IRaceService raceService;
    private final ITournamentService tournamentService;

    @Autowired
    public AdminController(
            IUserService userService,
            IHorseService horseService,
            IRaceService raceService,
            ITournamentService tournamentService) {

        this.userService = userService;
        this.horseService = horseService;
        this.raceService = raceService;
        this.tournamentService = tournamentService;
    }

    @GetMapping("/admin/dashboard")
    public String dashboard(Model model) {

        model.addAttribute("userCount", userService.findAll().size());

        model.addAttribute("horseCount", horseService.findAll().size());

        model.addAttribute("raceCount", raceService.findAll().size());

        model.addAttribute("tournamentCount", tournamentService.findAll().size());

        return "admin/dashboard";
    }

}