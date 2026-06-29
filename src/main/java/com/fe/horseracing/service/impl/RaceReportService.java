package com.fe.horseracing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fe.horseracing.pojo.RaceReport;
import com.fe.horseracing.repository.interfaces.IRaceReportRepository;
import com.fe.horseracing.service.interfaces.IRaceReportService;

@Service
public class RaceReportService implements IRaceReportService {

    private IRaceReportRepository raceReportRepo;

    @Autowired
    public RaceReportService(IRaceReportRepository raceReportRepo) {
        this.raceReportRepo = raceReportRepo;
    }

    
	@Override
	public void save(RaceReport report) {
		// TODO Auto-generated method stub
		raceReportRepo.save(report);
	}

	@Override
	public void update(RaceReport report) {
		// TODO Auto-generated method stub
		raceReportRepo.update(report);
	}

	@Override
	public void delete(Long reportId) {
		// TODO Auto-generated method stub
		raceReportRepo.delete(reportId);
	}

	@Override
	public RaceReport findById(Long reportId) {
		// TODO Auto-generated method stub
		return raceReportRepo.findById(reportId);
	}

	@Override
	public List<RaceReport> findAll() {
		// TODO Auto-generated method stub
		return raceReportRepo.findAll();
	}

	@Override
	public List<RaceReport> findByRace(Long raceId) {
		// TODO Auto-generated method stub
		 return raceReportRepo.findByRace(raceId);
	}

	@Override
	public List<RaceReport> findByReferee(Long refereeId) {
		// TODO Auto-generated method stub
		return raceReportRepo.findByReferee(refereeId);
	}

	@Override
	public void createRaceReport(RaceReport report) {
		// TODO Auto-generated method stub
	    if (report == null)
	        return;

	    save(report);
	}

}
