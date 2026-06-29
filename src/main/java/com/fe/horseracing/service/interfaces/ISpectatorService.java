package com.fe.horseracing.service.interfaces;

import java.util.List;

import com.fe.horseracing.pojo.Notification;
import com.fe.horseracing.pojo.Prediction;
import com.fe.horseracing.pojo.Race;
import com.fe.horseracing.pojo.RaceResult;
import com.fe.horseracing.pojo.Spectator;

public interface ISpectatorService {

    //  CRUD 

    void save(Spectator spectator);

    void update(Spectator spectator);

    void delete(Long spectatorId);

    Spectator findById(Long spectatorId);

    List<Spectator> findAll();

    // Race

    List<Race> viewRaces();

    Race viewRace(Long raceId);

    // Result

    List<RaceResult> viewRaceResults(Long raceId);

    List<RaceResult> viewRankings(Long raceId);

    // Prediction 

    void submitPrediction(Prediction prediction);

    List<Prediction> viewPredictions(Long spectatorId);

	List<Notification> viewNotifications(Long spectatorId);

	void markNotificationAsRead(Long notificationId);

}