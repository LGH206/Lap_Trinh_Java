package com.horseracing.repository;

import com.horseracing.entity.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class RegistrationDAO {

    @Autowired
    private DataSource dataSource;

    private Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    public int create(Registration reg) {
        String sql = "INSERT INTO registrations (race_id, horse_id, owner_id, jockey_id, status, notes, registered_at, updated_at) " + "VALUES (?, ?, ?, ?, ?, ?, NOW(), NOW())";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, reg.getRaceId());
            ps.setInt(2, reg.getHorseId());
            ps.setInt(3, reg.getOwnerId());
            if (reg.getJockeyId() > 0)
                ps.setInt(4, reg.getJockeyId());
            else
                ps.setNull(4, Types.INTEGER);
            ps.setString(5, reg.getStatus());
            ps.setString(6, reg.getNotes());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                reg.setRegistrationId(id);
                return id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    public Registration findById(int id) {
        String sql = "SELECT * FROM registrations WHERE registration_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return mapRow(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Registration> findByRaceId(int raceId) {
        return findByField("race_id", raceId);
    }

    public List<Registration> findByOwnerId(int ownerId) {
        return findByField("owner_id", ownerId);
    }

    public List<Registration> findByHorseId(int horseId) {
        return findByField("horse_id", horseId);
    }

    public List<Registration> findByJockeyId(int jockeyId) {
        return findByField("jockey_id", jockeyId);
    }

    public List<Registration> findByStatus(String status) {
        String sql = "SELECT * FROM registrations WHERE status = ? ORDER BY registered_at DESC";
        List<Registration> list = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, status);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) list.add(mapRow(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean existsForRaceAndHorse(int raceId, int horseId) {
        String sql = "SELECT COUNT(*) FROM registrations WHERE race_id=? AND horse_id=? AND status NOT IN ('REJECTED','WITHDRAWN')";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, raceId);
            ps.setInt(2, horseId);
            ResultSet rs = ps.executeQuery();
            return rs.next() && rs.getInt(1) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateStatus(int registrationId, String status, String notes) {
        String sql = "UPDATE registrations SET status=?, notes=?, updated_at=NOW() WHERE registration_id=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setString(2, notes);
            ps.setInt(3, registrationId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean assignJockey(int registrationId, int jockeyId) {
        String sql = "UPDATE registrations SET jockey_id=?, updated_at=NOW() WHERE registration_id=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, jockeyId);
            ps.setInt(2, registrationId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    private List<Registration> findByField(String field, int value) {
        String sql = "SELECT * FROM registrations WHERE " + field + " = ? ORDER BY registered_at DESC";
        List<Registration> list = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, value);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) list.add(mapRow(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    private Registration mapRow(ResultSet rs) throws SQLException {
        Registration r = new Registration();
        r.setRegistrationId(rs.getInt("registration_id"));
        r.setRaceId(rs.getInt("race_id"));
        r.setHorseId(rs.getInt("horse_id"));
        r.setOwnerId(rs.getInt("owner_id"));
        r.setJockeyId(rs.getInt("jockey_id"));
        r.setStatus(rs.getString("status"));
        r.setNotes(rs.getString("notes"));
        Timestamp regAt = rs.getTimestamp("registered_at");
        if (regAt != null) r.setRegisteredAt(regAt.toLocalDateTime());
        Timestamp updAt = rs.getTimestamp("updated_at");
        if (updAt != null) r.setUpdatedAt(updAt.toLocalDateTime());
        return r;
    }
}
