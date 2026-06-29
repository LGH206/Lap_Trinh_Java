package com.fe.horseracing.pojo;

import java.time.LocalDate;
import com.fe.horseracing.enums.RegistrationStatus;

import jakarta.persistence.*;

@Entity
@Table(name = "registrations")
public class Registration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long registrationId;
	
	@PrePersist
	public void prePersist() {
	    registrationDate = LocalDate.now();
	}
	
	private LocalDate registrationDate;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private RegistrationStatus status;
	
    @ManyToOne
    private Horse horse;

    @ManyToOne
    private Jockey jockey;

    @ManyToOne
    private Race race;

	public Registration() {
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

	public RegistrationStatus getStatus() {
		return status;
	}

	public void setStatus(RegistrationStatus status) {
		this.status = status;
	}

	public Horse getHorse() {
		return horse;
	}

	public void setHorse(Horse horse) {
		this.horse = horse;
	}

	public Jockey getJockey() {
		return jockey;
	}

	public void setJockey(Jockey jockey) {
		this.jockey = jockey;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}
	
	@Override
	public String toString() {
	    return "Registration [registrationId="
	            + registrationId
	            + ", status="
	            + status + "]";
	}
}
