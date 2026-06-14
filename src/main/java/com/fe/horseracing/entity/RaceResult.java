package com.fe.horseracing.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "results")
public class RaceResult {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long resultId;
	
	private Integer position;
	
	private Double finishTime;
	
	private Double score;
	
    @ManyToOne
    @JoinColumn(name = "race_id")
    private Race race;

    @ManyToOne
    @JoinColumn(name = "horse_id")
    private Horse horse;

	public RaceResult() {
		super();
	}

	public Long getResultId() {
		return resultId;
	}

	public void setResultId(Long resultId) {
		this.resultId = resultId;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Double getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Double finishTime) {
		this.finishTime = finishTime;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public Horse getHorse() {
		return horse;
	}

	public void setHorse(Horse horse) {
		this.horse = horse;
	}
	
}
