package com.bandtec.gespospring.service.CostCenter;

import com.bandtec.gespospring.entity.table.CostCenter;

import java.util.List;

public interface CostCenterService {
    void save(List<CostCenter> costCenters);
    CostCenter findById(Integer id);
    Boolean update(CostCenter costCenter);
    Boolean delete(Integer id);
    List<CostCenter> findAll();
}
