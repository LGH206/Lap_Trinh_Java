package com.fe.horseracing.pojo;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

import com.fe.horseracing.enums.JockeyStatus;

@Entity
@Table(name = "jockeys")
@PrimaryKeyJoinColumn(name = "user_Id")
public class Jockey extends User {

    @Column(name = "license_number", nullable = false, unique = true, length = 50)
    private String licenseNumber;

    @Column(name = "nationality", length = 50)
    private String nationality;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "weight")
    private double weight;

    @Column(name = "experience_years")
    private int experienceYears;

    @Column(name = "total_races")
    private int totalRaces;

    @Column(name = "total_wins")
    private int totalWins;

    @Column(name = "profile_image_url", length = 255)
    private String profileImageUrl;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private JockeyStatus jockeyStatus; 

    @OneToMany(mappedBy = "jockey")
    private List<Violation> violations;
    
    @OneToMany(mappedBy = "jockey")
    private List<Registration> registrations;
    
    public Jockey() {
        super();
        this.jockeyStatus = JockeyStatus.AVAILABLE;
        this.totalRaces = 0;
        this.totalWins = 0;
    }

    @OneToMany(mappedBy = "jockey")
    private List<RaceResult> raceResults;

    // Getters & Setters
    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public int getTotalRaces() {
        return totalRaces;
    }

    public void setTotalRaces(int totalRaces) {
        this.totalRaces = totalRaces;
    }

    public int getTotalWins() {
        return totalWins;
    }

    public void setTotalWins(int totalWins) {
        this.totalWins = totalWins;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public JockeyStatus getJockeyStatus() {
		return jockeyStatus;
	}

	public void setJockeyStatus(JockeyStatus jockeyStatus) {
		this.jockeyStatus = jockeyStatus;
	}

	public List<Registration> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(List<Registration> registrations) {
		this.registrations = registrations;
	}

	public List<RaceResult> getRaceResults() {
		return raceResults;
	}

	public void setRaceResults(List<RaceResult> raceResults) {
		this.raceResults = raceResults;
	}

	public List<Violation> getViolations() {
		return violations;
	}

	public void setViolations(List<Violation> violations) {
		this.violations = violations;
	}

	@Transient
    public double getWinRate() {
        if (totalRaces == 0) {
            return 0.0;
        }
        return ((double) totalWins / totalRaces) * 100.0;
    }
}
