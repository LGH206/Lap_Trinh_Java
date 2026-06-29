package com.fe.horseracing.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fe.horseracing.pojo.Spectator;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
@Transactional
public class SpectatorDAO {

    @PersistenceContext
    private EntityManager em;

    public void save(Spectator spectator) {
        em.persist(spectator);
    }

    public void update(Spectator spectator) {
        em.merge(spectator);
    }

    public void delete(Long spectatorId) {
        Spectator spectator = em.find(Spectator.class, spectatorId);

        if (spectator != null) {
            em.remove(spectator);
        }
    }

    public Spectator findById(Long spectatorId) {
        return em.find(Spectator.class, spectatorId);
    }

    public List<Spectator> findAll() {
        TypedQuery<Spectator> query = em.createQuery(
                "SELECT s FROM Spectator s", Spectator.class);

        return query.getResultList();
    }
}