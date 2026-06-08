package entity;

import java.util.Date; 
public class Race {
    private int id;             
    private int tournamentId;   
    private Date scheduledTime; 
    private String raceName;
    public Race() {
    }

    public Race(int id, int tournamentId, String raceName, Date scheduledTime) {
        this.id = id;
        this.tournamentId = tournamentId;
        this.raceName = raceName;
        this.scheduledTime = scheduledTime;
    }

    public int getId() { 
        return id; 
    }
    public void setId(int id) { 
        this.id = id; 
    }

    public int getTournamentId() { 
        return tournamentId; 
    }
    public void setTournamentId(int tournamentId) { 
        this.tournamentId = tournamentId; 
    }

    public String getRaceName() { 
        return raceName; 
    }
    public void setRaceName(String raceName) { 
        this.raceName = raceName; 
    }

    public Date getScheduledTime() { 
        return scheduledTime; 
    }
    public void setScheduledTime(Date scheduledTime) { 
        this.scheduledTime = scheduledTime; 
    }
}
