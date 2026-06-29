package com.fe.horseracing.service.interfaces;

import java.util.List;

import com.fe.horseracing.enums.ViolationType;
import com.fe.horseracing.pojo.Violation;

public interface IViolationService {
	
    void save(Violation violation);

    void update(Violation violation);

    void delete(Long violationId);

    Violation findById(Long violationId);

    List<Violation> findAll();

    List<Violation> findByRace(Long raceId);

    List<Violation> findByHorse(Long horseId);

    List<Violation> findByJockey(Long jockeyId);

    List<Violation> findByReferee(Long refereeId);

    List<Violation> findByType(ViolationType violationType);

    void recordViolation(Violation violation);
}
