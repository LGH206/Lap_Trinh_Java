package com.fe.horseracing.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fe.horseracing.enums.RefereeStatus;
import com.fe.horseracing.pojo.RaceReferee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
@Transactional
public class RaceRefereeDAO {

    @PersistenceContext
    private EntityManager em;

    // CREATE
    public void save(RaceReferee referee) {
        em.persist(referee);
    }

    // UPDATE
    public void update(RaceReferee referee) {
        em.merge(referee);
    }

    // DELETE
    public void delete(Long refereeId) {
        RaceReferee referee = em.find(RaceReferee.class, refereeId);
        
        if (referee != null) {
            em.remove(referee);
        }
    }

    // FIND BY ID
    public RaceReferee findById(Long refereeId) {
        return em.find(RaceReferee.class, refereeId);
    }

    // FIND ALL
    public List<RaceReferee> findAll() {
        TypedQuery<RaceReferee> query = em.createQuery(
                "SELECT r FROM RaceReferee r",
                RaceReferee.class);

        return query.getResultList();
    }

    // FIND BY STATUS
    public List<RaceReferee> findByStatus(RefereeStatus status) {
        TypedQuery<RaceReferee> query = em.createQuery(
                "SELECT r FROM RaceReferee r WHERE r.status = :status",
                RaceReferee.class);

        query.setParameter("status", status);

        return query.getResultList();
    }

    // FIND BY LICENSE
    public RaceReferee findByLicenseNumber(String licenseNumber) {
        TypedQuery<RaceReferee> query = em.createQuery(
                "SELECT r FROM RaceReferee r " +
                "WHERE r.licenseNumber = :license",
                RaceReferee.class);

        query.setParameter("license", licenseNumber);
        List<RaceReferee> result = query.getResultList();
        return result.isEmpty() ? null : result.get(0);
    }

    // FIND AVAILABLE REFEREES
    public List<RaceReferee> findAvailableReferees() {
        TypedQuery<RaceReferee> query = em.createQuery(
                "SELECT r FROM RaceReferee r " +
                "WHERE r.status = :status",
                RaceReferee.class);

        query.setParameter("status", RefereeStatus.ACTIVE);

        return query.getResultList();
    }
}