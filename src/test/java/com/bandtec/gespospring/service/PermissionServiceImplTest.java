package com.bandtec.gespospring.service;

import com.bandtec.gespospring.entity.table.Permission;
import com.bandtec.gespospring.repository.PermissionRepository;
import com.bandtec.gespospring.service.Permission.PermissionService;
import com.bandtec.gespospring.service.Permission.PermissionServiceImpl;
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
public class PermissionServiceImplTest {

    Class serviceClass = PermissionServiceImpl.class;

    @Autowired
    PermissionService permissionService;

    @MockBean
    PermissionRepository permissionRepository;

    Permission permission = new Permission();

    @Test
    void testConfigService() {
        assertTrue(this.serviceClass.isAnnotationPresent(Service.class));
        assertTrue(this.serviceClass.isAnnotationPresent(Transactional.class));
    }

    @Test
    void findById() {
        permission.setId(1);
        Mockito.when(this.permissionRepository.findById(1)).thenReturn(Optional.of(this.permission));
        Permission costCenterFounded = this.permissionService.findById(1);

        assertEquals(this.permission, costCenterFounded);
    }

    @Test
    void findByIdWhenPermissionNotFound() {
        permission.setId(1);
        Mockito.when(this.permissionRepository.findById(1)).thenReturn(Optional.empty());

        assertNull(this.permissionService.findById(1));
    }

    @Test
    void update() {
        this.permission.setId(1);
        Mockito.when(this.permissionRepository.findById(this.permission.getId())).thenReturn(Optional.of(this.permission));

        assertTrue(this.permissionService.update(this.permission));
    }

    @Test
    void delete() {
        this.permission.setId(1);
        Mockito.when(this.permissionRepository.findById(this.permission.getId())).thenReturn(Optional.of(this.permission));

        assertTrue(this.permissionService.delete(this.permission.getId()));
    }

    @Test
    void findAll() {
        List<Permission> permissions = new ArrayList<>(Arrays.asList(new Permission(), new Permission()));
        Mockito.when(this.permissionRepository.findAll()).thenReturn(permissions);
        List<Permission> allCategories = this.permissionRepository.findAll();

        assertEquals(permissions, allCategories);
    }
}
