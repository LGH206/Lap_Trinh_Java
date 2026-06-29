package com.fe.horseracing.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fe.horseracing.enums.RegistrationStatus;
import com.fe.horseracing.pojo.Horse;
import com.fe.horseracing.pojo.Jockey;
import com.fe.horseracing.pojo.Race;
import com.fe.horseracing.pojo.Registration;
import com.fe.horseracing.repository.interfaces.IRegistrationRepository;
import com.fe.horseracing.service.interfaces.IHorseService;
import com.fe.horseracing.service.interfaces.IJockeyService;
import com.fe.horseracing.service.interfaces.INotificationService;
import com.fe.horseracing.service.interfaces.IRaceService;
import com.fe.horseracing.service.interfaces.IRegistrationService;

@Service
public class RegistrationService implements IRegistrationService {

	private IRegistrationRepository registrationRepo;
	private IHorseService horseService;
	private IJockeyService jockeyService;
	private IRaceService raceService;
	private INotificationService notificationService;

	@Autowired
	public RegistrationService(
	        IRegistrationRepository registrationRepo,
	        IHorseService horseService,
	        IJockeyService jockeyService,
	        IRaceService raceService,
	        INotificationService notificationService) {

	    this.registrationRepo = registrationRepo;
	    this.horseService = horseService;
	    this.jockeyService = jockeyService;
	    this.raceService = raceService;
	    this.notificationService = notificationService;
	}
	
	@Override
	public void save(Registration registration) {
		// TODO Auto-generated method stub
		registrationRepo.save(registration);
	}

	@Override
	public void update(Registration registration) {
		// TODO Auto-generated method stub
		registrationRepo.update(registration);
	}

	@Override
	public void delete(Long registrationId) {
		// TODO Auto-generated method stub
		registrationRepo.delete(registrationId);
	}

	@Override
	public Registration findById(Long registrationId) {
		// TODO Auto-generated method stub
		 return registrationRepo.findById(registrationId);
	}

	@Override
	public List<Registration> findAll() {
		// TODO Auto-generated method stub
		return registrationRepo.findAll();
	}

	@Override
	public List<Registration> findByHorse(Long horseId) {
		// TODO Auto-generated method stub
		return registrationRepo.findByHorse(horseId);
	}

	@Override
	public List<Registration> findByJockey(Long jockeyId) {
		// TODO Auto-generated method stub
		return registrationRepo.findByJockey(jockeyId);
	}

	@Override
	public List<Registration> findByRace(Long raceId) {
		// TODO Auto-generated method stub
		return registrationRepo.findByRace(raceId);
	}

	@Override
	public List<Registration> findByStatus(RegistrationStatus status) {
		// TODO Auto-generated method stub
		return registrationRepo.findByStatus(status);
	}

	@Override
	public void submitRegistration(Registration registration) {
		// TODO Auto-generated method stub
	    registration.setRegistrationDate(LocalDate.now());
	    registration.setStatus(RegistrationStatus.PENDING);
	    save(registration);
	}

	@Override
	public void approveRegistration(Long registrationId) {
		// TODO Auto-generated method stub
	    Registration registration = findById(registrationId);

	    if (registration == null)
	        return;

	    registration.setStatus(RegistrationStatus.APPROVED);
	    update(registration);
	}

	@Override
	public void rejectRegistration(Long registrationId) {
		// TODO Auto-generated method stub
	    Registration registration = findById(registrationId);

	    if (registration == null)
	        return;

	    registration.setStatus(RegistrationStatus.REJECTED);
	    update(registration);
	}

	@Override
	public void confirmParticipation(Long registrationId) {
		// TODO Auto-generated method stub
	    Registration registration = findById(registrationId);

	    if (registration == null)
	        return;

	    registration.setStatus(RegistrationStatus.CONFIRMED);
	    update(registration);
	}

	@Override
	public void cancelRegistration(Long registrationId) {
		// TODO Auto-generated method stub
	    Registration registration = findById(registrationId);

	    if (registration == null)
	        return;

	    registration.setStatus(RegistrationStatus.CANCELLED);
	    update(registration);
	}

	@Override
	public void registerHorseToRace(Long horseId, Long jockeyId, Long raceId) {
		// TODO Auto-generated method stub
	    Horse horse = horseService.findById(horseId);
	    Jockey jockey = jockeyService.findById(jockeyId);
	    Race race = raceService.findById(raceId);

	    if (horse == null || jockey == null || race == null)
	        return;

	    Registration registration = new Registration();
	    registration.setHorse(horse);
	    registration.setJockey(jockey);
	    registration.setRace(race);
	    registration.setRegistrationDate(LocalDate.now());
	    registration.setStatus(RegistrationStatus.PENDING);
	    save(registration);
	}
}
