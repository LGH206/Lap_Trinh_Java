package com.fe.horseracing.service.interfaces;

import java.util.List;

import com.fe.horseracing.enums.Role;
import com.fe.horseracing.pojo.User;

public interface IUserService {

    void save(User user);

    void update(User user);

    void delete(Long userId);

    User findById(Long userId);

    List<User> findAll();

    User findByUserName(String userName);

    User findByEmail(String email);

    List<User> findByRole(Role role);

    void register(User user);

    User login(String userName, String password);

    void changePassword(Long userId, String newPassword);

    void lockUser(Long userId);

    void unlockUser(Long userId);
    
    boolean existsByEmail(String email);

    boolean existsByUserName(String userName);

	void assignRole(Long userId, Role role);

}