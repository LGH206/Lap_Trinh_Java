package dao;

import entity.Tournament; 
import java.util.ArrayList;
import java.util.List;

public class TournamentDAO {
    private static List<Tournament> databaseTournaments = new ArrayList<>();

    public void save(Tournament tournament) {
        databaseTournaments.add(tournament);
    }

    public List<Tournament> findAll() {
        return databaseTournaments;
    }
}