package com.fe.horseracing.repository.interfaces;

import java.util.List;

import com.fe.horseracing.pojo.RaceReport;

public interface IRaceReportRepository {
	
    void save(RaceReport report);

    void update(RaceReport report);

    void delete(Long reportId);

    RaceReport findById(Long reportId);

    List<RaceReport> findAll();

    List<RaceReport> findByRace(Long raceId);

    List<RaceReport> findByReferee(Long refereeId);
}
