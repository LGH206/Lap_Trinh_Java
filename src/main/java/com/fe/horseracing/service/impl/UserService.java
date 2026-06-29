package com.fe.horseracing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fe.horseracing.enums.Role;
import com.fe.horseracing.pojo.User;
import com.fe.horseracing.repository.interfaces.IUserRepository;
import com.fe.horseracing.service.interfaces.IUserService;

@Service
public class UserService implements IUserService {

    private IUserRepository userRepo;

    @Autowired
    public UserService(IUserRepository userRepo) {
        this.userRepo = userRepo;
    }
    
	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		userRepo.save(user);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		userRepo.update(user);
	}

	@Override
	public void delete(Long userId) {
		// TODO Auto-generated method stub
		userRepo.delete(userId);
	}

	@Override
	public User findById(Long userId) {
		// TODO Auto-generated method stub
		return userRepo.findById(userId);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public User findByUserName(String userName) {
		// TODO Auto-generated method stub
		return userRepo.findByUserName(userName);
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepo.findByEmail(email);
	}

	@Override
	public List<User> findByRole(Role role) {
		// TODO Auto-generated method stub
		return userRepo.findByRole(role);
	}

	@Override
	public void register(User user) {
		// TODO Auto-generated method stub
	    if (existsByEmail(user.getEmail()))
	        return;

	    if (existsByUserName(user.getUserName()))
	        return;

	    save(user);
	}

	@Override
	public User login(String userName, String password) {
		// TODO Auto-generated method stub
        User user = findByUserName(userName);

        if (user == null)
            return null;

        if (!user.getActive())
            return null;

        if (!user.getPassword().equals(password))
            return null;

        return user;
    }

	@Override
	public void changePassword(Long userId, String newPassword) {
		// TODO Auto-generated method stub
	    User user = findById(userId);

	    if (user == null)
	        return;

	    user.setPassword(newPassword);
	    update(user);
	}

	@Override
	public void lockUser(Long userId) {
		// TODO Auto-generated method stub
	    User user = findById(userId);

	    if (user == null)
	        return;

	    user.setActive(false);
	    update(user);
	}

	@Override
	public void unlockUser(Long userId) {
		// TODO Auto-generated method stub
	    User user = findById(userId);

	    if (user == null)
	        return;

	    user.setActive(true);
	    update(user);
	}

	@Override
	public boolean existsByEmail(String email) {
		// TODO Auto-generated method stub
		return findByEmail(email) != null;
	}

	@Override
	public boolean existsByUserName(String userName) {
		// TODO Auto-generated method stub
		return findByUserName(userName) != null;
	}

	@Override
	public void assignRole(Long userId, Role role) {
		// TODO Auto-generated method stub
	    User user = findById(userId);

	    if (user == null)
	        return;

	    user.setRole(role);
	    update(user);
	}

}
