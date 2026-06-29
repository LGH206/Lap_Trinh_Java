package com.fe.horseracing.service.interfaces;

import java.util.List;

import com.fe.horseracing.enums.JockeyStatus;
import com.fe.horseracing.pojo.Horse;
import com.fe.horseracing.pojo.Invitation;
import com.fe.horseracing.pojo.Jockey;
import com.fe.horseracing.pojo.Race;
import com.fe.horseracing.pojo.RaceResult;

public interface IJockeyService {

    //  CRUD 

    void save(Jockey jockey);

    void update(Jockey jockey);

    void delete(Long jockeyId);

    Jockey findById(Long jockeyId);

    List<Jockey> findAll();
    
    String register(Jockey jockey, String confirmPassword);

    //Query
    Jockey findByLicenseNumber(String licenseNumber);

    List<Jockey> findByStatus(JockeyStatus status);

    List<Jockey> findAvailableJockeys();

    // Business

    List<Invitation> viewInvitations(Long jockeyId);

    void acceptInvitation(Long invitationId);

    void rejectInvitation(Long invitationId);

    List<Race> viewAssignedRaces(Long jockeyId);

    List<Race> viewRaceSchedule(Long jockeyId);

    Horse viewHorse(Long horseId);

    List<RaceResult> viewRaceResults(Long jockeyId);

    List<RaceResult> viewRankings(Long jockeyId);

	void approveJockey(Long jockeyId);

}