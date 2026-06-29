package com.fe.horseracing.pojo;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "race_reports")
public class RaceReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    private LocalDateTime reportDate;

    @Column(length = 1000)
    private String summary;

    @Column(length = 2000)
    private String remarks;
    
    @PrePersist
    public void prePersist() {
        reportDate = LocalDateTime.now();
    }

    @ManyToOne
    @JoinColumn(name = "race_id")
    private Race race;

    @ManyToOne
    @JoinColumn(name = "referee_id")
    private RaceReferee referee;

    public RaceReport() {
    }

	public Long getReportId() {
		return reportId;
	}

	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}

	public LocalDateTime getReportDate() {
		return reportDate;
	}

	public void setReportDate(LocalDateTime reportDate) {
		this.reportDate = reportDate;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public RaceReferee getReferee() {
		return referee;
	}

	public void setReferee(RaceReferee referee) {
		this.referee = referee;
	}

}
