package com.fe.horseracing.service.interfaces;

import java.util.List;

import com.fe.horseracing.enums.HorseStatus;
import com.fe.horseracing.enums.JockeyStatus;
import com.fe.horseracing.enums.PredictionStatus;
import com.fe.horseracing.enums.Role;
import com.fe.horseracing.pojo.Admin;
import com.fe.horseracing.pojo.Horse;
import com.fe.horseracing.pojo.Jockey;
import com.fe.horseracing.pojo.Prediction;
import com.fe.horseracing.pojo.Registration;
import com.fe.horseracing.pojo.User;

public interface IAdminService {

    // CRUD 
    void save(Admin admin);

    void update(Admin admin);

    void delete(Long adminId);

    Admin findById(Long adminId);

    List<Admin> findAll();
    
    // User
    void lockUser(Long userId);

    void unlockUser(Long userId);

    List<User> viewUsers();

    List<User> viewUsersByRole(Role role);
    
    // Horse
    void approveHorse(Long horseId);

    List<Horse> viewHorseList();

    List<Horse> viewHorseByStatus(HorseStatus status);

    void removeHorse(Long horseId);
    
    void suspendHorse(Long horseId);
    
    // Jockey
    void approveJockey(Long jockeyId);

    List<Jockey> viewJockeyList();

    List<Jockey> viewJockeyByStatus(JockeyStatus status);

    void removeJockey(Long jockeyId);

    // Tournament 
    void publishTournament(Long tournamentId);

    void startTournament(Long tournamentId);

    void finishTournament(Long tournamentId);

    void cancelTournament(Long tournamentId);

    //  Registration
    void approveRegistration(Long registrationId);

    void rejectRegistration(Long registrationId);
    
    List<Registration> viewRegistrations();

    List<Registration> viewPendingRegistrations();

    //  Race 
    void scheduleRace(Long raceId);
    
    void assignRole(Long userId, Role role);

    //  Race Result 
    void publishRaceResult(Long raceId);
    
    // Prediction
    List<Prediction> viewPredictions();

    List<Prediction> viewPredictionsByRace(Long raceId);

    List<Prediction> viewPredictionsByStatus(PredictionStatus status);

    void deletePrediction(Long predictionId);

	void assignReferee(Long raceId, Long refereeId);

}