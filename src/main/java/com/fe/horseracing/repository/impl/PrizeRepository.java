package com.fe.horseracing.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fe.horseracing.DAO.PrizeDAO;
import com.fe.horseracing.pojo.Prize;
import com.fe.horseracing.repository.interfaces.IPrizeRepository;

@Repository
public class PrizeRepository implements IPrizeRepository {

    @Autowired
    private PrizeDAO prizeDAO;

	@Override
	public void save(Prize prize) {
		// TODO Auto-generated method stub
		prizeDAO.save(prize);
	}

	@Override
	public void update(Prize prize) {
		// TODO Auto-generated method stub
		prizeDAO.update(prize);
	}

	@Override
	public void delete(Long prizeId) {
		// TODO Auto-generated method stub
		prizeDAO.delete(prizeId);
	}

	@Override
	public Prize findById(Long prizeId) {
		// TODO Auto-generated method stub
		return prizeDAO.findById(prizeId);
	}

	@Override
	public List<Prize> findAll() {
		// TODO Auto-generated method stub
		return prizeDAO.findAll();
	}

	@Override
	public List<Prize> findPaid() {
		// TODO Auto-generated method stub
		return prizeDAO.findPaid();
	}

	@Override
	public List<Prize> findUnpaid() {
		// TODO Auto-generated method stub
		return prizeDAO.findUnpaid();
	}

	@Override
	public List<Prize> findByOwner(Long ownerId) {
		// TODO Auto-generated method stub
		return prizeDAO.findByOwner(ownerId);
	}

	@Override
	public List<Prize> findByRace(Long raceId) {
		// TODO Auto-generated method stub
		return prizeDAO.findByRace(raceId);
	}

}
