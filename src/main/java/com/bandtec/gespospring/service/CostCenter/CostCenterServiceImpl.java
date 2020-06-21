package com.bandtec.gespospring.service.CostCenter;

import com.bandtec.gespospring.entity.table.CostCenter;
import com.bandtec.gespospring.repository.CostCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CostCenterServiceImpl implements CostCenterService {

    @Autowired
    private CostCenterRepository costCenterRepository;

    @Override
    public void save(List<CostCenter> costCenters) {
        costCenterRepository.saveAll(costCenters);
    }

    @Override
    public CostCenter findById(Integer id) {
        return costCenterRepository.findById(id)
                .orElse(null);
    }

    @Override
    public Boolean update(CostCenter costCenter) {
        return costCenterRepository.findById(costCenter.getId()).map(cost -> {
            cost.setCnpj(costCenter.getCnpj());
            cost.setName(costCenter.getName());
            costCenterRepository.save(cost);

            return true;
        }).orElse(false);
    }

    @Override
    public Boolean delete(Integer id) {
        return costCenterRepository.findById(id).map(cost -> {
            costCenterRepository.delete(cost);
            return true;
        }).orElse(false);
    }

    @Override
    public List<CostCenter> findAll() {
        return costCenterRepository.findAll();
    }
}
