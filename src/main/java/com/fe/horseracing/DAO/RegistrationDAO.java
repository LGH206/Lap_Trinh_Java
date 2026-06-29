package com.fe.horseracing.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fe.horseracing.enums.RegistrationStatus;
import com.fe.horseracing.pojo.Registration;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
@Transactional
public class RegistrationDAO {

    @PersistenceContext
    private EntityManager em;

    // CREATE
    public void save(Registration registration) {
        em.persist(registration);
    }

    // UPDATE
    public void update(Registration registration) {
        em.merge(registration);
    }

    // DELETE
    public void delete(Long registrationId) {
        Registration registration = em.find(Registration.class, registrationId);

        if (registration != null) {
            em.remove(registration);
        }
    }

    // FIND BY ID
    public Registration findById(Long registrationId) {
        return em.find(Registration.class, registrationId);
    }

    // FIND ALL
    public List<Registration> findAll() {
        TypedQuery<Registration> query = em.createQuery(
                "SELECT r FROM Registration r", Registration.class);

        return query.getResultList();
    }

    // FIND BY HORSE
    public List<Registration> findByHorse(Long horseId) {
        TypedQuery<Registration> query = em.createQuery(
                "SELECT r FROM Registration r WHERE r.horse.horseId = :horseId", Registration.class);

        query.setParameter("horseId", horseId);
        return query.getResultList();
    }

    // FIND BY JOCKEY
    public List<Registration> findByJockey(Long jockeyId) {
        TypedQuery<Registration> query = em.createQuery(
                "SELECT r FROM Registration r WHERE r.jockey.userId = :jockeyId", Registration.class);

        query.setParameter("jockeyId", jockeyId);
        return query.getResultList();
    }

    // FIND BY RACE
    public List<Registration> findByRace(Long raceId) {
        TypedQuery<Registration> query = em.createQuery(
                "SELECT r FROM Registration r WHERE r.race.raceId = :raceId", Registration.class);

        query.setParameter("raceId", raceId);
        return query.getResultList();
    }

    // FIND BY STATUS
    public List<Registration> findByStatus(RegistrationStatus status) {
        TypedQuery<Registration> query = em.createQuery(
                "SELECT r FROM Registration r WHERE r.status = :status", Registration.class);

        query.setParameter("status", status);
        return query.getResultList();
    }
}
