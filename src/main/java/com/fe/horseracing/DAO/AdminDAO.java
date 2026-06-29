package com.fe.horseracing.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fe.horseracing.pojo.Admin;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
@Transactional
public class AdminDAO {

    @PersistenceContext
    private EntityManager em;

    public void save(Admin admin) {
        em.persist(admin);
    }

    public void update(Admin admin) {
        em.merge(admin);
    }

    public void delete(Long adminId) {
        Admin admin = em.find(Admin.class, adminId);
        
        if (admin != null) {
            em.remove(admin);
        }
    }

    public Admin findById(Long adminId) {
        return em.find(Admin.class, adminId);
    }

    public List<Admin> findAll() {
        TypedQuery<Admin> query = em.createQuery(
                "SELECT a FROM Admin a", Admin.class);
        return query.getResultList();
    }

}