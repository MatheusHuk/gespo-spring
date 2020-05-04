package com.bandtec.gespospring.service.CostCenter;

import com.bandtec.gespospring.entity.table.CustCenter;

import java.util.List;

public interface CostCenterService {
    void save(List<CustCenter> costCenters);
    CustCenter findById(Integer id);
    Boolean update(CustCenter custCenter);
    Boolean delete(Integer id);
}
