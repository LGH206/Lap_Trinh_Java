package com.fe.horseracing.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fe.horseracing.DAO.RegistrationDAO;
import com.fe.horseracing.enums.RegistrationStatus;
import com.fe.horseracing.pojo.Registration;
import com.fe.horseracing.repository.interfaces.IRegistrationRepository;

@Repository
public class RegistrationRepository implements IRegistrationRepository {

    @Autowired
    private RegistrationDAO registrationDAO;
    
	@Override
	public void save(Registration registration) {
		// TODO Auto-generated method stub
		registrationDAO.save(registration);
	}

	@Override
	public void update(Registration registration) {
		// TODO Auto-generated method stub
		registrationDAO.update(registration);
	}

	@Override
	public void delete(Long registrationId) {
		// TODO Auto-generated method stub
		registrationDAO.delete(registrationId);
	}

	@Override
	public Registration findById(Long registrationId) {
		// TODO Auto-generated method stub
		return registrationDAO.findById(registrationId);
	}

	@Override
	public List<Registration> findAll() {
		// TODO Auto-generated method stub
		return registrationDAO.findAll();
	}

	@Override
	public List<Registration> findByHorse(Long horseId) {
		// TODO Auto-generated method stub
		return registrationDAO.findByHorse(horseId);
	}

	@Override
	public List<Registration> findByJockey(Long jockeyId) {
		// TODO Auto-generated method stub
		return registrationDAO.findByJockey(jockeyId);
	}

	@Override
	public List<Registration> findByRace(Long raceId) {
		// TODO Auto-generated method stub
		return registrationDAO.findByRace(raceId);
	}

	@Override
	public List<Registration> findByStatus(RegistrationStatus status) {
		// TODO Auto-generated method stub
		return registrationDAO.findByStatus(status);
	}

}
