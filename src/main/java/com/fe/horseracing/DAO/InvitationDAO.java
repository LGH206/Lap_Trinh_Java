package com.fe.horseracing.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fe.horseracing.enums.InvitationStatus;
import com.fe.horseracing.pojo.Invitation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
@Transactional
public class InvitationDAO {
    @PersistenceContext
    private EntityManager em;
    
    public void save(Invitation invitation) {
        em.persist(invitation);
    }
    
    public void update(Invitation invitation) {
        em.merge(invitation);
    }
    
    public void delete(Long invitationId) {
        Invitation invitation = em.find(Invitation.class, invitationId);
        if (invitation != null) {
            em.remove(invitation);
        }
    }
    
    public Invitation findById(Long invitationId) {
        return em.find(Invitation.class, invitationId);
    }
    
    public List<Invitation> findAll() {
        TypedQuery<Invitation> query = em.createQuery(
                        "SELECT i FROM Invitation i",
                        Invitation.class);
        return query.getResultList();
    }
    
    public List<Invitation> findBySender(Long senderId) {
        TypedQuery<Invitation> query = em.createQuery(
                "SELECT i FROM Invitation i " +
                "WHERE i.sender.userId = :senderId",
                Invitation.class);

        query.setParameter("senderId", senderId);

        return query.getResultList();
    }
    
    public List<Invitation> findByReceiver(Long receiverId) {
        TypedQuery<Invitation> query = em.createQuery(
                "SELECT i FROM Invitation i " +
                "WHERE i.receiver.userId = :receiverId",
                Invitation.class);

        query.setParameter("receiverId", receiverId);

        return query.getResultList();
    }
    
    public List<Invitation> findByRace(Long raceId) {
        TypedQuery<Invitation> query = em.createQuery(
                "SELECT i FROM Invitation i " +
                "WHERE i.race.raceId = :raceId",
                Invitation.class);

        query.setParameter("raceId", raceId);

        return query.getResultList();
    }
    
    public List<Invitation> findByRegistration(Long registrationId) {
        TypedQuery<Invitation> query = em.createQuery(
                "SELECT i FROM Invitation i " +
                "WHERE i.registration.registrationId = :registrationId",
                Invitation.class);

        query.setParameter("registrationId", registrationId);

        return query.getResultList();
    }
    
    public List<Invitation> findByStatus(InvitationStatus status) {
        TypedQuery<Invitation> query = em.createQuery(
                "SELECT i FROM Invitation i " +
                "WHERE i.status = :status",
                Invitation.class);

        query.setParameter("status", status);

        return query.getResultList();
    }

	public boolean hasPendingInvitation(Long senderId, Long receiverId, Long raceId) {
		// TODO Auto-generated method stub
		return false;
	}
}