package com.bandtec.gespospring.service.Team;

import com.bandtec.gespospring.entity.table.Team;
import com.bandtec.gespospring.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TeamServiceImpl implements TeamService{

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public void save(List<Team> teams) {
        teamRepository.saveAll(teams);
    }

    @Override
    public Team findById(Integer id) {
        return teamRepository.findById(id)
                .orElse(null);
    }

    @Override
    public Boolean update(Team team) {
        return teamRepository.findById(team.getId()).map( team1 -> {
            team1.setName(team.getName());
            return true;
        }).orElse(false);
    }

    @Override
    public Boolean delete(Integer id) {
        return teamRepository.findById(id).map( team1 -> {
            teamRepository.delete(team1);
            return true;
        }).orElse(false);
    }

    @Override
    public List<Team> findAll() {
        return teamRepository.findAll();
    }
}
