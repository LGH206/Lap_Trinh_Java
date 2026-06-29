package com.fe.horseracing.service.interfaces;

import java.util.List;

import com.fe.horseracing.enums.InvitationStatus;
import com.fe.horseracing.pojo.Invitation;

public interface IInvitationService {
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

    // BUSINESS
    void sendInvitation(Invitation invitation);

    void acceptInvitation(Long invitationId);

    void rejectInvitation(Long invitationId);

    void cancelInvitation(Long invitationId);

    void expireInvitations();
    
    boolean hasPendingInvitation( Long senderId, Long receiverId, Long raceId);
}
