package com.bandtec.gespospring.service;

import com.bandtec.gespospring.entity.CustCenter;
import com.bandtec.gespospring.repository.CustCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CustCenterServiceImpl implements CustCenterService{

    @Autowired
    private CustCenterRepository custCenterRepository;

    @Override
    public void save(List<CustCenter> custCenters){
        custCenterRepository.saveAll(custCenters);
    }

    @Override
    public CustCenter findById(Integer id) {
        return custCenterRepository.findById(id)
                .orElse(null);
    }

    @Override
    public Boolean update(CustCenter custCenter) {
        return custCenterRepository.findById(custCenter.getId()).map(cust -> {
            cust.setCnpj(custCenter.getCnpj());
            cust.setName(custCenter.getName());
            custCenterRepository.save(cust);

            return true;
        }).orElse(false);
    }

    @Override
    public Boolean delete(Integer id) {
        return custCenterRepository.findById(id).map(cust -> {
            custCenterRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}
