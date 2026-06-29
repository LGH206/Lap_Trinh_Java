package com.fe.horseracing.pojo;

import java.util.List;

import com.fe.horseracing.enums.HorseStatus;

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

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private HorseStatus status;
	
	@Column(nullable = false)
	private Boolean verified = false; 

	private String medicalCertificate;  

	@ManyToOne
	@JoinColumn(name = "owner_id")
	private HorseOwner owner;
	
	@ManyToOne
	@JoinColumn(name = "jockey_id")
	private Jockey jockey;

	@OneToMany(mappedBy = "predictedHorse")
	private List<Prediction> predictions;
	
	@OneToMany(mappedBy = "horse")
	private List<Violation> violations;

	@OneToMany(mappedBy = "horse")
	private List<RaceResult> raceResults;

	public Horse() {
		super();
	}
	public Boolean getVerified() {
		return verified;
	}

	public void setVerified(Boolean verified) {
		this.verified = verified;
	}

	public String getMedicalCertificate() {
		return medicalCertificate;
	}

	public void setMedicalCertificate(String medicalCertificate) {
		this.medicalCertificate = medicalCertificate;
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

	public HorseStatus getStatus() {
		return status;
	}
	public void setStatus(HorseStatus status) {
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
	public List<Prediction> getPredictions() {
		return predictions;
	}
	public void setPredictions(List<Prediction> predictions) {
		this.predictions = predictions;
	}
	public List<Violation> getViolations() {
		return violations;
	}
	public void setViolations(List<Violation> violations) {
		this.violations = violations;
	}
	
	public Jockey getJockey() {
		return jockey;
	}
	public void setJockey(Jockey jockey) {
		this.jockey = jockey;
	}
	@Override
	public String toString() {
	    return "Horse [horseId=" + horseId
	            + ", horseName=" + horseName
	            + ", breed=" + breed
	            + ", status=" + status + "]";
	}
}