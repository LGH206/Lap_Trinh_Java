package com.example.app.repository;

import com.example.app.model.Race;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class RaceRepository {

    private final JdbcTemplate jdbcTemplate;

    public RaceRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Race> raceRowMapper = (rs, rowNum) -> new Race(
            rs.getLong("id"),
            rs.getLong("tournament_id"),
            rs.getString("race_name")
    );

    // Chức năng: tạo race
    public int save(Race race) {
        String sql = "INSERT INTO races (tournament_id, race_name) VALUES (?, ?)";
        return jdbcTemplate.update(sql, race.getTournamentId(), race.getRaceName());
    }

    // Chức năng: xem danh sách các cuộc đua thuộc một giải đấu cụ thể
    public List<Race> findByTournamentId(Long tournamentId) {
        String sql = "SELECT * FROM races WHERE tournament_id = ?";
        return jdbcTemplate.query(sql, raceRowMapper, tournamentId);
    }

    // Chức năng phụ: xem danh sách người tham gia (Participant) theo trận đua
    public List<String> findParticipantsByRaceId(Long raceId) {
        String sql = "SELECT p.name FROM participants p WHERE p.race_id = ?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> rs.getString("name"), raceId);
    }
}
