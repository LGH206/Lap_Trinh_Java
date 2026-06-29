package com.fe.horseracing.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fe.horseracing.enums.TournamentStatus;
import com.fe.horseracing.pojo.Tournament;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
@Transactional
public class TournamentDAO {

    @PersistenceContext
    private EntityManager em;

    // CREATE
    public void save(Tournament tournament) {
        em.persist(tournament);
    }

    // UPDATE
    public void update(Tournament tournament) {
        em.merge(tournament);
    }

    // DELETE
    public void delete(Long tournamentId) {
        Tournament tournament = em.find(Tournament.class, tournamentId);

        if (tournament != null) {
            em.remove(tournament);
        }
    }

    // FIND BY ID
    public Tournament findById(Long tournamentId) {
        return em.find(Tournament.class, tournamentId);
    }

    // FIND ALL
    public List<Tournament> findAll() {
        TypedQuery<Tournament> query = em.createQuery(
                "SELECT t FROM Tournament t ORDER BY t.startDate DESC",
                Tournament.class);

        return query.getResultList();
    }

    // FIND BY STATUS
    public List<Tournament> findByStatus(TournamentStatus status) {
        TypedQuery<Tournament> query = em.createQuery(
                "SELECT t FROM Tournament t WHERE t.status = :status",
                Tournament.class);

        query.setParameter("status", status);

        return query.getResultList();
    }

    // UPCOMING
    public List<Tournament> findUpcomingTournaments() {
        return findByStatus(TournamentStatus.DRAFT);
    }

    // ONGOING
    public List<Tournament> findOngoingTournaments() {
        return findByStatus(TournamentStatus.ONGOING);
    }

    // FINISHED
    public List<Tournament> findFinishedTournaments() {
        return findByStatus(TournamentStatus.FINISHED);
    }
}
