import controller.TournamentController;
import controller.RaceController;

public class Main {
    public static void main(String[] args) {
      
        TournamentController tournamentCtrl = new TournamentController();
        RaceController raceCtrl = new RaceController();

        System.out.println("==================================================");
        System.out.println("   HỆ THỐNG QUẢN LÝ GIẢI ĐƯA NGỰA KHỞI ĐỘNG THÀNH CÔNG");
        System.out.println("==================================================");

        System.out.println("\n[HÀNH ĐỘNG] Người dùng yêu cầu tạo 2 giải đấu...");
        tournamentCtrl.createTournament(1, "Giải Đua Ngựa Thường Niên 2026", "Trường đua Đại Nam");
        tournamentCtrl.createTournament(2, "Cúp Vô Địch Ngựa Thần Tốc", "Trường đua Phú Thọ");

        tournamentCtrl.viewTournaments();

        System.out.println("\n[HÀNH ĐỘNG] Người dùng yêu cầu tạo các trận đua cho giải đấu ID = 1...");
        raceCtrl.createRace(101, 1, "Vòng loại bảng A - Ngựa Thuần Chủng");
        raceCtrl.createRace(102, 1, "Chung kết đường đua 1200m");

        raceCtrl.viewRaces();

        raceCtrl.viewParticipants(101);
        
        System.out.println("\n==================================================");
        System.out.println("         KẾT THÚC KỊCH BẢN CHẠY THỬ HỆ THỐNG");
        System.out.println("==================================================");
    }
}
