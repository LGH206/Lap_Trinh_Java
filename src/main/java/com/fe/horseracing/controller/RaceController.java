package com.example.controller;

import com.example.model.Race;
import com.example.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/races")
public class RaceController {

    @Autowired
    private RaceService raceService;

    @PostMapping("/create")
    public String createRace(@RequestBody Race race) {
        return raceService.addRace(race);
    }

    @GetMapping("/tournament/{tournamentId}")
    public List<Race> getRacesInTournament(@PathVariable int tournamentId) {
        return raceService.getRacesByTournament(tournamentId);
    }

    @GetMapping("/{raceId}/participants")
    public List<Map<String, Object>> getParticipants(@PathVariable int raceId) {
        return raceService.getRaceParticipants(raceId);
    }
}
