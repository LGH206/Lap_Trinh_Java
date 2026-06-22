package com.example.app.model;

public class Race {
    private Long id;
    private Long tournamentId; // Thuộc về giải đấu nào
    private String raceName;

    // 1. Constructor không tham số
    public Race() {
    }

    // 2. Constructor có tham số
    public Race(Long id, Long tournamentId, String raceName) {
        this.id = id;
        this.tournamentId = tournamentId;
        this.raceName = raceName;
    }

    // 3. Getter và Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Long tournamentId) {
        this.tournamentId = tournamentId;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }
}
