package com.fe.horseracing.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fe.horseracing.DAO.RaceReportDAO;
import com.fe.horseracing.pojo.RaceReport;
import com.fe.horseracing.repository.interfaces.IRaceReportRepository;

@Repository
public class RaceReportRepository implements IRaceReportRepository {

    @Autowired
    private RaceReportDAO raceReportDAO;
    
	@Override
	public void save(RaceReport report) {
		// TODO Auto-generated method stub
		raceReportDAO.save(report);
	}

	@Override
	public void update(RaceReport report) {
		// TODO Auto-generated method stub
		raceReportDAO.update(report);
	}

	@Override
	public void delete(Long reportId) {
		// TODO Auto-generated method stub
		raceReportDAO.delete(reportId);
	}

	@Override
	public RaceReport findById(Long reportId) {
		// TODO Auto-generated method stub
		return raceReportDAO.findById(reportId);
	}

	@Override
	public List<RaceReport> findAll() {
		// TODO Auto-generated method stub
		return raceReportDAO.findAll();
	}

	@Override
	public List<RaceReport> findByRace(Long raceId) {
		// TODO Auto-generated method stub
		return raceReportDAO.findByRace(raceId);
	}

	@Override
	public List<RaceReport> findByReferee(Long refereeId) {
		// TODO Auto-generated method stub
		return raceReportDAO.findByReferee(refereeId);
	}

}
