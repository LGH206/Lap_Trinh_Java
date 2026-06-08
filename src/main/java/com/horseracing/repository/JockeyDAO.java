package com.horseracing.repository;

import com.horseracing.entity.Jockey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Repository quan ly toan bo thao tac co so du lieu cua Jockey
@Repository
public class JockeyDAO {

    @Autowired
    private DataSource dataSource;

    // Lay ket noi truc tiep tu DataSource duoc Spring Boot quan ly
    private Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    // Them moi mot Jockey (bao gom tao tai khoan User truoc)
    public int createJockey(Jockey jockey) {
        String insertUser = "INSERT INTO users (username, password_hash, email, full_name, phone, role, status, created_at, updated_at) " +
                            "VALUES (?, ?, ?, ?, ?, 'JOCKEY', 'ACTIVE', NOW(), NOW())";
        String insertJockey = "INSERT INTO jockeys (user_id, license_number, nationality, date_of_birth, weight, " +
                              "experience_years, total_races, total_wins, jockey_status) " +
                              "VALUES (?, ?, ?, ?, ?, ?, 0, 0, 'AVAILABLE')";

        try (Connection conn = getConnection()) {
            conn.setAutoCommit(false); // Bat dau transaction

            int userId;
            try (PreparedStatement psUser = conn.prepareStatement(insertUser, Statement.RETURN_GENERATED_KEYS)) {
                psUser.setString(1, jockey.getUsername());
                psUser.setString(2, jockey.getPasswordHash());
                psUser.setString(3, jockey.getEmail());
                psUser.setString(4, jockey.getFullName());
                psUser.setString(5, jockey.getPhone());
                psUser.executeUpdate();
                ResultSet rs = psUser.getGeneratedKeys();
                rs.next();
                userId = rs.getInt(1);
                jockey.setUserId(userId);
            }

            int jockeyId;
            try (PreparedStatement psJockey = conn.prepareStatement(insertJockey, Statement.RETURN_GENERATED_KEYS)) {
                psJockey.setInt(1, userId);
                psJockey.setString(2, jockey.getLicenseNumber());
                psJockey.setString(3, jockey.getNationality());
                psJockey.setDate(4, Date.valueOf(jockey.getDateOfBirth()));
                psJockey.setDouble(5, jockey.getWeight());
                psJockey.setInt(6, jockey.getExperienceYears());
                psJockey.executeUpdate();
                ResultSet rs = psJockey.getGeneratedKeys();
                rs.next();
                jockeyId = rs.getInt(1);
                jockey.setJockeyId(jockeyId);
            }

            conn.commit(); // Commit neu tat ca thanh cong
            return jockeyId;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Loi SQL khi tao tai khoan Jockey: " + e.getMessage(), e);
        }
    }

    // Tim Jockey theo id
    public Jockey findById(int jockeyId) {
        String sql = "SELECT j.*, u.username, u.email, u.full_name, u.phone, u.status AS user_status " +
                     "FROM jockeys j JOIN users u ON j.user_id = u.user_id " +
                     "WHERE j.jockey_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, jockeyId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return mapRow(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Tim Jockey theo user id
    public Jockey findByUserId(int userId) {
        String sql = "SELECT j.*, u.username, u.email, u.full_name, u.phone, u.status AS user_status " +
                     "FROM jockeys j JOIN users u ON j.user_id = u.user_id " +
                     "WHERE j.user_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return mapRow(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Lay toan bo danh sach Jockey
    public List<Jockey> findAll() {
        String sql = "SELECT j.*, u.username, u.email, u.full_name, u.phone, u.status AS user_status " +
                     "FROM jockeys j JOIN users u ON j.user_id = u.user_id ORDER BY j.jockey_id";
        List<Jockey> list = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
              ResultSet rs = ps.executeQuery()) {
            while (rs.next()) list.add(mapRow(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Lay danh sach Jockey dang ranh roi
    public List<Jockey> findAvailable() {
        String sql = "SELECT j.*, u.username, u.email, u.full_name, u.phone, u.status AS user_status " +
                     "FROM jockeys j JOIN users u ON j.user_id = u.user_id " +
                     "WHERE j.jockey_status = 'AVAILABLE' AND u.status = 'ACTIVE' ORDER BY j.total_wins DESC";
        List<Jockey> list = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) list.add(mapRow(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Kiem tra bang so lai xe (license number) da dang ky chua
    public boolean existsByLicense(String licenseNumber) {
        String sql = "SELECT COUNT(*) FROM jockeys WHERE license_number = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, licenseNumber);
            ResultSet rs = ps.executeQuery();
            return rs.next() && rs.getInt(1) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Cap nhat thong tin ca nhan cua Jockey
    public boolean updateProfile(Jockey jockey) {
        String sql = "UPDATE jockeys SET nationality=?, date_of_birth=?, weight=?, experience_years=?, " +
                     "profile_image_url=? WHERE jockey_id=?";
        String sqlUser = "UPDATE users SET full_name=?, phone=?, email=?, updated_at=NOW() WHERE user_id=?";
        try (Connection conn = getConnection()) {
            conn.setAutoCommit(false);
            try (PreparedStatement ps1 = conn.prepareStatement(sql);
                 PreparedStatement ps2 = conn.prepareStatement(sqlUser)) {

                ps1.setString(1, jockey.getNationality());
                ps1.setDate(2, Date.valueOf(jockey.getDateOfBirth()));
                ps1.setDouble(3, jockey.getWeight());
                ps1.setInt(4, jockey.getExperienceYears());
                ps1.setString(5, jockey.getProfileImageUrl());
                ps1.setInt(6, jockey.getJockeyId());
                ps1.executeUpdate();

                ps2.setString(1, jockey.getFullName());
                ps2.setString(2, jockey.getPhone());
                ps2.setString(3, jockey.getEmail());
                ps2.setInt(4, jockey.getUserId());
                ps2.executeUpdate();

                conn.commit();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Cap nhat trang thai cua Jockey
    public boolean updateStatus(int jockeyId, String status) {
        String sql = "UPDATE jockeys SET jockey_status=? WHERE jockey_id=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setInt(2, jockeyId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Tang chi so luot dua va so tran thang sau moi tran dau
    public boolean incrementStats(int jockeyId, boolean won) {
        String sql = "UPDATE jockeys SET total_races = total_races + 1" +
                     (won ? ", total_wins = total_wins + 1" : "") +
                     " WHERE jockey_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, jockeyId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Map ket qua tu DB sang Java Object
    private Jockey mapRow(ResultSet rs) throws SQLException {
        Jockey j = new Jockey();
        j.setJockeyId(rs.getInt("jockey_id"));
        j.setUserId(rs.getInt("user_id"));
        j.setLicenseNumber(rs.getString("license_number"));
        j.setNationality(rs.getString("nationality"));
        Date dob = rs.getDate("date_of_birth");
        if (dob != null) j.setDateOfBirth(dob.toLocalDate());
        j.setWeight(rs.getDouble("weight"));
        j.setExperienceYears(rs.getInt("experience_years"));
        j.setTotalRaces(rs.getInt("total_races"));
        j.setTotalWins(rs.getInt("total_wins"));
        j.setProfileImageUrl(rs.getString("profile_image_url"));
        j.setJockeyStatus(rs.getString("jockey_status"));
        j.setUsername(rs.getString("username"));
        j.setEmail(rs.getString("email"));
        j.setFullName(rs.getString("full_name"));
        j.setPhone(rs.getString("phone"));
        j.setStatus(rs.getString("user_status"));
        return j;
    }
}
