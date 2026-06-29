package com.fe.horseracing.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fe.horseracing.pojo.Prize;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
@Transactional
public class PrizeDAO {

    @PersistenceContext
    private EntityManager em;

    public void save(Prize prize) {
        em.persist(prize);
    }

    public void update(Prize prize) {
        em.merge(prize);
    }

    public void delete(Long prizeId) {
        Prize prize = em.find(Prize.class, prizeId);

        if (prize != null) {
            em.remove(prize);
        }
    }

    public Prize findById(Long prizeId) {
        return em.find(Prize.class, prizeId);
    }

    public List<Prize> findAll() {
        TypedQuery<Prize> query = em.createQuery(
                        "SELECT p FROM Prize p", Prize.class);

        return query.getResultList();
    }

    public List<Prize> findPaid() {
        TypedQuery<Prize> query = em.createQuery(
                        "SELECT p FROM Prize p WHERE p.paid = true", Prize.class);

        return query.getResultList();
    }

    public List<Prize> findUnpaid() {
        TypedQuery<Prize> query = em.createQuery(
                        "SELECT p FROM Prize p WHERE p.paid = false", Prize.class);

        return query.getResultList();
    }

    public List<Prize> findByRace(Long raceId) {

        String jpql = """
            SELECT p
            FROM Prize p
            WHERE p.raceResult.race.raceId = :raceId
            ORDER BY p.amount DESC
            """;

        return em.createQuery(jpql, Prize.class)
                .setParameter("raceId", raceId)
                .getResultList();
    }

    public List<Prize> findByOwner(Long ownerId) {

        String jpql = """
            SELECT p
            FROM Prize p
            WHERE p.raceResult.horse.owner.userId = :ownerId
            ORDER BY p.awardedAt DESC
            """;

        return em.createQuery(jpql, Prize.class)
                .setParameter("ownerId", ownerId)
                .getResultList();
    }

}