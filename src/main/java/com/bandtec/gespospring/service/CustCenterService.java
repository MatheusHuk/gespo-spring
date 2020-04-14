package com.bandtec.gespospring.service;

import com.bandtec.gespospring.model.CustCenter;

import java.util.List;

public interface CustCenterService {
    void save(List<CustCenter> custCenters);
    CustCenter findById(Integer id);
    Boolean update(CustCenter custCenter);
    Boolean delete(Integer id);
}
