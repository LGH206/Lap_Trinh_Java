package com.horseracing.repository;
import com.horseracing.entity.Invitation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class InvitationDAO {
    @Autowired
    private DataSource dataSource;
    private Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    public int create(Invitation inv) {
        String sql = "INSERT INTO invitations " + "(registration_id, owner_id, jockey_id, horse_id, race_id, status, message, sent_at, expires_at) " + "VALUES (?, ?, ?, ?, ?, 'PENDING', ?, NOW(), ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, inv.getRegistrationId());
            ps.setInt(2, inv.getOwnerId());
            ps.setInt(3, inv.getJockeyId());
            ps.setInt(4, inv.getHorseId());
            ps.setInt(5, inv.getRaceId());
            ps.setString(6, inv.getMessage());
            ps.setTimestamp(7, inv.getExpiresAt() != null ? Timestamp.valueOf(inv.getExpiresAt()) : null);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                inv.setInvitationId(id);
                return id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    public Invitation findById(int id) {
        String sql = "SELECT * FROM invitations WHERE invitation_id = ?";
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

    public List<Invitation> findByJockeyId(int jockeyId) {
        return findByField("jockey_id", jockeyId);
    }

    public List<Invitation> findByOwnerId(int ownerId) {
        return findByField("owner_id", ownerId);
    }

    public List<Invitation> findByRaceId(int raceId) {
        return findByField("race_id", raceId);
    }

    public List<Invitation> findPendingByJockeyId(int jockeyId) {
        String sql = "SELECT * FROM invitations WHERE jockey_id=? AND status='PENDING' " + "AND (expires_at IS NULL OR expires_at > NOW()) ORDER BY sent_at DESC";
        List<Invitation> list = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, jockeyId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) list.add(mapRow(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public boolean hasPendingInvitation(int jockeyId, int raceId) {
        String sql = "SELECT COUNT(*) FROM invitations WHERE jockey_id=? AND race_id=? AND status='PENDING'";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, jockeyId);
            ps.setInt(2, raceId);
            ResultSet rs = ps.executeQuery();
            return rs.next() && rs.getInt(1) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean respond(int invitationId, String status, String responseMessage) {
        String sql = "UPDATE invitations SET status=?, response_message=?, responded_at=NOW() " + "WHERE invitation_id=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setString(2, responseMessage);
            ps.setInt(3, invitationId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean cancelByRegistration(int registrationId) {
        String sql = "UPDATE invitations SET status='CANCELLED' WHERE registration_id=? AND status='PENDING'";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, registrationId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private List<Invitation> findByField(String field, int value) {
        String sql = "SELECT * FROM invitations WHERE " + field + " = ? ORDER BY sent_at DESC";
        List<Invitation> list = new ArrayList<>();
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

    private Invitation mapRow(ResultSet rs) throws SQLException {
        Invitation inv = new Invitation();
        inv.setInvitationId(rs.getInt("invitation_id"));
        inv.setRegistrationId(rs.getInt("registration_id"));
        inv.setOwnerId(rs.getInt("owner_id"));
        inv.setJockeyId(rs.getInt("jockey_id"));
        inv.setHorseId(rs.getInt("horse_id"));
        inv.setRaceId(rs.getInt("race_id"));
        inv.setStatus(rs.getString("status"));
        inv.setMessage(rs.getString("message"));
        inv.setResponseMessage(rs.getString("response_message"));
        Timestamp sentAt = rs.getTimestamp("sent_at");
        if (sentAt != null) inv.setSentAt(sentAt.toLocalDateTime());
        Timestamp respondedAt = rs.getTimestamp("responded_at");
        if (respondedAt != null) inv.setRespondedAt(respondedAt.toLocalDateTime());
        Timestamp expiresAt = rs.getTimestamp("expires_at");
        if (expiresAt != null) inv.setExpiresAt(expiresAt.toLocalDateTime());
        return inv;
    }
}
