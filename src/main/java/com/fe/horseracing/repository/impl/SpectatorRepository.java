package com.fe.horseracing.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fe.horseracing.DAO.SpectatorDAO;
import com.fe.horseracing.pojo.Spectator;
import com.fe.horseracing.repository.interfaces.ISpectatorRepository;

@Repository
public class SpectatorRepository implements ISpectatorRepository {

    @Autowired
    private SpectatorDAO spectatorDAO;

	@Override
	public void save(Spectator spectator) {
		// TODO Auto-generated method stub
		spectatorDAO.save(spectator);
	}

	@Override
	public void update(Spectator spectator) {
		// TODO Auto-generated method stub
		spectatorDAO.update(spectator);
	}

	@Override
	public void delete(Long spectatorId) {
		// TODO Auto-generated method stub
		spectatorDAO.delete(spectatorId);
	}

	@Override
	public Spectator findById(Long spectatorId) {
		// TODO Auto-generated method stub
		return spectatorDAO.findById(spectatorId);
	}

	@Override
	public List<Spectator> findAll() {
		// TODO Auto-generated method stub
		return spectatorDAO.findAll();
	}
}
