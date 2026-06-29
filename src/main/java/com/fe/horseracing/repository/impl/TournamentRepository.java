package com.fe.horseracing.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fe.horseracing.DAO.TournamentDAO;
import com.fe.horseracing.enums.TournamentStatus;
import com.fe.horseracing.pojo.Tournament;
import com.fe.horseracing.repository.interfaces.ITournamentRepository;

@Repository
public class TournamentRepository implements ITournamentRepository {

    @Autowired
    private TournamentDAO tournamentDAO;
    
	@Override
	public void save(Tournament tournament) {
		// TODO Auto-generated method stub
		tournamentDAO.save(tournament);
	}

	@Override
	public void update(Tournament tournament) {
		// TODO Auto-generated method stub
		tournamentDAO.update(tournament);
	}

	@Override
	public void delete(Long tournamentId) {
		// TODO Auto-generated method stub
		tournamentDAO.delete(tournamentId);
	}

	@Override
	public Tournament findById(Long tournamentId) {
		// TODO Auto-generated method stub
		return tournamentDAO.findById(tournamentId);
	}

	@Override
	public List<Tournament> findAll() {
		// TODO Auto-generated method stub
		return tournamentDAO.findAll();
	}

	@Override
	public List<Tournament> findByStatus(TournamentStatus status) {
		// TODO Auto-generated method stub
		return tournamentDAO.findByStatus(status);
	}

	@Override
	public List<Tournament> findUpcomingTournaments() {
		// TODO Auto-generated method stub
		return tournamentDAO.findUpcomingTournaments();
	}

	@Override
	public List<Tournament> findOngoingTournaments() {
		// TODO Auto-generated method stub
		return tournamentDAO.findOngoingTournaments();
	}

	@Override
	public List<Tournament> findFinishedTournaments() {
		// TODO Auto-generated method stub
		return tournamentDAO.findFinishedTournaments();
	}

}
