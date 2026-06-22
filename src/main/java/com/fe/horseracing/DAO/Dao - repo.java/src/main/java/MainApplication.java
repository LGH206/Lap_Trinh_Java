package com.example.app;

import com.example.app.config.AppConfig;
import com.example.app.model.Tournament;
import com.example.app.service.TournamentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApplication {
    public static void main(String[] args) {
        // 1. Khởi chạy Spring Container từ file cấu hình AppConfig
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // 2. Lấy Bean TournamentService ra để gọi chức năng
        TournamentService tournamentService = context.getBean(TournamentService.class);

        try {
            // TEST CHỨC NĂNG 1: Tạo một giải đấu mới lưu xuống DB
            Tournament newTournament = new Tournament(null, "Giải Đua Xe Quốc Tế 2026", "25/12/2026");
            tournamentService.createTournament(newTournament);
            System.out.println(">>> Đã chạy lệnh thêm giải đấu thành công!");

            // TEST CHỨC NĂNG 2: Xem danh sách giải đấu từ DB lên Console
            System.out.println("\n=== DANH SÁCH GIẢI ĐẤU HIỆN CÓ ===");
            tournamentService.getAllTournaments().forEach(t -> {
                System.out.println("ID: " + t.getId() + " | Tên: " + t.getName() + " | Lịch thi: " + t.getSchedule());
            });
            
        } catch (Exception e) {
            System.out.println("Lỗi kết nối hoặc thực thi truy vấn: " + e.getMessage());
            e.printStackTrace();
        } finally {
            context.close(); // Đóng kết nối Spring khi chạy xong
        }
    }
}
