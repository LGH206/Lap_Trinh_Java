package service;

import dao.RaceDAO;
import entity.Race;
import java.util.List;

public class RaceService {
   
    private RaceDAO raceDAO = new RaceDAO();

    public void createRace(Race race) {
     
        if (race.getRaceName() == null || race.getRaceName().isEmpty()) {
            System.out.println(">> Lỗi nghiệp vụ: Tên trận đua không được bỏ trống!");
            return; 
        }
       
        raceDAO.save(race);
    }

    public List<Race> getAllRaces() {
        return raceDAO.findAll();
    }
}