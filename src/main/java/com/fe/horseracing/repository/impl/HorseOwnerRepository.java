package com.fe.horseracing.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fe.horseracing.DAO.HorseOwnerDAO;
import com.fe.horseracing.pojo.HorseOwner;
import com.fe.horseracing.repository.interfaces.IHorseOwnerRepository;

@Repository
public class HorseOwnerRepository implements IHorseOwnerRepository {

    @Autowired
    private HorseOwnerDAO horseOwnerDAO;
    
	@Override
	public void save(HorseOwner owner) {
		// TODO Auto-generated method stub
		horseOwnerDAO.save(owner);
	}

	@Override
	public void update(HorseOwner owner) {
		// TODO Auto-generated method stub
		horseOwnerDAO.update(owner);
	}

	@Override
	public void delete(Long ownerId) {
		// TODO Auto-generated method stub
		horseOwnerDAO.delete(ownerId);
	}

	@Override
	public HorseOwner findById(Long ownerId) {
		// TODO Auto-generated method stub
		return horseOwnerDAO.findById(ownerId);
	}

	@Override
	public List<HorseOwner> findAll() {
		// TODO Auto-generated method stub
		return horseOwnerDAO.findAll();
	}
}
