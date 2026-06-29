package com.fe.horseracing.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fe.horseracing.DAO.JockeyDAO;
import com.fe.horseracing.enums.JockeyStatus;
import com.fe.horseracing.pojo.Jockey;
import com.fe.horseracing.repository.interfaces.IJockeyRepository;

@Repository
public class JockeyRepository implements IJockeyRepository {

    @Autowired
    private JockeyDAO jockeyDAO;
    
	@Override
	public void save(Jockey jockey) {
		// TODO Auto-generated method stub
		jockeyDAO.save(jockey);
	}

	@Override
	public void update(Jockey jockey) {
		// TODO Auto-generated method stub
		jockeyDAO.update(jockey);
	}

	@Override
	public void delete(Long jockeyId) {
		// TODO Auto-generated method stub
		jockeyDAO.delete(jockeyId);
	}

	@Override
	public Jockey findById(Long jockeyId) {
		// TODO Auto-generated method stub
		return jockeyDAO.findById(jockeyId);
	}

	@Override
	public List<Jockey> findAll() {
		// TODO Auto-generated method stub
		return jockeyDAO.findAll();
	}

	@Override
	public Jockey findByLicenseNumber(String licenseNumber) {
		// TODO Auto-generated method stub
		return jockeyDAO.findByLicenseNumber(licenseNumber);
	}

	@Override
	public List<Jockey> findByStatus(JockeyStatus status) {
		// TODO Auto-generated method stub
		return jockeyDAO.findByStatus(status);
	}

	@Override
	public List<Jockey> findAvailableJockeys() {
		// TODO Auto-generated method stub
		return jockeyDAO.findAvailableJockeys();
	}

}
