package com.bandtec.gespospring.repository;

import com.bandtec.gespospring.entity.view.VwProjectIsNot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VwProjectIsNotRepository extends JpaRepository<VwProjectIsNot, Integer> {
    List<VwProjectIsNot> findAllByProjectIdsIsNotContainingOrProjectIdsIsNull(String isNotLike);
}
