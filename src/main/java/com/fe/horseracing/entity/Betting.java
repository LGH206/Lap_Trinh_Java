package com.fe.horseracing.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "bettings")
public class Betting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bettingId;

    @Column(nullable = false)
    private Double betAmount;

    private Double odds;

    private Double payoutAmount;

    private LocalDateTime betTime;

    /*
     * PENDING
     * WON
     * LOST
     * CANCELLED
     */
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User bettor;

    @ManyToOne
    @JoinColumn(name = "race_id")
    private Race race;

    @ManyToOne
    @JoinColumn(name = "horse_id")
    private Horse selectedHorse;

    public Long getBettingId() {
        return bettingId;
    }

    public void setBettingId(Long bettingId) {
        this.bettingId = bettingId;
    }

    public Double getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(Double betAmount) {
        this.betAmount = betAmount;
    }

    public Double getOdds() {
        return odds;
    }

    public void setOdds(Double odds) {
        this.odds = odds;
    }

    public Double getPayoutAmount() {
        return payoutAmount;
    }

    public void setPayoutAmount(Double payoutAmount) {
        this.payoutAmount = payoutAmount;
    }

    public LocalDateTime getBetTime() {
        return betTime;
    }

    public void setBetTime(LocalDateTime betTime) {
        this.betTime = betTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getBettor() {
        return bettor;
    }

    public void setBettor(User bettor) {
        this.bettor = bettor;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Horse getSelectedHorse() {
        return selectedHorse;
    }

    public void setSelectedHorse(Horse selectedHorse) {
        this.selectedHorse = selectedHorse;
    }
    
    public Betting() {
    }

	public Betting(Long bettingId, Double betAmount, Double odds, Double payoutAmount, LocalDateTime betTime,
			String status, User bettor, Race race, Horse selectedHorse) {
		this.bettingId = bettingId;
		this.betAmount = betAmount;
		this.odds = odds;
		this.payoutAmount = payoutAmount;
		this.betTime = betTime;
		this.status = status;
		this.bettor = bettor;
		this.race = race;
		this.selectedHorse = selectedHorse;
	}

	@Override
	public String toString() {
		return "Betting [bettingId=" + bettingId + ", betAmount=" + betAmount + ", status=" + status + "]";
	}
}