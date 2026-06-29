package com.fe.horseracing.repository.interfaces;

import java.util.List;

import com.fe.horseracing.pojo.HorseOwner;

public interface IHorseOwnerRepository {

    void save(HorseOwner owner);

    void update(HorseOwner owner);

    void delete(Long ownerId);

    HorseOwner findById(Long ownerId);

    List<HorseOwner> findAll();

}