package com.bandtec.gespospring.service.ProvisioningHours;

import com.bandtec.gespospring.entity.table.ProvisioningHours;
import com.bandtec.gespospring.entity.view.VwProvisioningHours;
import com.bandtec.gespospring.DTO.VwProvisioningHoursDTO;

import java.util.List;

public interface ProvisioningHoursService {
    void save(List<ProvisioningHours> provisioningHours);
    ProvisioningHours findById(Integer id);
    Boolean update(ProvisioningHours provisioningHours);
    Boolean delete(Integer id);
    List<VwProvisioningHoursDTO> findByFilter(VwProvisioningHours provisioningHoursMouth);
}
