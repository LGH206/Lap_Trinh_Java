package com.fe.horseracing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fe.horseracing.enums.ViolationType;
import com.fe.horseracing.pojo.Violation;
import com.fe.horseracing.repository.interfaces.IViolationRepository;
import com.fe.horseracing.service.interfaces.IViolationService;

@Service
public class ViolationService implements IViolationService  {
	private IViolationRepository violationRepo;
	
    @Autowired
    public ViolationService(IViolationRepository violationRepo) {
        this.violationRepo = violationRepo;
    }
    
	@Override
	public void save(Violation violation) {
		// TODO Auto-generated method stub
		violationRepo.save(violation);
	}

	@Override
	public void update(Violation violation) {
		// TODO Auto-generated method stub
		violationRepo.update(violation);
	}

	@Override
	public void delete(Long violationId) {
		// TODO Auto-generated method stub
		violationRepo.delete(violationId);
	}

	@Override
	public Violation findById(Long violationId) {
		// TODO Auto-generated method stub
		return violationRepo.findById(violationId);
	}

	@Override
	public List<Violation> findAll() {
		// TODO Auto-generated method stub
		return violationRepo.findAll();
	}

	@Override
	public List<Violation> findByRace(Long raceId) {
		// TODO Auto-generated method stub
		return violationRepo.findByRace(raceId);
	}

	@Override
	public List<Violation> findByHorse(Long horseId) {
		// TODO Auto-generated method stub
		return violationRepo.findByHorse(horseId);
	}

	@Override
	public List<Violation> findByReferee(Long refereeId) {
		// TODO Auto-generated method stub
		return violationRepo.findByReferee(refereeId);
	}

	@Override
	public List<Violation> findByJockey(Long jockeyId) {
		// TODO Auto-generated method stub
		return violationRepo.findByJockey(jockeyId);
	}

	@Override
	public List<Violation> findByType(ViolationType violationType) {
		// TODO Auto-generated method stub
		return violationRepo.findByType(violationType);
	}

	@Override
	public void recordViolation(Violation violation) {
		// TODO Auto-generated method stub
	    if (violation == null)
	        return;

	    save(violation);
	}
}
