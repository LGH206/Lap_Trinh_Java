package com.fe.horseracing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fe.horseracing.enums.JockeyStatus;
import com.fe.horseracing.enums.Role;
import com.fe.horseracing.pojo.Horse;
import com.fe.horseracing.pojo.Invitation;
import com.fe.horseracing.pojo.Jockey;
import com.fe.horseracing.pojo.Race;
import com.fe.horseracing.pojo.RaceResult;
import com.fe.horseracing.repository.interfaces.IHorseRepository;
import com.fe.horseracing.repository.interfaces.IJockeyRepository;
import com.fe.horseracing.service.interfaces.IInvitationService;
import com.fe.horseracing.service.interfaces.IHorseService;
import com.fe.horseracing.service.interfaces.IJockeyService;
import com.fe.horseracing.service.interfaces.IRaceResultService;
import com.fe.horseracing.service.interfaces.IRaceService;
import com.fe.horseracing.service.interfaces.IUserService;

@Service
public class JockeyService implements IJockeyService {

    private IJockeyRepository jockeyRepo;
    private IInvitationService invitationService;
    private IHorseRepository horseRepo;
    private IRaceService raceService;
    private IRaceResultService raceResultService;
    private IUserService userService;

    @Autowired
    public JockeyService(
            IJockeyRepository jockeyRepo,
            IInvitationService invitationService,
            IHorseRepository horseRepo,
            IRaceService raceService,
            IRaceResultService raceResultService,
            IUserService userService) {

        this.jockeyRepo = jockeyRepo;
        this.invitationService = invitationService;
        this.horseRepo = horseRepo;
        this.raceService = raceService;
        this.raceResultService = raceResultService;
        this.userService = userService;
    }
	@Override
	public void save(Jockey jockey) {
		// TODO Auto-generated method stub
		jockeyRepo.save(jockey);
	}

	@Override
	public void update(Jockey jockey) {
		// TODO Auto-generated method stub
		jockeyRepo.update(jockey);
	}

	@Override
	public void delete(Long jockeyId) {
		// TODO Auto-generated method stub
		jockeyRepo.delete(jockeyId);
	}

	@Override
	public Jockey findById(Long jockeyId) {
		// TODO Auto-generated method stub
		return jockeyRepo.findById(jockeyId);
	}

	@Override
	public List<Jockey> findAll() {
		// TODO Auto-generated method stub
		return jockeyRepo.findAll();
	}

	//Query
	
	@Override
	public Jockey findByLicenseNumber(String licenseNumber) {
		// TODO Auto-generated method stub
		return jockeyRepo.findByLicenseNumber(licenseNumber);
	}

	@Override
	public List<Jockey> findByStatus(JockeyStatus status) {
		// TODO Auto-generated method stub
		return jockeyRepo.findByStatus(status);
	}

	@Override
	public List<Jockey> findAvailableJockeys() {
		// TODO Auto-generated method stub
		return jockeyRepo.findAvailableJockeys();
	}

	@Override
	public List<Invitation> viewInvitations(Long jockeyId) {
		// TODO Auto-generated method stub
		return invitationService.findByReceiver(jockeyId);
	}

	@Override
	public void acceptInvitation(Long invitationId) {
		// TODO Auto-generated method stub
		invitationService.acceptInvitation(invitationId);
	}

	@Override
	public void rejectInvitation(Long invitationId) {
		// TODO Auto-generated method stub
		invitationService.rejectInvitation(invitationId);
	}

	@Override
	public List<Race> viewAssignedRaces(Long jockeyId) {
		// TODO Auto-generated method stub
		return raceService.findByJockey(jockeyId);
	}

	@Override
	public List<Race> viewRaceSchedule(Long jockeyId) {
		// TODO Auto-generated method stub
		return raceService.findByJockey(jockeyId);
	}

	@Override
	public Horse viewHorse(Long horseId) {
		// TODO Auto-generated method stub
		return horseRepo.findById(horseId);
	}

	@Override
	public List<RaceResult> viewRaceResults(Long jockeyId) {
		// TODO Auto-generated method stub
		return raceResultService.findByJockey(jockeyId);
	}

	@Override
	public List<RaceResult> viewRankings(Long jockeyId) {
		// TODO Auto-generated method stub
		return raceResultService.getRankingsByJockey(jockeyId);
	}
	@Override
	public void approveJockey(Long jockeyId) {

	    Jockey jockey = findById(jockeyId);

	    if (jockey == null)
	        return;

	    jockey.setJockeyStatus(JockeyStatus.AVAILABLE);
	    update(jockey);
	}
	@Override
	public String register(Jockey jockey,
	                       String confirmPassword) {

	    if (!jockey.getPassword().equals(confirmPassword))
	        return "Password confirmation does not match.";

	    if (userService.existsByUserName(jockey.getUserName()))
	        return "Username already exists.";

	    if (userService.existsByEmail(jockey.getEmail()))
	        return "Email already exists.";

	    if (findByLicenseNumber(jockey.getLicenseNumber()) != null)
	        return "License number already exists.";

	    jockey.setRole(Role.JOCKEY);

	    jockey.setActive(true);

	    jockey.setJockeyStatus(JockeyStatus.AVAILABLE);

	    save(jockey);

	    return null;
	}

}
