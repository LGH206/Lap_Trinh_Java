 package com.example.service;

import com.example.dao.RaceDAO;
import com.example.model.Race;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class RaceService {

    @Autowired
    private RaceDAO raceDAO;

    public String addRace(Race race) {
        if (race.getRaceName() == null || race.getRaceName().isEmpty()) {
            return "Tên trận đấu không được để trống!";
        }
        raceDAO.save(race);
        return "Tạo trận đấu thành công!";
    }

    public List<Race> getRacesByTournament(int tournamentId) {
        return raceDAO.findByTournamentId(tournamentId);
    }

    public List<Map<String, Object>> getRaceParticipants(int raceId) {
        return raceDAO.findParticipantsByRaceId(raceId);
    }
}
