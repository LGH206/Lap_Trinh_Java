package controller;

import entity.Tournament;
import service.TournamentService;
import java.util.List;

public class TournamentController {
    
    private TournamentService tournamentService = new TournamentService();

    public void createTournament(int id, String name, String location) {
 
        Tournament t = new Tournament(id, name, location);
   
        tournamentService.createTournament(t);
        System.out.println(">> Hệ thống: Đã xử lý yêu cầu tạo giải đấu [" + name + "]");
    }

    public void viewTournaments() {
        List<Tournament> list = tournamentService.getAllTournaments();
        System.out.println("\n===== DANH SÁCH GIẢI ĐẤU QUẢN LÝ =====");
        if (list.isEmpty()) {
            System.out.println("(Hiện chưa có giải đấu nào trong hệ thống)");
        } else {
            for (Tournament t : list) {
                System.out.println("ID: " + t.getId() + " | Tên giải: " + t.getName() + " | Địa điểm: " + t.getLocation());
            }
        }
        System.out.println("=======================================");
    }
}
