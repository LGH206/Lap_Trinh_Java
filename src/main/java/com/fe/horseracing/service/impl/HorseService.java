package com.fe.horseracing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fe.horseracing.enums.HorseStatus;
import com.fe.horseracing.pojo.Horse;
import com.fe.horseracing.pojo.Jockey;
import com.fe.horseracing.repository.interfaces.IHorseRepository;
import com.fe.horseracing.repository.interfaces.IJockeyRepository;
import com.fe.horseracing.service.interfaces.IHorseService;
import com.fe.horseracing.service.interfaces.IJockeyService;

@Service
public class HorseService implements IHorseService {

    private IHorseRepository horseRepo;
    private IJockeyRepository jockeyRepo;

    @Autowired
    public HorseService(
    		IHorseRepository horseRepo,
    		IJockeyRepository jockeyRepo) 
    {
        this.horseRepo = horseRepo;
        this.jockeyRepo = jockeyRepo;
    }
    
	@Override
	public void save(Horse horse) {
		// TODO Auto-generated method stub
		horseRepo.save(horse);
	}

	@Override
	public void update(Horse horse) {
		// TODO Auto-generated method stub
		horseRepo.update(horse);
	}

	@Override
	public void delete(Long horseId) {
		// TODO Auto-generated method stub
		horseRepo.delete(horseId);
	}

	@Override
	public Horse findById(Long horseId) {
		// TODO Auto-generated method stub
		return horseRepo.findById(horseId);
	}

	@Override
	public List<Horse> findAll() {
		// TODO Auto-generated method stub
		return horseRepo.findAll();
	}

	@Override
	public List<Horse> findByOwner(Long ownerId) {
		// TODO Auto-generated method stub
		return horseRepo.findByOwner(ownerId);
	}

	@Override
	public List<Horse> findByStatus(HorseStatus status) {
		// TODO Auto-generated method stub
		return horseRepo.findByStatus(status);
	}

	@Override
	public List<Horse> findVerified() {
		// TODO Auto-generated method stub
		return horseRepo.findVerified();
	}

	@Override
	public List<Horse> findUnverified() {
		// TODO Auto-generated method stub
		return horseRepo.findUnverified();
	}

	@Override
	public void assignJockey(Long horseId, Long jockeyId) {
		// TODO Auto-generated method stub
	    Horse horse = findById(horseId);
	    if (horse == null)
	        return;

	    Jockey jockey = jockeyRepo.findById(jockeyId);
	    if (jockey == null)
	        return;

	    horse.setJockey(jockey);
	    update(horse);
	}

	@Override
	public void verifyHorse(Long horseId) {
		// TODO Auto-generated method stub
	    Horse horse = findById(horseId);

	    if (horse == null)
	        return;

	    horse.setVerified(true);
	    horse.setStatus(HorseStatus.AVAILABLE);
	    update(horse);
    }

	@Override
	public void updateMedicalCertificate(Long horseId, String certificate) {
		// TODO Auto-generated method stub
		Horse horse = findById(horseId);

		if (horse == null)
		    return;

		horse.setMedicalCertificate(certificate);
		update(horse);
	}

	@Override
	public void changeStatus(Long horseId, HorseStatus status) {
		// TODO Auto-generated method stub
		Horse horse = findById(horseId);

		if (horse == null)
		    return;

		horse.setStatus(status);
		update(horse);
	}

	@Override
	public void removeJockey(Long horseId) {
		// TODO Auto-generated method stub
	    Horse horse = findById(horseId);
	    if (horse == null)
	        return;

	    horse.setJockey(null);
	    update(horse);
	}

	@Override
	public void rejectHorse(Long horseId) {
		// TODO Auto-generated method stub
	    Horse horse = findById(horseId);

	    if(horse==null)
	        return;

	    horse.setVerified(false);
	    horse.setStatus(HorseStatus.RETIRED);
	    update(horse);
	}

	@Override
	public void approveHorse(Long horseId) {
		// TODO Auto-generated method stub
	    Horse horse = findById(horseId);

	    if (horse == null)
	        return;

	    horse.setVerified(true);

	    update(horse);
	}

	@Override
	public void suspendHorse(Long horseId) {
		// TODO Auto-generated method stub
	    Horse horse = findById(horseId);

	    if (horse == null)
	        return;

	    horse.setStatus(HorseStatus.SUSPENDED);

	    update(horse);
	}
}
