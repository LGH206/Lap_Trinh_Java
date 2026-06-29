package com.fe.horseracing.repository.interfaces;

import java.util.List;

import com.fe.horseracing.pojo.Spectator;

public interface ISpectatorRepository {

    // CRUD

    void save(Spectator spectator);

    void update(Spectator spectator);

    void delete(Long spectatorId);

    Spectator findById(Long spectatorId);

    List<Spectator> findAll();

}