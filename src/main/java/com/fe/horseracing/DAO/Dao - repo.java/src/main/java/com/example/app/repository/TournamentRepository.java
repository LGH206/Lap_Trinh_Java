package com.example.app.repository;

import com.example.app.model.Tournament;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class TournamentRepository {

    private final JdbcTemplate jdbcTemplate;

    // Spring tự động kết nối JdbcTemplate vào đây
    public TournamentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper dùng để biến đổi dữ liệu hàng từ DB thành Đối tượng Java Tournament
    private final RowMapper<Tournament> tournamentRowMapper = (rs, rowNum) -> new Tournament(
            rs.getLong("id"),
            rs.getString("name"),
            rs.getString("schedule")
    );

    // Chức năng: tạo tournament (Lưu xuống DB)
    public int save(Tournament tournament) {
        String sql = "INSERT INTO tournaments (name, schedule) VALUES (?, ?)";
        return jdbcTemplate.update(sql, tournament.getName(), tournament.getSchedule());
    }

    // Chức năng: xem danh sách tournament (Lấy từ DB lên)
    public List<Tournament> findAll() {
        String sql = "SELECT * FROM tournaments";
        return jdbcTemplate.query(sql, tournamentRowMapper);
    }
}
