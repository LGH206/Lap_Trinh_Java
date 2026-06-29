package com.fe.horseracing.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fe.horseracing.DAO.InvitationDAO;
import com.fe.horseracing.enums.InvitationStatus;
import com.fe.horseracing.pojo.Invitation;
import com.fe.horseracing.repository.interfaces.IInvitationRepository;

@Repository
public class InvitationRepository implements IInvitationRepository {

    @Autowired
    private InvitationDAO invitationDAO;
    
	@Override
	public void save(Invitation invitation) {
		// TODO Auto-generated method stub
		invitationDAO.save(invitation);
	}

	@Override
	public void update(Invitation invitation) {
		// TODO Auto-generated method stub
		invitationDAO.update(invitation);
	}

	@Override
	public void delete(Long invitationId) {
		// TODO Auto-generated method stub
		invitationDAO.delete(invitationId);
	}

	@Override
	public Invitation findById(Long invitationId) {
		// TODO Auto-generated method stub
		return invitationDAO.findById(invitationId);
	}

	@Override
	public List<Invitation> findAll() {
		// TODO Auto-generated method stub
		return invitationDAO.findAll();
	}

	@Override
	public List<Invitation> findBySender(Long senderId) {
		// TODO Auto-generated method stub
		return invitationDAO.findBySender(senderId);
	}

	@Override
	public List<Invitation> findByReceiver(Long receiverId) {
		// TODO Auto-generated method stub
		return invitationDAO.findByReceiver(receiverId);
	}

	@Override
	public List<Invitation> findByRace(Long raceId) {
		// TODO Auto-generated method stub
		return invitationDAO.findByRace(raceId);
	}

	@Override
	public List<Invitation> findByRegistration(Long registrationId) {
		// TODO Auto-generated method stub
		return invitationDAO.findByRegistration(registrationId);
	}

	@Override
	public List<Invitation> findByStatus(InvitationStatus status) {
		// TODO Auto-generated method stub
		return invitationDAO.findByStatus(status);
	}

	@Override
	public boolean hasPendingInvitation(Long senderId, Long receiverId, Long raceId) {
		// TODO Auto-generated method stub
	    return invitationDAO.hasPendingInvitation(senderId, receiverId, raceId);
	}

}
