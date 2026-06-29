package com.fe.horseracing.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fe.horseracing.enums.Role;
import com.fe.horseracing.pojo.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
@Transactional
public class UserDAO {

    @PersistenceContext
    private EntityManager em;

    public void save(User user) {
        em.persist(user);
    }

    public void update(User user) {
        em.merge(user);
    }

    public void delete(Long userId) {

        User user = em.find(User.class, userId);

        if (user != null) {
            em.remove(user);
        }
    }

    public User findById(Long userId) {
        return em.find(User.class, userId);
    }

    public List<User> findAll() {
        TypedQuery<User> query = em.createQuery(
                        "SELECT u FROM User u", User.class);

        return query.getResultList();
    }

    public User findByUserName(String userName) {
        TypedQuery<User> query = em.createQuery(
                        "SELECT u FROM User u WHERE u.userName = :userName", User.class);

        query.setParameter("userName", userName);
        return query.getResultStream().findFirst().orElse(null);
    }

    public User findByEmail(String email) {
        TypedQuery<User> query = em.createQuery(
                        "SELECT u FROM User u WHERE u.email = :email", User.class);

        query.setParameter("email", email);
        return query.getResultStream().findFirst().orElse(null);
    }

    public List<User> findByRole(Role role) {
        TypedQuery<User> query = em.createQuery(
                        "SELECT u FROM User u WHERE u.role = :role", User.class);

        query.setParameter("role", role);
        return query.getResultList();
    }

}