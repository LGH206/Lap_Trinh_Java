package service;

import dao.TournamentDAO;
import entity.Tournament;
import java.util.List;

public class TournamentService {
    private TournamentDAO tournamentDAO = new TournamentDAO();
    public void createTournament(Tournament tournament) {
        if (tournament.getName() == null || tournament.getName().isEmpty()) {
            System.out.println(">> Lỗi nghiệp vụ: Tên giải đấu không được bỏ trống!");
            return; 
        }
        
        tournamentDAO.save(tournament);
    }

    public List<Tournament> getAllTournaments() {
        return tournamentDAO.findAll();
    }
}
