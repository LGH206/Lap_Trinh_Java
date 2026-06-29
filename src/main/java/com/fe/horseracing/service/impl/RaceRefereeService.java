package com.fe.horseracing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fe.horseracing.enums.RaceStatus;
import com.fe.horseracing.enums.RefereeStatus;
import com.fe.horseracing.pojo.Horse;
import com.fe.horseracing.pojo.Invitation;
import com.fe.horseracing.pojo.Race;
import com.fe.horseracing.pojo.RaceReferee;
import com.fe.horseracing.pojo.RaceReport;
import com.fe.horseracing.pojo.RaceResult;
import com.fe.horseracing.pojo.Violation;
import com.fe.horseracing.repository.interfaces.IRaceRefereeRepository;
import com.fe.horseracing.repository.interfaces.IRaceRepository;
import com.fe.horseracing.service.interfaces.IHorseService;
import com.fe.horseracing.service.interfaces.IInvitationService;
import com.fe.horseracing.service.interfaces.IRaceRefereeService;
import com.fe.horseracing.service.interfaces.IRaceReportService;
import com.fe.horseracing.service.interfaces.IRaceResultService;
import com.fe.horseracing.service.interfaces.IRaceService;
import com.fe.horseracing.service.interfaces.IViolationService;

@Service
public class RaceRefereeService implements IRaceRefereeService {

    private IRaceRefereeRepository refereeRepo;
    private IHorseService horseService;
    private IRaceResultService raceResultService;
    private IViolationService violationService;
    private IRaceReportService raceReportService;
    private IInvitationService invitationService;
    private IRaceRepository raceRepo;

    @Autowired
    public RaceRefereeService(
    		IRaceRefereeRepository refereeRepo,
    		IHorseService horseService,
            IRaceResultService raceResultService,
            IViolationService violationService,
            IRaceReportService raceReportService,
            IInvitationService invitationService,
            IRaceRepository raceRepo) 
    {
        this.refereeRepo = refereeRepo;
        this.horseService = horseService;
        this.raceResultService = raceResultService;
        this.violationService = violationService;
        this.raceReportService = raceReportService;
        this.invitationService = invitationService;
        this.raceRepo = raceRepo;
    }
    
	@Override
	public void save(RaceReferee referee) {
		// TODO Auto-generated method stub
		refereeRepo.save(referee);
	}

	@Override
	public void update(RaceReferee referee) {
		// TODO Auto-generated method stub
		 refereeRepo.update(referee);
	}

	@Override
	public void delete(Long refereeId) {
		// TODO Auto-generated method stub
		refereeRepo.delete(refereeId);
	}

	@Override
	public RaceReferee findById(Long refereeId) {
		// TODO Auto-generated method stub
		return refereeRepo.findById(refereeId);
	}

	@Override
	public List<RaceReferee> findAll() {
		// TODO Auto-generated method stub
		return refereeRepo.findAll();
	}

	@Override
	public List<RaceReferee> findByStatus(RefereeStatus status) {
		// TODO Auto-generated method stub
		return refereeRepo.findByStatus(status);
	}

	@Override
	public RaceReferee findByLicenseNumber(String licenseNumber) {
		// TODO Auto-generated method stub
		return refereeRepo.findByLicenseNumber(licenseNumber);
	}

	@Override
	public List<RaceReferee> findAvailableReferees() {
		// TODO Auto-generated method stub
		return refereeRepo.findAvailableReferees();
	}

	@Override
	public boolean inspectHorse(Long horseId) {
		// TODO Auto-generated method stub
		Horse horse = horseService.findById(horseId);
		if (horse == null)
		    return false;

		return horse.getVerified();
	}

	@Override
	public void recordViolation(Violation violation) {
		// TODO Auto-generated method stub
		violationService.save(violation);
	}

	@Override
	public void verifyRaceResult(Long resultId) {
	    raceResultService.verifyRaceResult(resultId);
	}

	@Override
	public void createRaceReport(RaceReport report) {
		// TODO Auto-generated method stub
		raceReportService.save(report);
	}

	@Override
	public List<RaceResult> getRaceRanking(Long raceId) {
		// TODO Auto-generated method stub
		return raceResultService.getRaceRanking(raceId);
	}

	@Override
	public List<Invitation> viewInvitations(Long refereeId) {
		// TODO Auto-generated method stub
		return invitationService.findByReceiver(refereeId);
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
	public List<Race> viewAssignedRaces(Long refereeId) {
		return raceRepo.findByReferee(refereeId);
	}
	
	@Override
	public Race viewRace(Long raceId) {
		return raceRepo.findById(raceId);
	}
	
	@Override
	public void startRace(Long raceId) {
	    Race race = raceRepo.findById(raceId);

	    if (race == null)
	        return;

	    if (race.getStatus() != RaceStatus.SCHEDULED)
	        return;

	    race.setStatus(RaceStatus.RUNNING);
	    raceRepo.update(race);
	}

	@Override
	public void finishRace(Long raceId) {

	    Race race = raceRepo.findById(raceId);

	    if (race == null)
	        return;

	    if (race.getStatus() != RaceStatus.RUNNING)
	        return;

	    race.setStatus(RaceStatus.FINISHED);
	    raceRepo.update(race);
	}
}
