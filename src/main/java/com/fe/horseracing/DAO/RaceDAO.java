package com.example.dao;

import com.example.model.Race;
import java.util.List;
import java.util.Map;

public interface RaceDAO {
    void save(Race race);
    List<Race> findByTournamentId(int tournamentId);
    List<Map<String, Object>> findParticipantsByRaceId(int raceId);
}
