package com.bandtec.gespospring.model;

import com.bandtec.gespospring.entity.Employee;
import com.bandtec.gespospring.entity.Permission;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeModel {

    public EmployeeModel(Employee employee) {
        this.id = employee.getId();
        this.cpf = employee.getCpf();
        this.name = employee.getName();
        this.permission = employee.getPermission();
    }

    private Integer id;
    private String cpf;
    private String name;
    private Permission permission;

}
