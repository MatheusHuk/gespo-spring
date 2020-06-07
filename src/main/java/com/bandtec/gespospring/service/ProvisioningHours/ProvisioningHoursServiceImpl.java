package com.bandtec.gespospring.service.ProvisioningHours;

import com.bandtec.gespospring.entity.table.ProvisioningHours;
import com.bandtec.gespospring.entity.view.VwProvisioningHours;
import com.bandtec.gespospring.DTO.VwProvisioningHoursDTO;
import com.bandtec.gespospring.repository.ProvisioningHoursRepository;
import com.bandtec.gespospring.repository.VwProvisioningHoursRepository;
import org.springframework.data.domain.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class ProvisioningHoursServiceImpl implements ProvisioningHoursService{

    @Autowired
    private ProvisioningHoursRepository provisioningHoursRepository;

    @Autowired
    private VwProvisioningHoursRepository provisioningHoursMouthRepository;

    @Override
    public void save(List<ProvisioningHours> provisioningHours) {
        provisioningHoursRepository.saveAll(provisioningHours);
    }

    @Override
    public ProvisioningHours findById(Integer id) {
        return provisioningHoursRepository.findById(id)
                .orElse(null);
    }

    @Override
    public Boolean update(ProvisioningHours provisioningHours) {
        return provisioningHoursRepository.findById(provisioningHours.getId()).map( hours -> {
            hours.setAmountHours(provisioningHours.getAmountHours());
            hours.setEmployee(provisioningHours.getEmployee());
            hours.setProject(provisioningHours.getProject());

            provisioningHoursRepository.save(hours);
            return true;
        }).orElse(false);
    }

    @Override
    public Boolean delete(Integer id) {
        return provisioningHoursRepository.findById(id).map( hours -> {
            provisioningHoursRepository.deleteById(id);
            return true;
        }).orElse(false);
    }

    @Override
    public List<VwProvisioningHoursDTO> findByFilter(VwProvisioningHours provisioningHoursMouth) {
        List<VwProvisioningHours> provisioningHoursList = provisioningHoursMouthRepository
                .findAll(Example.of(provisioningHoursMouth));

        List<VwProvisioningHoursDTO> provisioningHoursModels = new ArrayList<>();

        if (provisioningHoursList.isEmpty()) {
            return provisioningHoursModels;
        }

        for (VwProvisioningHours prov :
                provisioningHoursList) {
            provisioningHoursModels.add(new VwProvisioningHoursDTO(prov));
        }

        return provisioningHoursModels;
    }
}
