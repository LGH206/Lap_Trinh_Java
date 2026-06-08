package dao;

import entity.Race; 
import java.util.ArrayList;
import java.util.List;

public class RaceDAO {
   
    private static List<Race> databaseRaces = new ArrayList<>();

    public void save(Race race) {
        databaseRaces.add(race);
    }

    public List<Race> findAll() {
        return databaseRaces;
    }
}
