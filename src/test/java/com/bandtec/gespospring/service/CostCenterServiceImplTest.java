package com.bandtec.gespospring.service;

import com.bandtec.gespospring.entity.table.CostCenter;
import com.bandtec.gespospring.repository.CostCenterRepository;
import com.bandtec.gespospring.service.CostCenter.CostCenterService;
import com.bandtec.gespospring.service.CostCenter.CostCenterServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CostCenterServiceImplTest {

    Class serviceClass = CostCenterServiceImpl.class;

    @Autowired
    CostCenterService costCenterService;

    @MockBean
    CostCenterRepository costCenterRepository;

    CostCenter costCenter = new CostCenter();

    @Test
    void testConfigService() {
        assertTrue(this.serviceClass.isAnnotationPresent(Service.class));
        assertTrue(this.serviceClass.isAnnotationPresent(Transactional.class));
    }

    @Test
    void findById() {
        this.costCenter.setId(1);
        Mockito.when(this.costCenterRepository.findById(1)).thenReturn(Optional.of(this.costCenter));
        CostCenter costCenterFounded = this.costCenterService.findById(1);

        assertEquals(this.costCenter, costCenterFounded);
    }

    @Test
    void findByIdWhenCostCenterNotFound() {
        this.costCenter.setId(1);
        Mockito.when(this.costCenterRepository.findById(1)).thenReturn(Optional.empty());

        assertNull(this.costCenterService.findById(1));
    }

    @Test
    void update() {
        this.costCenter.setId(1);
        Mockito.when(this.costCenterRepository.findById(this.costCenter.getId())).thenReturn(Optional.of(this.costCenter));

        assertTrue(this.costCenterService.update(this.costCenter));
        Mockito.verify(this.costCenterRepository, Mockito.times(1)).save(this.costCenter);
    }

    @Test
    void updateWhenCostCenterNotFound() {
        this.costCenter.setId(1);
        Mockito.when(this.costCenterRepository.findById(this.costCenter.getId())).thenReturn(Optional.empty());

        assertFalse(this.costCenterService.update(this.costCenter));
        Mockito.verify(this.costCenterRepository, Mockito.never()).save(this.costCenter);
    }

    @Test
    void delete() {
        this.costCenter.setId(1);
        Mockito.when(this.costCenterRepository.findById(this.costCenter.getId())).thenReturn(Optional.of(this.costCenter));

        assertTrue(this.costCenterService.delete(this.costCenter.getId()));
        Mockito.verify(this.costCenterRepository, Mockito.times(1)).delete(this.costCenter);
    }

    @Test
    void deleteWhenCostCenterNotFound() {
        this.costCenter.setId(1);
        Mockito.when(this.costCenterRepository.findById(this.costCenter.getId())).thenReturn(Optional.empty());

        assertFalse(this.costCenterService.delete(this.costCenter.getId()));
        Mockito.verify(this.costCenterRepository, Mockito.never()).delete(this.costCenter);
    }

    @Test
    void findAll() {
        List<CostCenter> costCenters = new ArrayList<>(Arrays.asList(new CostCenter(), new CostCenter()));
        Mockito.when(this.costCenterRepository.findAll()).thenReturn(costCenters);
        List<CostCenter> allCategories = this.costCenterRepository.findAll();

        assertEquals(costCenters, allCategories);
    }
}