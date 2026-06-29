package com.fe.horseracing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fe.horseracing.enums.RaceStatus;
import com.fe.horseracing.pojo.Race;
import com.fe.horseracing.pojo.RaceReferee;
import com.fe.horseracing.repository.interfaces.IRaceRefereeRepository;
import com.fe.horseracing.repository.interfaces.IRaceRepository;
import com.fe.horseracing.service.interfaces.IRaceRefereeService;
import com.fe.horseracing.service.interfaces.IRaceService;

@Service
public class RaceService implements IRaceService {

    private IRaceRepository raceRepo;
    private IRaceRefereeRepository refereeRepo;

    @Autowired
    public RaceService(
    		IRaceRepository raceRepo,
    		IRaceRefereeRepository refereeRepo) 
    {
        this.raceRepo = raceRepo;
        this.refereeRepo = refereeRepo;
    }
    
	@Override
	public void save(Race race) {
		// TODO Auto-generated method stub
		raceRepo.save(race);
	}

	@Override
	public void update(Race race) {
		// TODO Auto-generated method stub
		raceRepo.update(race);
	}

	@Override
	public void delete(Long raceId) {
		// TODO Auto-generated method stub
		raceRepo.delete(raceId);
	}

	@Override
	public Race findById(Long raceId) {
		// TODO Auto-generated method stub
		return raceRepo.findById(raceId);
	}

	@Override
	public List<Race> findAll() {
		// TODO Auto-generated method stub
		return raceRepo.findAll();
	}

	@Override
	public List<Race> findByTournament(Long tournamentId) {
		// TODO Auto-generated method stub
		return raceRepo.findByTournament(tournamentId);
	}

	@Override
	public List<Race> findByReferee(Long refereeId) {
		// TODO Auto-generated method stub
		return raceRepo.findByReferee(refereeId);
	}

	@Override
	public List<Race> findByStatus(RaceStatus status) {
		// TODO Auto-generated method stub
		return raceRepo.findByStatus(status);
	}

	@Override
	public void scheduleRace(Long raceId) {
		// TODO Auto-generated method stub
	    Race race = findById(raceId);

	    if (race == null)
	        return;

	    race.setStatus(RaceStatus.SCHEDULED);
	    update(race);
	}

	@Override
	public void assignReferee(Long raceId, Long refereeId) {
		// TODO Auto-generated method stub
	    Race race = findById(raceId);

	    if (race == null)
	        return;

	    RaceReferee referee = refereeRepo.findById(refereeId);

	    if (referee == null)
	        return;

	    race.setReferee(referee);
	    update(race);
	}

	@Override
	public void startRace(Long raceId) {
		// TODO Auto-generated method stub
	    Race race = findById(raceId);

	    if (race == null)
	        return;

	    if (race.getStatus() != RaceStatus.SCHEDULED)
	        return;

	    race.setStatus(RaceStatus.RUNNING);
	    update(race);
	}

	@Override
	public void finishRace(Long raceId) {
		// TODO Auto-generated method stub
	    Race race = findById(raceId);

	    if (race == null)
	        return;

	    if (race.getStatus() != RaceStatus.RUNNING)
	        return;

	    race.setStatus(RaceStatus.FINISHED);
	    update(race);
	}

	@Override
	public void cancelRace(Long raceId) {
		// TODO Auto-generated method stub
	    Race race = findById(raceId);

	    if (race == null)
	        return;

	    if (race.getStatus() == RaceStatus.FINISHED)
	        return;

	    race.setStatus(RaceStatus.CANCELLED);
	    update(race);
	}

	@Override
	public List<Race> findByOwner(Long ownerId) {
		// TODO Auto-generated method stub
		return raceRepo.findByOwner(ownerId);
	}

	@Override
	public List<Race> findByJockey(Long jockeyId) {
		// TODO Auto-generated method stub
		return raceRepo.findByJockey(jockeyId);
	}
}
