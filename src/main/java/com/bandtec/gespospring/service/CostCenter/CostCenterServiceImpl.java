package com.bandtec.gespospring.service.CostCenter;

import com.bandtec.gespospring.entity.table.CustCenter;
import com.bandtec.gespospring.repository.CustCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CostCenterServiceImpl implements CostCenterService {

    @Autowired
    private CustCenterRepository custCenterRepository;

    @Override
    public void save(List<CustCenter> costCenters){
        custCenterRepository.saveAll(costCenters);
    }

    @Override
    public CustCenter findById(Integer id) {
        return custCenterRepository.findById(id)
                .orElse(null);
    }

    @Override
    public Boolean update(CustCenter custCenter) {
        return custCenterRepository.findById(custCenter.getId()).map(cost -> {
            cost.setCnpj(custCenter.getCnpj());
            cost.setName(custCenter.getName());
            custCenterRepository.save(cost);

            return true;
        }).orElse(false);
    }

    @Override
    public Boolean delete(Integer id) {
        return custCenterRepository.findById(id).map(cost -> {
            custCenterRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}
