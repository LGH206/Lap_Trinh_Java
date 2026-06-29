package com.fe.horseracing.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fe.horseracing.DAO.RaceDAO;
import com.fe.horseracing.enums.RaceStatus;
import com.fe.horseracing.pojo.Race;
import com.fe.horseracing.repository.interfaces.IRaceRepository;

@Repository
public class RaceRepository implements IRaceRepository {

    @Autowired
    private RaceDAO raceDAO;
    
	@Override
	public void save(Race race) {
		// TODO Auto-generated method stub
		raceDAO.save(race);
	}

	@Override
	public void update(Race race) {
		// TODO Auto-generated method stub
		raceDAO.update(race);
	}

	@Override
	public void delete(Long raceId) {
		// TODO Auto-generated method stub
		raceDAO.delete(raceId);
	}

	@Override
	public Race findById(Long raceId) {
		// TODO Auto-generated method stub
		return raceDAO.findById(raceId);
	}

	@Override
	public List<Race> findAll() {
		// TODO Auto-generated method stub
		return raceDAO.findAll();
	}

	@Override
	public List<Race> findByTournament(Long tournamentId) {
		// TODO Auto-generated method stub
		return raceDAO.findByTournament(tournamentId);
	}

	@Override
	public List<Race> findByReferee(Long refereeId) {
		// TODO Auto-generated method stub
		return raceDAO.findByReferee(refereeId);
	}

	@Override
	public List<Race> findByStatus(RaceStatus status) {
		// TODO Auto-generated method stub
		return raceDAO.findByStatus(status);
	}

	@Override
	public List<Race> findByJockey(Long jockeyId) {
		// TODO Auto-generated method stub
		return raceDAO.findByJockey(jockeyId);
	}

	@Override
	public List<Race> findByOwner(Long ownerId) {
		// TODO Auto-generated method stub
		return raceDAO.findByOwner(ownerId);
	}

}
