package controller;

import entity.Race;
import service.RaceService;
import java.util.Date;
import java.util.List;

public class RaceController {
   
    private RaceService raceService = new RaceService();

    public void createRace(int id, int tournamentId, String raceName) {
     
        Date currentTime = new Date();
        
        Race r = new Race(id, tournamentId, raceName, currentTime);
       
        raceService.createRace(r);
        System.out.println(">> Hệ thống: Đã xử lý yêu cầu tạo trận đua [" + raceName + "]");
    }

    public void viewRaces() {
        List<Race> list = raceService.getAllRaces();
        System.out.println("\n===== DANH SÁCH TRẬN ĐUA HIỆN TẠI =====");
        if (list.isEmpty()) {
            System.out.println("(Hiện chưa có trận đua nào trong hệ thống)");
        } else {
            for (Race r : list) {
                System.out.println("ID: " + r.getId() 
                    + " | Thuộc Giải ID: " + r.getTournamentId() 
                    + " | Tên trận: " + r.getRaceName() 
                    + " | Thời gian: " + r.getScheduledTime());
            }
        }
        System.out.println("=======================================");
    }

    public void viewParticipants(int raceId) {
        System.out.println("\n>> [Tính năng Mở rộng]: Đang lấy danh sách Nài ngựa & Ngựa đua của trận có ID: " + raceId);
        System.out.println("- Ngựa số 05: Thần Tốc (Nài ngựa: Nguyễn Văn A)");
        System.out.println("- Ngựa số 09: Phi Long (Nài ngựa: Trần Văn B)");
        System.out.println("--------------------------------------------------");
    }
}