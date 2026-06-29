package com.fe.horseracing.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fe.horseracing.enums.ResultStatus;
import com.fe.horseracing.pojo.RaceResult;
import com.fe.horseracing.repository.interfaces.IRaceResultRepository;
import com.fe.horseracing.service.interfaces.IPredictionService;
import com.fe.horseracing.service.interfaces.IRaceResultService;

@Service
public class RaceResultService implements IRaceResultService {

	private IRaceResultRepository raceResultRepo;
	private IPredictionService predictionService;

	@Autowired
    public RaceResultService( 
    		IRaceResultRepository raceResultRepo,
    		IPredictionService predictionService) 
	{
        this.raceResultRepo = raceResultRepo;
        this.predictionService = predictionService;
    }

	@Override
	public void save(RaceResult raceResult) {
		// TODO Auto-generated method stub
		raceResultRepo.save(raceResult);
	}

	@Override
	public void update(RaceResult raceResult) {
		// TODO Auto-generated method stub
		raceResultRepo.update(raceResult);
	}

	@Override
	public void delete(Long resultId) {
		// TODO Auto-generated method stub
		raceResultRepo.delete(resultId);
	}

	@Override
	public RaceResult findById(Long resultId) {
		// TODO Auto-generated method stub
		 return raceResultRepo.findById(resultId);
	}

	@Override
	public List<RaceResult> findAll() {
		// TODO Auto-generated method stub
        return raceResultRepo.findAll();
	}

	@Override
	public List<RaceResult> findByRace(Long raceId) {
		// TODO Auto-generated method stub
		 return raceResultRepo.findByRace(raceId);
	}

	@Override
	public List<RaceResult> findByReferee(Long refereeId) {
		// TODO Auto-generated method stub
		return raceResultRepo.findByReferee(refereeId);
	}

	@Override
	public List<RaceResult> findVerifiedResults() {
		// TODO Auto-generated method stub
		return raceResultRepo.findVerifiedResults();
	}

	@Override
	public List<RaceResult> findByHorse(Long horseId) {
		// TODO Auto-generated method stub
		return raceResultRepo.findByHorse(horseId);
	}

	@Override
	public List<RaceResult> findByStatus(ResultStatus status) {
		// TODO Auto-generated method stub
		return raceResultRepo.findByStatus(status);
	}

	@Override
	public List<RaceResult> getRaceRanking(Long raceId) {
		// TODO Auto-generated method stub
		return raceResultRepo.getRaceRanking(raceId);
	}

	@Override
	public List<RaceResult> getTop3(Long raceId) {
		// TODO Auto-generated method stub
		return raceResultRepo.getTop3(raceId);
	}

	@Override
	public RaceResult getWinner(Long raceId) {
		// TODO Auto-generated method stub
		return raceResultRepo.getWinner(raceId);
	}

	@Override
	public Long countWinsByHorse(Long horseId) {
		// TODO Auto-generated method stub
		return raceResultRepo.countWinsByHorse(horseId);
	}

	@Override
	public Long countRacesByHorse(Long horseId) {
		// TODO Auto-generated method stub
		return raceResultRepo.countRacesByHorse(horseId);
	}

	@Override
	public void verifyRaceResult(Long resultId) {
		// TODO Auto-generated method stub
		RaceResult result = findById(resultId);

		if (result == null) {
		    return;
		}

		result.setVerificationStatus(ResultStatus.VERIFIED);
		result.setUpdateTime(LocalDateTime.now());

		update(result);
		predictionService.processPredictions(result.getRace().getRaceId());
	}

	@Override
	public List<RaceResult> findByJockey(Long jockeyId) {
		// TODO Auto-generated method stub
		return raceResultRepo.findByJockey(jockeyId);
	}

	@Override
	public List<RaceResult> getRankingsByJockey(Long jockeyId) {
		// TODO Auto-generated method stub
		return findByJockey(jockeyId);
	}

	@Override
	public List<RaceResult> getRankingsByHorse(Long horseId) {
		// TODO Auto-generated method stub
		return findByHorse(horseId);
	}

	@Override
	public void rejectRaceResult(Long resultId) {
		// TODO Auto-generated method stub
	    RaceResult result = findById(resultId);

	    if (result == null) {
	        return;
	    }

	    result.setVerificationStatus(ResultStatus.REJECTED);
	    result.setUpdateTime(LocalDateTime.now());

	    update(result);
	}

	@Override
	public List<RaceResult> findByOwner(Long ownerId) {
		// TODO Auto-generated method stub
		return raceResultRepo.findByOwner(ownerId);
	}

	@Override
	public List<RaceResult> getRankingsByOwner(Long ownerId) {
		// TODO Auto-generated method stub
		return raceResultRepo.getRankingsByOwner(ownerId);
	}

	@Override
	public void publishRaceResult(Long raceId) {
		// TODO Auto-generated method stub
		
	}
}
