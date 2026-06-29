package com.fe.horseracing.service.interfaces;

import java.util.List;

import com.fe.horseracing.pojo.Prize;

public interface IPrizeService {

	void save(Prize prize);

    void update(Prize prize);

    void delete(Long prizeId);

    Prize findById(Long prizeId);

    List<Prize> findAll();

    List<Prize> findPaid();

    List<Prize> findUnpaid();
    
    List<Prize> findByOwner(Long ownerId);

    List<Prize> findByRace(Long raceId);

    void awardPrize(Long raceResultId, Double amount);

    void markAsPaid(Long prizeId);

}