package com.fe.horseracing.repository.interfaces;

import java.util.List;

import com.fe.horseracing.enums.RegistrationStatus;
import com.fe.horseracing.pojo.Registration;

public interface IRegistrationRepository {

    void save(Registration registration);

    void update(Registration registration);

    void delete(Long registrationId);

    Registration findById(Long registrationId);

    List<Registration> findAll();

    List<Registration> findByHorse(Long horseId);

    List<Registration> findByJockey(Long jockeyId);

    List<Registration> findByRace(Long raceId);

    List<Registration> findByStatus(RegistrationStatus status);

}