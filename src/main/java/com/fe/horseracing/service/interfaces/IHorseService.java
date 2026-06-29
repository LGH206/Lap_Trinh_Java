package com.fe.horseracing.service.interfaces;

import java.util.List;

import com.fe.horseracing.enums.HorseStatus;
import com.fe.horseracing.pojo.Horse;

public interface IHorseService {

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

    // Business

    void assignJockey(Long horseId, Long jockeyId);
    
    void removeJockey(Long horseId);

    void verifyHorse(Long horseId);
    
    void rejectHorse(Long horseId);

    void updateMedicalCertificate(Long horseId, String certificate);

    void changeStatus(Long horseId, HorseStatus status);

	void approveHorse(Long horseId);

	void suspendHorse(Long horseId);

}