package com.fe.horseracing.entity;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "registrations")
public class registration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long registrationId;
	
	private LocalDate registrationDate;
	
	private String status;
	
    @ManyToOne
    private horse horse;

    @ManyToOne
    private jockey jockey;

    @ManyToOne
    private race race;

	public registration() {
		super();
	}

	public Long getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(Long registrationId) {
		this.registrationId = registrationId;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public horse getHorse() {
		return horse;
	}

	public void setHorse(horse horse) {
		this.horse = horse;
	}

	public jockey getJockey() {
		return jockey;
	}

	public void setJockey(jockey jockey) {
		this.jockey = jockey;
	}

	public race getRace() {
		return race;
	}

	public void setRace(race race) {
		this.race = race;
	}
}
