package com.fe.horseracing.repository.interfaces;

import java.util.List;

import com.fe.horseracing.enums.ViolationType;
import com.fe.horseracing.pojo.Violation;

public interface IViolationRepository {

    // CREATE
    void save(Violation violation);

    // UPDATE
    void update(Violation violation);

    // DELETE
    void delete(Long violationId);

    // READ
    Violation findById(Long violationId);

    List<Violation> findAll();

    // QUERY
    List<Violation> findByRace(Long raceId);

    List<Violation> findByHorse(Long horseId);

    List<Violation> findByJockey(Long jockeyId);

    List<Violation> findByReferee(Long refereeId);

    List<Violation> findByType(ViolationType violationType);    
}
