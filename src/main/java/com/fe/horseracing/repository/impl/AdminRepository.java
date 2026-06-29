package com.fe.horseracing.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fe.horseracing.DAO.AdminDAO;
import com.fe.horseracing.pojo.Admin;
import com.fe.horseracing.repository.interfaces.IAdminRepository;

@Repository
public class AdminRepository implements IAdminRepository {

    @Autowired
    private AdminDAO adminDAO;
    
	@Override
	public void save(Admin admin) {
		// TODO Auto-generated method stub
		adminDAO.save(admin);
	}

	@Override
	public void update(Admin admin) {
		// TODO Auto-generated method stub
		adminDAO.update(admin);
	}

	@Override
	public void delete(Long adminId) {
		// TODO Auto-generated method stub
		adminDAO.delete(adminId);
	}

	@Override
	public Admin findById(Long adminId) {
		// TODO Auto-generated method stub
		return adminDAO.findById(adminId);
	}

	@Override
	public List<Admin> findAll() {
		// TODO Auto-generated method stub
		return adminDAO.findAll();
	}

}
