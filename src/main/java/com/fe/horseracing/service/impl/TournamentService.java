package com.example.service;

import com.example.dao.TournamentDAO;
import com.example.model.Tournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TournamentService {

    @Autowired
    private TournamentDAO tournamentDAO;

    public String addTournament(Tournament tournament) {
        if (tournament.getName() == null || tournament.getName().isEmpty()) {
            return "Tên giải đấu không được để trống!";
        }
        tournamentDAO.save(tournament);
        return "Tạo giải đấu thành công!";
    }

    public List<Tournament> getAllTournaments() {
        return tournamentDAO.findAll();
    }
}
