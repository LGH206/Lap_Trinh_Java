package com.fe.horseracing.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fe.horseracing.enums.InvitationStatus;
import com.fe.horseracing.pojo.Invitation;
import com.fe.horseracing.repository.interfaces.IInvitationRepository;
import com.fe.horseracing.service.interfaces.IInvitationService;

@Service
public class InvitationService implements IInvitationService {

    private IInvitationRepository invitationRepo;

    @Autowired
    public InvitationService(IInvitationRepository invitationRepo) {
        this.invitationRepo = invitationRepo;
    }    
        
	@Override
	public void save(Invitation invitation) {
		// TODO Auto-generated method stub
		invitationRepo.save(invitation);
	}

	@Override
	public void update(Invitation invitation) {
		// TODO Auto-generated method stub
		invitationRepo.update(invitation);
	}

	@Override
	public void delete(Long invitationId) {
		// TODO Auto-generated method stub
		invitationRepo.delete(invitationId);
	}

	@Override
	public Invitation findById(Long invitationId) {
		// TODO Auto-generated method stub
		return invitationRepo.findById(invitationId);
	}

	@Override
	public List<Invitation> findAll() {
		// TODO Auto-generated method stub
		return invitationRepo.findAll();
	}

	@Override
	public List<Invitation> findBySender(Long senderId) {
		// TODO Auto-generated method stub
		return invitationRepo.findBySender(senderId);
	}

	@Override
	public List<Invitation> findByReceiver(Long receiverId) {
		// TODO Auto-generated method stub
		return invitationRepo.findByReceiver(receiverId);
	}

	@Override
	public List<Invitation> findByRace(Long raceId) {
		// TODO Auto-generated method stub
		return invitationRepo.findByRace(raceId);
	}

	@Override
	public List<Invitation> findByRegistration(Long registrationId) {
		// TODO Auto-generated method stub
		return invitationRepo.findByRegistration(registrationId);
	}

	@Override
	public List<Invitation> findByStatus(InvitationStatus status) {
		// TODO Auto-generated method stub
		return invitationRepo.findByStatus(status);
	}

	@Override
	public void sendInvitation(Invitation invitation) {
		// TODO Auto-generated method stub
	    if (invitation == null)
	        return;

	    if (hasPendingInvitation(
	            invitation.getSender().getUserId(),
	            invitation.getReceiver().getUserId(),
	            invitation.getRace().getRaceId())) {
	        return;
	    }
	    
	    invitation.setStatus(InvitationStatus.PENDING);
	    invitation.setSentDate(LocalDateTime.now());
	    
	    save(invitation);
	}

	@Override
	public void acceptInvitation(Long invitationId) {
		// TODO Auto-generated method stub
	    Invitation invitation = findById(invitationId);

	    if (invitation == null)
	        return;

	    invitation.setStatus(InvitationStatus.ACCEPTED);
	    invitation.setResponseDate(LocalDateTime.now());
	    update(invitation);
	}

	@Override
	public void rejectInvitation(Long invitationId) {
		// TODO Auto-generated method stub
	    Invitation invitation = findById(invitationId);

	    if (invitation == null)
	        return;

	    invitation.setStatus(InvitationStatus.REJECTED);
	    invitation.setResponseDate(LocalDateTime.now());
	    update(invitation);
	}

	@Override
	public void cancelInvitation(Long invitationId) {
		// TODO Auto-generated method stub
	    Invitation invitation = findById(invitationId);

	    if (invitation == null)
	        return;

	    invitation.setStatus(InvitationStatus.CANCELLED);
	    update(invitation);
	}

	@Override
	public void expireInvitations() {
		// TODO Auto-generated method stub
		List<Invitation> invitations = findByStatus(InvitationStatus.PENDING);

	    for (Invitation invitation : invitations) {

	        if (!invitation.isExpired())
	            continue;

	        invitation.setStatus(InvitationStatus.EXPIRED);
	        update(invitation);
        }
	}

	@Override
	public boolean hasPendingInvitation(Long senderId, Long receiverId, Long raceId) {
		// TODO Auto-generated method stub
		return invitationRepo.hasPendingInvitation(senderId, receiverId, raceId);
	}
	
}
