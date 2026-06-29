package com.fe.horseracing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fe.horseracing.pojo.Prize;
import com.fe.horseracing.pojo.RaceResult;
import com.fe.horseracing.repository.interfaces.IPrizeRepository;
import com.fe.horseracing.service.interfaces.IPrizeService;
import com.fe.horseracing.service.interfaces.IRaceResultService;

@Service
public class PrizeService implements IPrizeService {

    private IPrizeRepository prizeRepo;
    private IRaceResultService raceResultService;

    @Autowired
    public PrizeService(
            IPrizeRepository prizeRepo,
            IRaceResultService raceResultService) {

        this.prizeRepo = prizeRepo;
        this.raceResultService = raceResultService;
    }
    
	@Override
	public void save(Prize prize) {
		// TODO Auto-generated method stub
		prizeRepo.save(prize);
	}

	@Override
	public void update(Prize prize) {
		// TODO Auto-generated method stub
		prizeRepo.update(prize);
	}

	@Override
	public void delete(Long prizeId) {
		// TODO Auto-generated method stub
		 prizeRepo.delete(prizeId);
	}

	@Override
	public Prize findById(Long prizeId) {
		// TODO Auto-generated method stub
		return prizeRepo.findById(prizeId);
	}

	@Override
	public List<Prize> findAll() {
		// TODO Auto-generated method stub
		return prizeRepo.findAll();
	}

	@Override
	public List<Prize> findPaid() {
		// TODO Auto-generated method stub
		return prizeRepo.findPaid();
	}

	@Override
	public List<Prize> findUnpaid() {
		// TODO Auto-generated method stub
		return prizeRepo.findUnpaid();
	}

	@Override
	public void awardPrize(Long raceResultId, Double amount) {
		// TODO Auto-generated method stub
        RaceResult raceResult = raceResultService.findById(raceResultId);

        if (raceResult == null) {
            return;
        }

        Prize prize = new Prize();

        prize.setRaceResult(raceResult);
        prize.setAmount(amount);
        prize.setPaid(false);

        prizeRepo.save(prize);
    }

	@Override
	public void markAsPaid(Long prizeId) {
		// TODO Auto-generated method stub
        Prize prize = prizeRepo.findById(prizeId);

        if (prize != null) {
            prize.setPaid(true);
            prizeRepo.update(prize);
        }
	}

	@Override
	public List<Prize> findByOwner(Long ownerId) {
		// TODO Auto-generated method stub
		return prizeRepo.findByOwner(ownerId);
	}

	@Override
	public List<Prize> findByRace(Long raceId) {
		// TODO Auto-generated method stub
		return prizeRepo.findByRace(raceId);
	}

}
