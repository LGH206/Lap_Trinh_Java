package com.fe.horseracing.DAO;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.fe.horseracing.pojo.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.NoResultException;

@Repository
@Transactional
public class RoleDAO {
    
    @PersistenceContext
    private EntityManager em;

    public void save(Role role) {
        em.persist(role);
    }

    public void update(Role role) {
        em.merge(role);
    }

    public Role findById(Long roleId) {
        return em.find(Role.class, roleId);
    }

    public List<Role> findAll() {
        TypedQuery<Role> query = em.createQuery(
                "SELECT r FROM Role r", Role.class);
        return query.getResultList();
    }

    public Role findByRoleName(String roleName) {
        try {
            TypedQuery<Role> query = em.createQuery(
                    "SELECT r FROM Role r WHERE r.roleName = :roleName", Role.class);
            query.setParameter("roleName", roleName);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
