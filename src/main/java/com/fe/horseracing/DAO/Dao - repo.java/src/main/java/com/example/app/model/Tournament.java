package com.example.app.model;

public class Tournament {
    private Long id;
    private String name;
    private String schedule; // Lịch thi đấu

    // 1. Constructor không tham số (Bắt buộc phải có trong Spring)
    public Tournament() {
    }

    // 2. Constructor có đầy đủ tham số
    public Tournament(Long id, String name, String schedule) {
        this.id = id;
        this.name = name;
        this.schedule = schedule;
    }

    // 3. Các hàm Getter và Setter để lấy và ghi dữ liệu
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
}