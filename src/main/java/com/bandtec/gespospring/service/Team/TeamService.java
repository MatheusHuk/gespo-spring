package com.bandtec.gespospring.service.Team;

import com.bandtec.gespospring.entity.table.Team;

import java.util.List;

public interface TeamService {
    void save(List<Team> teams);
    Team findById(Integer id);
    Boolean update(Team team);
    Boolean delete(Integer id);
    List<Team> findAll();
}
