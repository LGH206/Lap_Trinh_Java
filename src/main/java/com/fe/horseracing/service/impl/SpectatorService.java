package com.fe.horseracing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fe.horseracing.pojo.Notification;
import com.fe.horseracing.pojo.Prediction;
import com.fe.horseracing.pojo.Race;
import com.fe.horseracing.pojo.RaceResult;
import com.fe.horseracing.pojo.Spectator;
import com.fe.horseracing.repository.interfaces.ISpectatorRepository;
import com.fe.horseracing.service.interfaces.INotificationService;
import com.fe.horseracing.service.interfaces.IPredictionService;
import com.fe.horseracing.service.interfaces.IRaceResultService;
import com.fe.horseracing.service.interfaces.IRaceService;
import com.fe.horseracing.service.interfaces.ISpectatorService;

@Service
public class SpectatorService implements ISpectatorService {

    private ISpectatorRepository spectatorRepo;
    private IRaceService raceService;
    private IRaceResultService raceResultService;
    private IPredictionService predictionService;
    private INotificationService notificationService;

    @Autowired
    public SpectatorService(
            ISpectatorRepository spectatorRepo,
            IRaceService raceService,
            IRaceResultService raceResultService,
            IPredictionService predictionService,
            INotificationService notificationService) {

        this.spectatorRepo = spectatorRepo;
        this.raceService = raceService;
        this.raceResultService = raceResultService;
        this.predictionService = predictionService;
        this.notificationService = notificationService;
    }
    
	@Override
	public void save(Spectator spectator) {
		// TODO Auto-generated method stub
		spectatorRepo.save(spectator);
	}

	@Override
	public void update(Spectator spectator) {
		// TODO Auto-generated method stub
		spectatorRepo.update(spectator);
	}

	@Override
	public void delete(Long spectatorId) {
		// TODO Auto-generated method stub
		spectatorRepo.delete(spectatorId);
	}

	@Override
	public Spectator findById(Long spectatorId) {
		// TODO Auto-generated method stub
		return spectatorRepo.findById(spectatorId);
	}

	@Override
	public List<Spectator> findAll() {
		// TODO Auto-generated method stub
		return spectatorRepo.findAll();
	}

	@Override
	public List<Race> viewRaces() {
		// TODO Auto-generated method stub
		return raceService.findAll();
	}

	@Override
	public Race viewRace(Long raceId) {
		// TODO Auto-generated method stub
		return raceService.findById(raceId);
	}

	@Override
	public List<RaceResult> viewRaceResults(Long raceId) {
		// TODO Auto-generated method stub
		return raceResultService.findByRace(raceId);
	}

	@Override
	public List<RaceResult> viewRankings(Long raceId) {
		// TODO Auto-generated method stub
		return raceResultService.getRaceRanking(raceId);
	}

	@Override
	public void submitPrediction(Prediction prediction) {
	    predictionService.submitPrediction(prediction);

	}

	@Override
	public List<Prediction> viewPredictions(Long spectatorId) {
		// TODO Auto-generated method stub
		return predictionService.findByUser(spectatorId);
	}
	
	@Override
	public List<Notification> viewNotifications(Long spectatorId) {
	    return notificationService.findByUser(spectatorId);
	}
	
	@Override
	public void markNotificationAsRead(Long notificationId) {
	    notificationService.markAsRead(notificationId);
	}

}
