package com.fe.horseracing.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fe.horseracing.enums.HorseStatus;
import com.fe.horseracing.pojo.Horse;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
@Transactional
public class HorseDAO {

    @PersistenceContext
    private EntityManager em;

    public void save(Horse horse) {
        em.persist(horse);
    }

    public void update(Horse horse) {
        em.merge(horse);
    }

    public void delete(Long horseId) {
        Horse horse = em.find(Horse.class, horseId);

        if (horse != null) {
            em.remove(horse);
        }
    }

    public Horse findById(Long horseId) {
        return em.find(Horse.class, horseId);
    }

    public List<Horse> findAll() {
        TypedQuery<Horse> query = em.createQuery(
                "SELECT h FROM Horse h", Horse.class);

        return query.getResultList();
    }

    public List<Horse> findByOwner(Long ownerId) {

        TypedQuery<Horse> query = em.createQuery(
                "SELECT h FROM Horse h WHERE h.owner.userId = :ownerId", Horse.class);

        query.setParameter("ownerId", ownerId);
        return query.getResultList();
    }

    public List<Horse> findByStatus(HorseStatus status) {
        TypedQuery<Horse> query = em.createQuery(
                "SELECT h FROM Horse h WHERE h.status = :status", Horse.class);

        query.setParameter("status", status);
        return query.getResultList();
    }

    public List<Horse> findVerified() {
        TypedQuery<Horse> query = em.createQuery(
                "SELECT h FROM Horse h WHERE h.verified = true", Horse.class);

        return query.getResultList();
    }

    public List<Horse> findUnverified() {
        TypedQuery<Horse> query = em.createQuery(
                "SELECT h FROM Horse h WHERE h.verified = false", Horse.class);

        return query.getResultList();
    }
}