package com.fe.horseracing.pojo;

import java.time.LocalDateTime;

import com.fe.horseracing.enums.PredictionStatus;

import jakarta.persistence.*;

@Entity
@Table(name = "predictions")
public class Prediction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long predictionId;

    private LocalDateTime predictionTime;
    
    @Enumerated(EnumType.STRING)
    private PredictionStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User spectator;

    @ManyToOne
    @JoinColumn(name = "race_id")
    private Race race;
    
    @ManyToOne
    @JoinColumn(name = "horse_id")
    private Horse predictedHorse;

	public Long getPredictionId() {
		return predictionId;
	}

	public void setPredictionId(Long predictionId) {
		this.predictionId = predictionId;
	}

	public LocalDateTime getPredictionTime() {
		return predictionTime;
	}

	public void setPredictionTime(LocalDateTime predictionTime) {
		this.predictionTime = predictionTime;
	}

	public PredictionStatus getStatus() {
		return status;
	}

	public void setStatus(PredictionStatus status) {
		this.status = status;
	}

	public User getSpectator() {
		return spectator;
	}

	public void setSpectator(User spectator) {
		this.spectator = spectator;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public Horse getPredictedHorse() {
		return predictedHorse;
	}

	public void setPredictedHorse(Horse predictedHorse) {
		this.predictedHorse = predictedHorse;
	}

	public Prediction() {
	}

	public Prediction(Long predictionId, LocalDateTime predictionTime, PredictionStatus status, User spectator,
			Race race, Horse predictedHorse) {
		this.predictionId = predictionId;
		this.predictionTime = predictionTime;
		this.status = status;
		this.spectator = spectator;
		this.race = race;
		this.predictedHorse = predictedHorse;
	}

	public Prediction(Long predictionId, LocalDateTime predictionTime, PredictionStatus status) {
		super();
		this.predictionId = predictionId;
		this.predictionTime = predictionTime;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Prediction [predictionId=" + predictionId + ", predictionTime=" + predictionTime + ", status=" + status
				+ "]";
	}
}