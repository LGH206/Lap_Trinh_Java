package com.fe.horseracing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fe.horseracing.enums.HorseStatus;
import com.fe.horseracing.enums.JockeyStatus;
import com.fe.horseracing.enums.PredictionStatus;
import com.fe.horseracing.enums.RegistrationStatus;
import com.fe.horseracing.enums.Role;
import com.fe.horseracing.pojo.Admin;
import com.fe.horseracing.pojo.Horse;
import com.fe.horseracing.pojo.Jockey;
import com.fe.horseracing.pojo.Prediction;
import com.fe.horseracing.pojo.Registration;
import com.fe.horseracing.pojo.User;
import com.fe.horseracing.repository.interfaces.IAdminRepository;
import com.fe.horseracing.service.interfaces.IAdminService;
import com.fe.horseracing.service.interfaces.IHorseService;
import com.fe.horseracing.service.interfaces.IJockeyService;
import com.fe.horseracing.service.interfaces.IPredictionService;
import com.fe.horseracing.service.interfaces.IRaceService;
import com.fe.horseracing.service.interfaces.IRegistrationService;
import com.fe.horseracing.service.interfaces.IRaceResultService;
import com.fe.horseracing.service.interfaces.ITournamentService;
import com.fe.horseracing.service.interfaces.IUserService;

@Service
public class AdminService implements IAdminService {

	private IAdminRepository adminRepo;
	private IUserService userService;
	private IHorseService horseService;
	private IJockeyService jockeyService;
	private ITournamentService tournamentService;
	private IRaceService raceService;
	private IRegistrationService registrationService;
	private IRaceResultService raceResultService;
	private IPredictionService predictionService;
    
    @Autowired
    public AdminService(
            IAdminRepository adminRepo,
            ITournamentService tournamentService,
            IRaceService raceService,
            IRegistrationService registrationService,
            IRaceResultService raceResultService,
            IUserService userService,
            IHorseService horseService,
            IJockeyService jockeyService,
            IPredictionService predictionService) {

        this.adminRepo = adminRepo;
        this.tournamentService = tournamentService;
        this.raceService = raceService;
        this.registrationService = registrationService;
        this.raceResultService = raceResultService;
        this.userService = userService;
        this.horseService = horseService;
        this.jockeyService = jockeyService;
        this.predictionService = predictionService;
    }
    
	@Override
	public void save(Admin admin) {
		// TODO Auto-generated method stub
		adminRepo.save(admin);
	}

	@Override
	public void update(Admin admin) {
		// TODO Auto-generated method stub
		adminRepo.update(admin);
	}

	@Override
	public void delete(Long adminId) {
		// TODO Auto-generated method stub
		adminRepo.delete(adminId);
	}

	@Override
	public Admin findById(Long adminId) {
		// TODO Auto-generated method stub
		return adminRepo.findById(adminId);
	}

	@Override
	public List<Admin> findAll() {
		// TODO Auto-generated method stub
		return adminRepo.findAll();
	}

	// Tournament
	@Override
	public void publishTournament(Long tournamentId) {
		// TODO Auto-generated method stub
		tournamentService.publishTournament(tournamentId);
	}

	@Override
	public void startTournament(Long tournamentId) {
		// TODO Auto-generated method stub
		tournamentService.startTournament(tournamentId);
	}

	@Override
	public void finishTournament(Long tournamentId) {
		// TODO Auto-generated method stub
		tournamentService.finishTournament(tournamentId);
	}

	@Override
	public void cancelTournament(Long tournamentId) {
		// TODO Auto-generated method stub
		tournamentService.cancelTournament(tournamentId);
	}

	 // Registration
	@Override
	public void approveRegistration(Long registrationId) {
		// TODO Auto-generated method stub
		registrationService.approveRegistration(registrationId);
	}

	@Override
	public void rejectRegistration(Long registrationId) {
		// TODO Auto-generated method stub
		registrationService.rejectRegistration(registrationId);
	}

	//Race
	@Override
	public void scheduleRace(Long raceId) {
		// TODO Auto-generated method stub
		raceService.scheduleRace(raceId);
	}

	@Override
	public void assignReferee(Long raceId, Long refereeId) {
		// TODO Auto-generated method stub
		raceService.assignReferee(raceId, refereeId);
	}

	//Race Result
	@Override
	public void publishRaceResult(Long raceId) {
		// TODO Auto-generated method stub
		raceResultService.publishRaceResult(raceId);
	}

	@Override
	public void lockUser(Long userId) {
		// TODO Auto-generated method stub
		userService.lockUser(userId);
	}

	@Override
	public void unlockUser(Long userId) {
		// TODO Auto-generated method stub
		userService.unlockUser(userId);
	}

	@Override
	public void approveHorse(Long horseId) {
	    horseService.approveHorse(horseId);
	}

	@Override
	public void removeHorse(Long horseId) {
	    horseService.delete(horseId);
	}

	@Override
	public void approveJockey(Long jockeyId) {
	    jockeyService.approveJockey(jockeyId);
	}

	@Override
	public void removeJockey(Long jockeyId) {
	    jockeyService.delete(jockeyId);
	}

	@Override
	public void deletePrediction(Long predictionId) {
	    predictionService.delete(predictionId);
	}

	@Override
	public List<User> viewUsers() {
	    return userService.findAll();
	}

	@Override
	public List<User> viewUsersByRole(Role role) {
	    return userService.findByRole(role);
	}

	@Override
	public List<Horse> viewHorseList() {
	    return horseService.findAll();
	}

	@Override
	public List<Horse> viewHorseByStatus(HorseStatus status) {
	    return horseService.findByStatus(status);
	}

	@Override
	public void suspendHorse(Long horseId) {
	    horseService.suspendHorse(horseId);
	}

	@Override
	public List<Jockey> viewJockeyList() {
	    return jockeyService.findAll();
	}

	@Override
	public List<Jockey> viewJockeyByStatus(JockeyStatus status) {
	    return jockeyService.findByStatus(status);
	}

	@Override
	public List<Registration> viewRegistrations() {
	    return registrationService.findAll();
	}

	@Override
	public List<Registration> viewPendingRegistrations() {
	    return registrationService.findByStatus(RegistrationStatus.PENDING);
	}

	@Override
	public List<Prediction> viewPredictions() {
	    return predictionService.findAll();
	}

	@Override
	public void assignRole(Long userId, Role role) {
	    userService.assignRole(userId, role);
	}
	
	@Override
	public List<Prediction> viewPredictionsByRace(Long raceId) {
	    return predictionService.findByRace(raceId);
	}

	@Override
	public List<Prediction> viewPredictionsByStatus( PredictionStatus status) {
	    return predictionService.findByStatus(status);
	}
}
