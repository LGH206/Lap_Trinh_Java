package com.fe.horseracing.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fe.horseracing.DAO.UserDAO;
import com.fe.horseracing.enums.Role;
import com.fe.horseracing.pojo.User;
import com.fe.horseracing.repository.interfaces.IUserRepository;

@Repository
public class UserRepository implements IUserRepository {

    @Autowired
    private UserDAO userDAO;
    
	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		userDAO.save(user);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		userDAO.update(user);
	}

	@Override
	public void delete(Long userId) {
		// TODO Auto-generated method stub
		userDAO.delete(userId);
	}

	@Override
	public User findById(Long userId) {
		// TODO Auto-generated method stub
		return userDAO.findById(userId);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDAO.findAll();
	}

	@Override
	public User findByUserName(String userName) {
		// TODO Auto-generated method stub
		return userDAO.findByUserName(userName);
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return userDAO.findByEmail(email);
	}

	@Override
	public List<User> findByRole(Role role) {
		// TODO Auto-generated method stub
		return userDAO.findByRole(role);	
	}
}
