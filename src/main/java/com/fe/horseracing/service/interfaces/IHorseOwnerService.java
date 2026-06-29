package com.fe.horseracing.service.interfaces;

import java.util.List;

import com.fe.horseracing.pojo.Horse;
import com.fe.horseracing.pojo.HorseOwner;
import com.fe.horseracing.pojo.Jockey;
import com.fe.horseracing.pojo.Prize;
import com.fe.horseracing.pojo.Race;
import com.fe.horseracing.pojo.RaceResult;

public interface IHorseOwnerService {

    // CRUD
    void save(HorseOwner owner);

    void update(HorseOwner owner);

    void delete(Long ownerId);

    HorseOwner findById(Long ownerId);

    List<HorseOwner> findAll();

    // Horse
    List<Horse> viewMyHorses(Long ownerId);

    Horse viewHorse(Long horseId);
    
    void registerHorse(Horse horse);

    void updateHorse(Horse horse);

    // Registration
    void registerHorseToRace(Long horseId, Long jockeyId, Long raceId);
    
    void confirmParticipation(Long registrationId);
    
    String register(HorseOwner owner, String confirmPassword);

    // Jockey
    List<Jockey> viewAvailableJockeys();

    void assignJockey(Long horseId, Long jockeyId);

    void confirmJockey(Long registrationId);

    // Race

    List<Race> viewRaceSchedule(Long ownerId);

    Race viewRace(Long raceId);

    // Result
    List<RaceResult> viewRaceResults(Long ownerId);

    List<RaceResult> viewRankings(Long ownerId);

    // Prize
    List<Prize> viewPrizeHistory(Long ownerId);
}