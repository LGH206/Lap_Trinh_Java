package com.fe.horseracing.service.interfaces;

import java.util.List;

import com.fe.horseracing.enums.RefereeStatus;
import com.fe.horseracing.pojo.Invitation;
import com.fe.horseracing.pojo.Race;
import com.fe.horseracing.pojo.RaceReferee;
import com.fe.horseracing.pojo.RaceReport;
import com.fe.horseracing.pojo.RaceResult;
import com.fe.horseracing.pojo.Violation;

public interface IRaceRefereeService {

    void save(RaceReferee referee);

    void update(RaceReferee referee);

    void delete(Long refereeId);

    RaceReferee findById(Long refereeId);

    List<RaceReferee> findAll();

    List<RaceReferee> findByStatus(RefereeStatus status);

    RaceReferee findByLicenseNumber(String licenseNumber);

    List<RaceReferee> findAvailableReferees();

    boolean inspectHorse(Long horseId);

    void recordViolation(Violation violation);

    void createRaceReport(RaceReport report);

    List<RaceResult> getRaceRanking(Long raceId);

	void verifyRaceResult(Long raceId);
	
	List<Invitation> viewInvitations(Long refereeId);

	void acceptInvitation(Long invitationId);

	void rejectInvitation(Long invitationId);

	List<Race> viewAssignedRaces(Long refereeId);

	Race viewRace(Long raceId);

	void startRace(Long raceId);

	void finishRace(Long raceId);

}