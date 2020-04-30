package com.bandtec.gespospring.repository;

import com.bandtec.gespospring.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Integer> {
}
