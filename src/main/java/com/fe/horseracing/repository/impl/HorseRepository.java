package com.fe.horseracing.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fe.horseracing.DAO.HorseDAO;
import com.fe.horseracing.enums.HorseStatus;
import com.fe.horseracing.pojo.Horse;
import com.fe.horseracing.repository.interfaces.IHorseRepository;

@Repository
public class HorseRepository implements IHorseRepository {

    @Autowired
    private HorseDAO horseDAO;
    
	@Override
	public void save(Horse horse) {
		// TODO Auto-generated method stub
		horseDAO.save(horse);
	}

	@Override
	public void update(Horse horse) {
		// TODO Auto-generated method stub
		horseDAO.update(horse);
	}

	@Override
	public void delete(Long horseId) {
		// TODO Auto-generated method stub
		horseDAO.delete(horseId);
	}

	@Override
	public Horse findById(Long horseId) {
		// TODO Auto-generated method stub
		return horseDAO.findById(horseId);
	}

	@Override
	public List<Horse> findAll() {
		// TODO Auto-generated method stub
		return horseDAO.findAll();
	}

	@Override
	public List<Horse> findByOwner(Long ownerId) {
		// TODO Auto-generated method stub
		return horseDAO.findByOwner(ownerId);
	}

	@Override
	public List<Horse> findByStatus(HorseStatus status) {
		// TODO Auto-generated method stub
		return horseDAO.findByStatus(status);
	}

	@Override
	public List<Horse> findVerified() {
		// TODO Auto-generated method stub
		return horseDAO.findVerified();
	}

	@Override
	public List<Horse> findUnverified() {
		// TODO Auto-generated method stub
		return horseDAO.findUnverified();
	}

}
