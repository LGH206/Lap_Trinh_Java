package com.fe.horseracing.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fe.horseracing.enums.JockeyStatus;
import com.fe.horseracing.pojo.Jockey;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
@Transactional
public class JockeyDAO {

    @PersistenceContext
    private EntityManager em;

    public void save(Jockey jockey) {
        em.persist(jockey);
    }

    public void update(Jockey jockey) {
        em.merge(jockey);
    }

    public void delete(Long jockeyId) {
        Jockey jockey = em.find(Jockey.class, jockeyId);

        if (jockey != null) {
            em.remove(jockey);
        }
    }

    public Jockey findById(Long jockeyId) {
        return em.find(Jockey.class, jockeyId);
    }

    public List<Jockey> findAll() {
        TypedQuery<Jockey> query = em.createQuery(
                "SELECT j FROM Jockey j", Jockey.class);

        return query.getResultList();
    }

    public Jockey findByLicenseNumber(String licenseNumber) {
        TypedQuery<Jockey> query = em.createQuery(
                "SELECT j FROM Jockey j WHERE j.licenseNumber = :licenseNumber", Jockey.class);

        query.setParameter("licenseNumber", licenseNumber);
        return query.getResultStream().findFirst().orElse(null);
    }

    public List<Jockey> findByStatus(JockeyStatus status) {
        TypedQuery<Jockey> query = em.createQuery(
                "SELECT j FROM Jockey j WHERE j.jockeyStatus = :status", Jockey.class);

        query.setParameter("status", status);
        return query.getResultList();
    }

    public List<Jockey> findAvailableJockeys() {
        TypedQuery<Jockey> query = em.createQuery(
                "SELECT j FROM Jockey j WHERE j.jockeyStatus = :status", Jockey.class);

        query.setParameter("status", JockeyStatus.AVAILABLE);
        return query.getResultList();
    }
}
