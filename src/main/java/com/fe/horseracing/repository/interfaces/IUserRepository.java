package com.fe.horseracing.repository.interfaces;

import java.util.List;

import com.fe.horseracing.enums.Role;
import com.fe.horseracing.pojo.User;

public interface IUserRepository {

    // CRUD

    void save(User user);

    void update(User user);

    void delete(Long userId);

    User findById(Long userId);

    List<User> findAll();

    // Query

    User findByUserName(String userName);

    User findByEmail(String email);

    List<User> findByRole(Role role);

}