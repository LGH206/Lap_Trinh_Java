package com.fe.horseracing.repository.interfaces;

import java.util.List;

import com.fe.horseracing.enums.RefereeStatus;
import com.fe.horseracing.pojo.RaceReferee;

public interface IRaceRefereeRepository {

    // CREATE
    void save(RaceReferee referee);

    // UPDATE
    void update(RaceReferee referee);

    // DELETE
    void delete(Long refereeId);

    // READ
    RaceReferee findById(Long refereeId);

    List<RaceReferee> findAll();

    // QUERY
    List<RaceReferee> findByStatus(RefereeStatus status);

    RaceReferee findByLicenseNumber(String licenseNumber);

    List<RaceReferee> findAvailableReferees();

}