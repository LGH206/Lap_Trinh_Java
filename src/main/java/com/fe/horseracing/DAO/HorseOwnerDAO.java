package com.fe.horseracing.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fe.horseracing.pojo.HorseOwner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
@Transactional
public class HorseOwnerDAO {

    @PersistenceContext
    private EntityManager em;

    // CREATE
    public void save(HorseOwner owner) {
        em.persist(owner);
    }

    // UPDATE
    public void update(HorseOwner owner) {
        em.merge(owner);
    }

    // DELETE
    public void delete(Long ownerId) {

        HorseOwner owner = em.find(HorseOwner.class, ownerId);

        if (owner != null) {
            em.remove(owner);
        }
    }

    // FIND BY ID
    public HorseOwner findById(Long ownerId) {
        return em.find(HorseOwner.class, ownerId);
    }

    // FIND ALL
    public List<HorseOwner> findAll() {

        TypedQuery<HorseOwner> query = em.createQuery(
                "SELECT h FROM HorseOwner h",
                HorseOwner.class);

        return query.getResultList();
    }

}