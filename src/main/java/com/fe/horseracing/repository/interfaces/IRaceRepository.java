package com.fe.horseracing.repository.interfaces;

import java.util.List;

import com.fe.horseracing.enums.RaceStatus;
import com.fe.horseracing.pojo.Race;

public interface IRaceRepository {

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

	List<Race> findByJockey(Long jockeyId);

	List<Race> findByOwner(Long ownerId);

}