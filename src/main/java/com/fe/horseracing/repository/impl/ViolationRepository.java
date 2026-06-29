package com.fe.horseracing.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fe.horseracing.DAO.ViolationDAO;
import com.fe.horseracing.enums.ViolationType;
import com.fe.horseracing.pojo.Violation;
import com.fe.horseracing.repository.interfaces.IViolationRepository;

@Repository
public class ViolationRepository implements IViolationRepository {

    @Autowired
    private ViolationDAO violationDAO;
    
	@Override
	public void save(Violation violation) {
		// TODO Auto-generated method stub
		violationDAO.save(violation);
	}

	@Override
	public void update(Violation violation) {
		// TODO Auto-generated method stub
		violationDAO.update(violation);
	}

	@Override
	public void delete(Long violationId) {
		// TODO Auto-generated method stub
		violationDAO.delete(violationId);
	}

	@Override
	public Violation findById(Long violationId) {
		// TODO Auto-generated method stub
		 return violationDAO.findById(violationId);
	}

	@Override
	public List<Violation> findAll() {
		// TODO Auto-generated method stub
		return violationDAO.findAll();
	}

	@Override
	public List<Violation> findByRace(Long raceId) {
		// TODO Auto-generated method stub
		return violationDAO.findByRace(raceId);
	}

	@Override
	public List<Violation> findByHorse(Long horseId) {
		// TODO Auto-generated method stub
		return violationDAO.findByHorse(horseId);
	}

	@Override
	public List<Violation> findByReferee(Long refereeId) {
		// TODO Auto-generated method stub
		return violationDAO.findByReferee(refereeId);
	}

	@Override
	public List<Violation> findByJockey(Long jockeyId) {
		// TODO Auto-generated method stub
		return violationDAO.findByJockey(jockeyId);
	}

	@Override
	public List<Violation> findByType(ViolationType violationType) {
		// TODO Auto-generated method stub
		 return violationDAO.findByType(violationType);
	}

}
