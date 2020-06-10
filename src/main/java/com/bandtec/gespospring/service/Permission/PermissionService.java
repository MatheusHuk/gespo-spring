package com.bandtec.gespospring.service.Permission;

import com.bandtec.gespospring.entity.table.Permission;

import java.util.List;

public interface PermissionService {
    void save(List<Permission> permission);
    Permission findById(Integer id);
    Boolean update(Permission permission);
    Boolean delete(Integer id);
    List<Permission> findAll();
}
