package com.bandtec.gespospring.repository;

import com.bandtec.gespospring.entity.table.Office;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficeRepository extends JpaRepository<Office, Integer> {
}
