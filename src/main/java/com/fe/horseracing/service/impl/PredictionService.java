package com.fe.horseracing.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fe.horseracing.enums.PredictionStatus;
import com.fe.horseracing.pojo.Prediction;
import com.fe.horseracing.repository.interfaces.IPredictionRepository;
import com.fe.horseracing.repository.interfaces.IRaceResultRepository;
import com.fe.horseracing.service.interfaces.INotificationService;
import com.fe.horseracing.service.interfaces.IPredictionService;
import com.fe.horseracing.pojo.RaceResult;
import com.fe.horseracing.service.interfaces.IRaceResultService;

@Service
public class PredictionService implements IPredictionService {
	private IPredictionRepository predictionRepo;
	private IRaceResultRepository raceResultRepo;
	private INotificationService notificationService;

    @Autowired
    public PredictionService(
    		IPredictionRepository predictionRepo,
    		IRaceResultRepository  raceResultRepo,
    		INotificationService notificationService) 
    {
        this.predictionRepo = predictionRepo;
        this.raceResultRepo  = raceResultRepo;
        this.notificationService = notificationService;
    }

    @Override
    public void save(Prediction prediction) {
        predictionRepo.save(prediction);
    }

    @Override
    public void update(Prediction prediction) {
        predictionRepo.update(prediction);
    }

    @Override
    public void delete(Long predictionId) {
        predictionRepo.delete(predictionId);
    }

    @Override
    public Prediction findById(Long predictionId) {
        return predictionRepo.findById(predictionId);
    }

    @Override
    public List<Prediction> findAll() {
        return predictionRepo.findAll();
    }

    @Override
    public List<Prediction> findByUser(Long userId) {
        return predictionRepo.findByUser(userId);
    }

    @Override
    public List<Prediction> findByRace(Long raceId) {
        return predictionRepo.findByRace(raceId);
    }

    @Override
    public List<Prediction> findByHorse(Long horseId) {
        return predictionRepo.findByHorse(horseId);
    }

    @Override
    public List<Prediction> findByStatus(PredictionStatus status) {
        return predictionRepo.findByStatus(status);
    }

	@Override
	public void processPredictions(Long raceId) {
		// TODO Auto-generated method stub
	    RaceResult winner = raceResultRepo.getWinner(raceId);
	    if (winner == null) {
	        return;
	    }
	    List<Prediction> predictions = predictionRepo.findByRace(raceId);
	    for (Prediction prediction : predictions) {
	        if (prediction
	        		.getPredictedHorse()
	                .getHorseId()
	                .equals(
	                    winner.getHorse()
	                          .getHorseId())) {

	            prediction.setStatus( PredictionStatus.CORRECT);
	            notificationService.sendNotification(
	                    prediction.getSpectator(),
	                    "Prediction Result",
	                    "Congratulations! Your prediction was correct.");
	        } 
	        else {
	            prediction.setStatus( PredictionStatus.INCORRECT);
	            notificationService.sendNotification(
	                    prediction.getSpectator(),
	                    "Prediction Result",
	                    "Your prediction was incorrect.");}
	        predictionRepo.update(prediction);
	    }
	}

	@Override
	public void submitPrediction(Prediction prediction) {
		// TODO Auto-generated method stub
	    prediction.setStatus(PredictionStatus.PENDING);
	    save(prediction);
	}
}