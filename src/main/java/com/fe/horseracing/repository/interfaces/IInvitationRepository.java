package com.fe.horseracing.repository.interfaces;

import java.util.List;

import com.fe.horseracing.enums.InvitationStatus;
import com.fe.horseracing.pojo.Invitation;

public interface IInvitationRepository {
    // CREATE
    void save(Invitation invitation);

    // UPDATE
    void update(Invitation invitation);

    // DELETE
    void delete(Long invitationId);

    // READ
    Invitation findById(Long invitationId);

    List<Invitation> findAll();

    // QUERY
    List<Invitation> findBySender(Long senderId);

    List<Invitation> findByReceiver(Long receiverId);

    List<Invitation> findByRace(Long raceId);

    List<Invitation> findByRegistration(Long registrationId);

    List<Invitation> findByStatus(InvitationStatus status);

	boolean hasPendingInvitation(Long senderId, Long receiverId, Long raceId);
}
