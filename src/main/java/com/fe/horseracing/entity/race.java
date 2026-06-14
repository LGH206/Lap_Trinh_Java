package com.fe.horseracing.entity;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "races")
public class race {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long raceId;
	
	@Column(nullable = false)
	private String raceName;
	
    private LocalDate raceDate;

    private String location;

    private String status;

    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private tournament tournament;
    
	public race() {
		super();
	}

	public Long getRaceId() {
		return raceId;
	}

	public void setRaceId(Long raceId) {
		this.raceId = raceId;
	}

	public String getRaceName() {
		return raceName;
	}

	public void setRaceName(String raceName) {
		this.raceName = raceName;
	}

	public LocalDate getRaceDate() {
		return raceDate;
	}

	public void setRaceDate(LocalDate raceDate) {
		this.raceDate = raceDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public tournament getTournament() {
		return tournament;
	}

	public void setTournament(tournament tournament) {
		this.tournament = tournament;
	}
    
}
