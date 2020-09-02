package com.bandtec.gespospring.service.Office;

import com.bandtec.gespospring.entity.table.Office;

import java.util.List;

public interface OfficeService {
    void save(List<Office> offices);
    Boolean update(Office office);
    Boolean delete(Integer id);
    List<Office> findAll();
}
