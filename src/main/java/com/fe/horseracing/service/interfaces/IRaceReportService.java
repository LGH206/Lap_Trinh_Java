package com.fe.horseracing.service.interfaces;

import java.util.List;

import com.fe.horseracing.pojo.RaceReport;

public interface IRaceReportService {

    // CREATE
    void save(RaceReport report);

    // UPDATE
    void update(RaceReport report);

    // DELETE
    void delete(Long reportId);

    // READ
    RaceReport findById(Long reportId);

    List<RaceReport> findAll();

    // QUERY
    List<RaceReport> findByRace(Long raceId);

    List<RaceReport> findByReferee(Long refereeId);

    // BUSINESS
    void createRaceReport(RaceReport report);

}