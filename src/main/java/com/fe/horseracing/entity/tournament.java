package com.fe.horseracing.entity;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity 
@Table(name = "tournaments")
public class Tournament {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tournamentId;
	
	@Column(nullable = false)
	private String tournamentName;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	private Double prizePool;
	
	private String status;
    
	public Tournament() {
		super();
	}
	
	public Long getTournamentId() {
		return tournamentId;
	}

	public void setTournamentId(Long tournamentId) {
		this.tournamentId = tournamentId;
	}

	public String getTournamentName() {
		return tournamentName;
	}

	public void setTournamentName(String tournamentName) {
		this.tournamentName = tournamentName;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Double getPrizePool() {
		return prizePool;
	}

	public void setPrizePool(Double prizePool) {
		this.prizePool = prizePool;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
