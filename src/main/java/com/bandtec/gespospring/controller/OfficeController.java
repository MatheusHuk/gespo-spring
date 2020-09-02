package com.bandtec.gespospring.controller;

import com.bandtec.gespospring.entity.table.Office;
import com.bandtec.gespospring.entity.table.Permission;
import com.bandtec.gespospring.repository.PermissionRepository;
import com.bandtec.gespospring.service.Office.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @PostMapping
    public ResponseEntity create(
            @RequestBody Office office
    ){
        try{
            List<Office> offices = new ArrayList();
            offices.add(office);
            this.service.save(offices);
            return ResponseEntity.created(null).build();
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity update(
            @RequestBody Office office
    ){
        try{
            this.service.update(office);
            return ResponseEntity.ok().build();
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping
    public ResponseEntity delete(
            @RequestParam Integer id
    ){
        try{
            this.service.delete(id);
            return ResponseEntity.ok().build();
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
