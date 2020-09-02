package com.bandtec.gespospring.controller;

import com.bandtec.gespospring.entity.table.Office;
import com.bandtec.gespospring.entity.table.Permission;
import com.bandtec.gespospring.repository.PermissionRepository;
import com.bandtec.gespospring.service.Office.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/office")
public class OfficeController {

    @Autowired
    private OfficeService service;

    @Autowired
    private PermissionRepository permissionRepository;

    @GetMapping("/all")
    public ResponseEntity listAll(){
        List<Office> offices = this.service.findAll();

        return offices.size() > 0 ? ResponseEntity.ok(offices) :
                ResponseEntity.noContent().build();
    }

    @GetMapping("/permissions")
    public ResponseEntity listAllPermission(){
        List<Permission> permissions = this.permissionRepository.findAll();

        return permissions.size() > 0 ? ResponseEntity.ok(permissions) :
                ResponseEntity.noContent().build();
    }
}
