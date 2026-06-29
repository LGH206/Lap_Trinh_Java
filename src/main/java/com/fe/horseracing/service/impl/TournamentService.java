package com.fe.horseracing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fe.horseracing.enums.TournamentStatus;
import com.fe.horseracing.pojo.Tournament;
import com.fe.horseracing.repository.interfaces.ITournamentRepository;
import com.fe.horseracing.service.interfaces.ITournamentService;

@Service
public class TournamentService implements ITournamentService {

    private ITournamentRepository tournamentRepo;

    @Autowired
    public TournamentService(ITournamentRepository tournamentRepo) {
        this.tournamentRepo = tournamentRepo;
    }
    
	@Override
	public void save(Tournament tournament) {
		// TODO Auto-generated method stub
		tournamentRepo.save(tournament);
	}

	@Override
	public void update(Tournament tournament) {
		// TODO Auto-generated method stub
		tournamentRepo.update(tournament);
	}

	@Override
	public void delete(Long tournamentId) {
		// TODO Auto-generated method stub
		tournamentRepo.delete(tournamentId);
	}

	@Override
	public Tournament findById(Long tournamentId) {
		// TODO Auto-generated method stub
		return tournamentRepo.findById(tournamentId);
	}

	@Override
	public List<Tournament> findAll() {
		// TODO Auto-generated method stub
		return tournamentRepo.findAll();
	}

	@Override
	public List<Tournament> findByStatus(TournamentStatus status) {
		// TODO Auto-generated method stub
		return tournamentRepo.findByStatus(status);
	}

	@Override
	public List<Tournament> findUpcomingTournaments() {
		// TODO Auto-generated method stub
		return tournamentRepo.findUpcomingTournaments();
	}

	@Override
	public List<Tournament> findOngoingTournaments() {
		// TODO Auto-generated method stub
		return tournamentRepo.findOngoingTournaments();
	}

	@Override
	public List<Tournament> findFinishedTournaments() {
		// TODO Auto-generated method stub
		return tournamentRepo.findFinishedTournaments();
	}

	@Override
	public void startTournament(Long tournamentId) {
		// TODO Auto-generated method stub
	    Tournament tournament = findById(tournamentId);

	    if (tournament == null)
	        return;

	    if (tournament.getStatus() != TournamentStatus.PUBLISHED)
	        return;

	    tournament.setStatus(TournamentStatus.ONGOING);
	    update(tournament);
	}

	@Override
	public void finishTournament(Long tournamentId) {
		// TODO Auto-generated method stub
	    Tournament tournament = findById(tournamentId);

	    if (tournament == null)
	        return;

	    if (tournament.getStatus() != TournamentStatus.ONGOING)
	        return;

	    tournament.setStatus(TournamentStatus.FINISHED);
	    update(tournament);
	}

	@Override
	public void publishTournament(Long tournamentId) {
		// TODO Auto-generated method stub
	    Tournament tournament = findById(tournamentId);

	    if (tournament == null)
	        return;

	    if (tournament.getStatus() != TournamentStatus.DRAFT)
	        return;
	    tournament.setStatus(TournamentStatus.PUBLISHED);
	    update(tournament);
	}

	@Override
	public void cancelTournament(Long tournamentId) {
		// TODO Auto-generated method stub
	    Tournament tournament = findById(tournamentId);

	    if (tournament == null)
	        return;

	    if (tournament.getStatus() == TournamentStatus.FINISHED)
	        return;

	    tournament.setStatus(TournamentStatus.CANCELLED);
	    update(tournament);
	}

}
