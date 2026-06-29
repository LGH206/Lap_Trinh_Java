package com.fe.horseracing.repository.interfaces;

import java.util.List;

import com.fe.horseracing.enums.TournamentStatus;
import com.fe.horseracing.pojo.Tournament;

public interface ITournamentRepository {

    void save(Tournament tournament);

    void update(Tournament tournament);

    void delete(Long tournamentId);

    Tournament findById(Long tournamentId);

    List<Tournament> findAll();

    List<Tournament> findByStatus(TournamentStatus status);

    List<Tournament> findUpcomingTournaments();

    List<Tournament> findOngoingTournaments();

    List<Tournament> findFinishedTournaments();

}