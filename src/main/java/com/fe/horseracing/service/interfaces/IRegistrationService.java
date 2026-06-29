package com.fe.horseracing.service.interfaces;

import java.util.List;

import com.fe.horseracing.enums.RegistrationStatus;
import com.fe.horseracing.pojo.Registration;

public interface IRegistrationService {

    // CRUD
    void save(Registration registration);

    void update(Registration registration);

    void delete(Long registrationId);

    Registration findById(Long registrationId);

    List<Registration> findAll();

    // Query
    List<Registration> findByHorse(Long horseId);

    List<Registration> findByJockey(Long jockeyId);

    List<Registration> findByRace(Long raceId);

    List<Registration> findByStatus(RegistrationStatus status);

    // Business
    void submitRegistration(Registration registration);

    void approveRegistration(Long registrationId);

    void rejectRegistration(Long registrationId);

    void confirmParticipation(Long registrationId);

    void cancelRegistration(Long registrationId);

	void registerHorseToRace(Long horseId, Long jockeyId, Long raceId);


}