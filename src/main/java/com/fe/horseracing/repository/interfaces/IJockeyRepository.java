package com.fe.horseracing.repository.interfaces;

import java.util.List;

import com.fe.horseracing.enums.JockeyStatus;
import com.fe.horseracing.pojo.Jockey;

public interface IJockeyRepository {

    // CRUD

    void save(Jockey jockey);

    void update(Jockey jockey);

    void delete(Long jockeyId);

    Jockey findById(Long jockeyId);

    List<Jockey> findAll();

    // Query

    Jockey findByLicenseNumber(String licenseNumber);

    List<Jockey> findByStatus(JockeyStatus status);

    List<Jockey> findAvailableJockeys();

}