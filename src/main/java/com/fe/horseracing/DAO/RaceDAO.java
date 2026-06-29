package com.fe.horseracing.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fe.horseracing.enums.RaceStatus;
import com.fe.horseracing.pojo.Race;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
@Transactional
public class RaceDAO {

    @PersistenceContext
    private EntityManager em;

    // CREATE
    public void save(Race race) {
        em.persist(race);
    }

    // UPDATE
    public void update(Race race) {
        em.merge(race);
    }

    // DELETE
    public void delete(Long raceId) {
        Race race = em.find(Race.class, raceId);

        if (race != null) {
            em.remove(race);
        }
    }

    // FIND BY ID
    public Race findById(Long raceId) {
        return em.find(Race.class, raceId);
    }

    // FIND ALL
    public List<Race> findAll() {
        TypedQuery<Race> query = em.createQuery(
                "SELECT r FROM Race r ORDER BY r.raceDate DESC", Race.class);

        return query.getResultList();
    }

    // FIND BY TOURNAMENT
    public List<Race> findByTournament(Long tournamentId) {
        TypedQuery<Race> query = em.createQuery(
                "SELECT r FROM Race r WHERE r.tournament.tournamentId = :id", Race.class);

        query.setParameter("id", tournamentId);
        return query.getResultList();
    }

    // FIND BY REFEREE
    public List<Race> findByReferee(Long refereeId) {
        TypedQuery<Race> query = em.createQuery(
                "SELECT r FROM Race r WHERE r.referee.userId = :id", Race.class);

        query.setParameter("id", refereeId);
        return query.getResultList();
    }

    // FIND BY STATUS
    public List<Race> findByStatus(RaceStatus status) {
        TypedQuery<Race> query = em.createQuery(
                "SELECT r FROM Race r WHERE r.status = :status", Race.class);

        query.setParameter("status", status);
        return query.getResultList();
    }

    public List<Race> findByJockey(Long jockeyId) {

        String jpql = """
            SELECT DISTINCT r
            FROM Registration reg
            JOIN reg.race r
            WHERE reg.jockey.userId = :jockeyId
            ORDER BY r.raceDate DESC
            """;

        return em.createQuery(jpql, Race.class)
                .setParameter("jockeyId", jockeyId)
                .getResultList();
    }

    public List<Race> findByOwner(Long ownerId) {

        String jpql = """
            SELECT DISTINCT reg.race
            FROM Registration reg
            WHERE reg.horse.owner.userId = :ownerId
            ORDER BY reg.race.raceDate DESC
            """;

        return em.createQuery(jpql, Race.class)
                .setParameter("ownerId", ownerId)
                .getResultList();
    }
}
