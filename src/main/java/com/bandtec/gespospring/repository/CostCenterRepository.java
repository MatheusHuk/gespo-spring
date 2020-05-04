package com.bandtec.gespospring.repository;

import com.bandtec.gespospring.entity.table.CostCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CostCenterRepository extends JpaRepository<CostCenter, Integer> {
}
