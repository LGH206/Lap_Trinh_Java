package com.fe.horseracing.repository.impl;

import java.util.List;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fe.horseracing.DAO.RaceRefereeDAO;
import com.fe.horseracing.enums.RefereeStatus;
import com.fe.horseracing.pojo.RaceReferee;
import com.fe.horseracing.repository.interfaces.IRaceRefereeRepository;
@Repository
public class RaceRefereeRepository implements IRaceRefereeRepository {

    @Autowired
    private RaceRefereeDAO refereeDAO;
    
	@Override
	public void save(RaceReferee referee) {
		// TODO Auto-generated method stub
		refereeDAO.save(referee);
	}

	@Override
	public void update(RaceReferee referee) {
		// TODO Auto-generated method stub
		refereeDAO.update(referee);
	}

	@Override
	public void delete(Long refereeId) {
		// TODO Auto-generated method stub
		refereeDAO.delete(refereeId);
	}

	@Override
	public RaceReferee findById(Long refereeId) {
		// TODO Auto-generated method stub
		 return refereeDAO.findById(refereeId);
	}

	@Override
	public List<RaceReferee> findAll() {
		// TODO Auto-generated method stub
		 return refereeDAO.findAll();
	}

	@Override
	public List<RaceReferee> findByStatus(RefereeStatus status) {
		// TODO Auto-generated method stub
		return refereeDAO.findByStatus(status);
	}

	@Override
	public RaceReferee findByLicenseNumber(String licenseNumber) {
		// TODO Auto-generated method stub
		return refereeDAO.findByLicenseNumber(licenseNumber);
	}

	@Override
	public List<RaceReferee> findAvailableReferees() {
		// TODO Auto-generated method stub
		return refereeDAO.findAvailableReferees();
	}
	
}
