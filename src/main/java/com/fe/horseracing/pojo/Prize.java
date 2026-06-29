package com.fe.horseracing.pojo;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "prizes")
public class Prize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prizeId;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private Boolean paid = false;

    private LocalDateTime awardedAt;

    @PrePersist
    public void prePersist() {
        awardedAt = LocalDateTime.now();
    }

    @ManyToOne
    @JoinColumn(name = "race_result_id")
    private RaceResult raceResult;

    public Prize() {
    }

	public Long getPrizeId() {
		return prizeId;
	}

	public void setPrizeId(Long prizeId) {
		this.prizeId = prizeId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Boolean getPaid() {
		return paid;
	}

	public void setPaid(Boolean paid) {
		this.paid = paid;
	}

	public LocalDateTime getAwardedAt() {
		return awardedAt;
	}

	public void setAwardedAt(LocalDateTime awardedAt) {
		this.awardedAt = awardedAt;
	}

	public RaceResult getRaceResult() {
		return raceResult;
	}

	public void setRaceResult(RaceResult raceResult) {
		this.raceResult = raceResult;
	}
	
	@Override
	public String toString() {
	    return "Prize [prizeId=" + prizeId
	            + ", amount=" + amount
	            + ", paid=" + paid + "]";
	}
    
}