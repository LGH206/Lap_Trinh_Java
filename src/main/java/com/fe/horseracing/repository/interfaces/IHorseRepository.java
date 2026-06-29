package com.fe.horseracing.repository.interfaces;

import java.util.List;

import com.fe.horseracing.enums.HorseStatus;
import com.fe.horseracing.pojo.Horse;

public interface IHorseRepository {

    // CRUD

    void save(Horse horse);

    void update(Horse horse);

    void delete(Long horseId);

    Horse findById(Long horseId);

    List<Horse> findAll();

    // Query

    List<Horse> findByOwner(Long ownerId);

    List<Horse> findByStatus(HorseStatus status);

    List<Horse> findVerified();

    List<Horse> findUnverified();

}