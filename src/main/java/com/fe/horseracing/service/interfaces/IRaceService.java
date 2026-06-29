package com.fe.horseracing.service.interfaces;

import java.util.List;

import com.fe.horseracing.enums.RaceStatus;
import com.fe.horseracing.pojo.Race;

public interface IRaceService {

    // CRUD
    void save(Race race);

    void update(Race race);

    void delete(Long raceId);

    Race findById(Long raceId);

    List<Race> findAll();

    // Query
    List<Race> findByTournament(Long tournamentId);

    List<Race> findByReferee(Long refereeId);

    List<Race> findByStatus(RaceStatus status);

    // Business
    void scheduleRace(Long raceId);

    void assignReferee(Long raceId, Long refereeId);

    void startRace(Long raceId);

    void finishRace(Long raceId);

    void cancelRace(Long raceId);
    
    List<Race> findByOwner(Long ownerId);

    List<Race> findByJockey(Long jockeyId);

}