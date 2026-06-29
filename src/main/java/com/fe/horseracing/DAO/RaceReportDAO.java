package com.fe.horseracing.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fe.horseracing.pojo.RaceReport;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
@Transactional
public class RaceReportDAO {
	
    @PersistenceContext
    private EntityManager em;

    public void save(RaceReport report) {
        em.persist(report);
    }

    public void update(RaceReport report) {
        em.merge(report);
    }

    public void delete(Long reportId) {
        RaceReport report =em.find(RaceReport.class, reportId);
        if (report != null) {
            em.remove(report);
        }
    }

    public RaceReport findById(Long reportId) {
        return em.find(RaceReport.class, reportId);
    }

    public List<RaceReport> findAll() {
        TypedQuery<RaceReport> query = em.createQuery(
                        "SELECT r FROM RaceReport r",
                        RaceReport.class);
        return query.getResultList();
    }

    public List<RaceReport> findByRace(Long raceId) {
        TypedQuery<RaceReport> query = em.createQuery(
                        "SELECT r FROM RaceReport r " +
                        "WHERE r.race.raceId = :raceId",
                        RaceReport.class);
        query.setParameter("raceId", raceId);
        return query.getResultList();
    }

    public List<RaceReport> findByReferee(Long refereeId) {
        TypedQuery<RaceReport> query = em.createQuery(
                        "SELECT r FROM RaceReport r " +
                        "WHERE r.referee.userId = :refereeId",
                        RaceReport.class);
        query.setParameter("refereeId", refereeId);
        return query.getResultList();
    }
}
