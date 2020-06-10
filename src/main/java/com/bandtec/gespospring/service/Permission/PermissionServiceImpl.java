package com.bandtec.gespospring.service.Permission;

import com.bandtec.gespospring.entity.table.Permission;
import com.bandtec.gespospring.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public void save(List<Permission> permissions) {
        permissionRepository.saveAll(permissions);
    }

    @Override
    public Permission findById(Integer id) {
        return permissionRepository.findById(id)
                .orElse(null);
    }

    @Override
    public Boolean update(Permission permission) {
        return permissionRepository.findById(permission.getId()).map( perm -> {
            perm.setDsPermission(permission.getDsPermission());
            return true;
        }).orElse(false);
    }

    @Override
    public Boolean delete(Integer id) {
        return permissionRepository.findById(id).map( perm -> {
            permissionRepository.delete(perm);
            return true;
        }).orElse(false);
    }

    @Override
    public List<Permission> findAll() {
        return permissionRepository.findAll();
    }
}
