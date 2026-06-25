package com.example.dao;

import com.example.model.Tournament;
import java.util.List;

public interface TournamentDAO {
    void save(Tournament tournament);
    List<Tournament> findAll();
    Tournament findById(int id);
}
