package com.fe.horseracing.entity;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "horses")
public class Horse {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long horseId;
	
	@Column(nullable = false)
	private String horseName;
	
	@Column(nullable = false)
	private String breed;
	
	private Integer age;
	
	private String gender;
	
	private Double weight;
	
	private String color;
	
	private String status;
	/*
     * Trạng thái:
     * ACTIVE
     * INJURED
     * RETIRED
     */

	@ManyToOne
	@JoinColumn(name = "owner_id") //Foregin key
	private HorseOwner owner;
	
	@OneToMany(mappedBy = "selectedHorse")
	private List<Betting> bettings;
	
	@OneToMany(mappedBy = "horse")
	private List<RaceResult> raceResults;
	
	public Horse() {
		super();
	}

	public List<Betting> getBettings() {
		return bettings;
	}

	public void setBettings(List<Betting> bettings) {
		this.bettings = bettings;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Long getHorseId() {
		return horseId;
	}

	public void setHorseId(Long horseId) {
		this.horseId = horseId;
	}

	public String getHorseName() {
		return horseName;
	}

	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public HorseOwner getOwner() {
	    return owner;
	}
	
	public void setOwner(HorseOwner owner) {
	    this.owner = owner;
	}

	public List<RaceResult> getRaceResults() {
		return raceResults;
	}

	public void setRaceResults(List<RaceResult> raceResults) {
		this.raceResults = raceResults;
	}
	
	
}
