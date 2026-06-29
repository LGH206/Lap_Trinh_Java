package com.fe.horseracing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fe.horseracing.enums.Role;
import com.fe.horseracing.pojo.Horse;
import com.fe.horseracing.pojo.HorseOwner;
import com.fe.horseracing.pojo.Jockey;
import com.fe.horseracing.pojo.Prize;
import com.fe.horseracing.pojo.Race;
import com.fe.horseracing.pojo.RaceResult;
import com.fe.horseracing.repository.interfaces.IHorseOwnerRepository;
import com.fe.horseracing.service.interfaces.IHorseOwnerService;
import com.fe.horseracing.service.interfaces.IHorseService;
import com.fe.horseracing.service.interfaces.IJockeyService;
import com.fe.horseracing.service.interfaces.IPrizeService;
import com.fe.horseracing.service.interfaces.IRaceService;
import com.fe.horseracing.service.interfaces.IRegistrationService;
import com.fe.horseracing.service.interfaces.IUserService;
import com.fe.horseracing.service.interfaces.IRaceResultService;

@Service
public class HorseOwnerService implements IHorseOwnerService {
	
    private IHorseOwnerRepository horseOwnerRepo;
    private IHorseService horseService;
    private IJockeyService jockeyService;
    private IRegistrationService registrationService;
    private IRaceService raceService;
    private IRaceResultService raceResultService;
    private IPrizeService prizeService;
    private IUserService userService;

    @Autowired
    public HorseOwnerService(
            IHorseOwnerRepository horseOwnerRepo,
            IHorseService horseService,
            IJockeyService jockeyService,
            IRegistrationService registrationService,
            IRaceService raceService,
            IRaceResultService raceResultService,
            IPrizeService prizeService,
            IUserService userService) {

        this.horseOwnerRepo = horseOwnerRepo;
        this.horseService = horseService;
        this.jockeyService = jockeyService;
        this.registrationService = registrationService;
        this.raceService = raceService;
        this.raceResultService = raceResultService;
        this.prizeService = prizeService;
        this.userService = userService;
    }

	@Override
	public void save(HorseOwner owner) {
		// TODO Auto-generated method stub
		horseOwnerRepo.save(owner);
	}

	@Override
	public void update(HorseOwner owner) {

	    HorseOwner current = findById(owner.getUserId());

	    if (current == null)
	        return;

	    current.setFirstName(owner.getFirstName());
	    current.setLastName(owner.getLastName());
	    current.setEmail(owner.getEmail());
	    current.setUserName(owner.getUserName());
	    current.setPhoneNumber(owner.getPhoneNumber());

	    horseOwnerRepo.update(current);
	}

	@Override
	public void delete(Long ownerId) {
		// TODO Auto-generated method stub
		horseOwnerRepo.delete(ownerId);
	}

	@Override
	public HorseOwner findById(Long ownerId) {
		// TODO Auto-generated method stub
		return horseOwnerRepo.findById(ownerId);
	}

	@Override
	public List<HorseOwner> findAll() {
		// TODO Auto-generated method stub
		return horseOwnerRepo.findAll();
	}

	@Override
	public List<Horse> viewMyHorses(Long ownerId) {
		// TODO Auto-generated method stub
		return horseService.findByOwner(ownerId);
	}

	@Override
	public Horse viewHorse(Long horseId) {
		// TODO Auto-generated method stub
		return horseService.findById(horseId);
	}
	
	@Override
	public void registerHorse(Horse horse) {
	    horseService.save(horse);
	}

	@Override
	public void updateHorse(Horse horse) {
		// TODO Auto-generated method stub
		horseService.update(horse);
	}

	@Override
	public void registerHorseToRace(Long horseId, Long jockeyId, Long raceId) {
		// TODO Auto-generated method stub
        registrationService.registerHorseToRace(horseId, jockeyId, raceId);
	}

	@Override
	public void confirmParticipation(Long registrationId) {
		// TODO Auto-generated method stub
		registrationService.confirmParticipation(registrationId);
	}

	@Override
	public List<Jockey> viewAvailableJockeys() {
		// TODO Auto-generated method stub
		return jockeyService.findAvailableJockeys();
	}

	@Override
	public void assignJockey(Long horseId, Long jockeyId) {
		// TODO Auto-generated method stub
		horseService.assignJockey(horseId, jockeyId);
	}

	@Override
	public List<Race> viewRaceSchedule(Long ownerId) {
		// TODO Auto-generated method stub
		return raceService.findByOwner(ownerId);
	}

	@Override
	public Race viewRace(Long raceId) {
		// TODO Auto-generated method stub
		return raceService.findById(raceId);
	}

	@Override
	public List<RaceResult> viewRaceResults(Long ownerId) {
		// TODO Auto-generated method stub
		return raceResultService.findByOwner(ownerId);
	}

	@Override
	public List<RaceResult> viewRankings(Long ownerId) {
		// TODO Auto-generated method stub
		return raceResultService.getRankingsByOwner(ownerId);
	}

	@Override
	public List<Prize> viewPrizeHistory(Long ownerId) {
	    return prizeService.findByOwner(ownerId);
	}

	@Override
	public void confirmJockey(Long registrationId) {
		// TODO Auto-generated method stub
		registrationService.confirmParticipation(registrationId);
	}

	@Override
	public String register(HorseOwner owner, String confirmPassword) {

	    if (!owner.getPassword().equals(confirmPassword))
	        return "Password confirmation does not match.";

	    if (userService.existsByUserName(owner.getUserName()))
	        return "Username already exists.";

	    if (userService.existsByEmail(owner.getEmail()))
	        return "Email already exists.";

	    owner.setRole(Role.HORSE_OWNER);
	    owner.setActive(true);

	    // Gọi CRUD
	    save(owner);

	    return null;
	}

}
