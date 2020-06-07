package com.bandtec.gespospring.DTO;

import com.bandtec.gespospring.entity.table.Employee;
import com.bandtec.gespospring.entity.table.Permission;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {

    private Integer id;
    private String cpf;
    private String name;
    private Permission permission;

    public EmployeeDTO(Employee employee) {
        this.id = employee.getId();
        this.cpf = employee.getCpf();
        this.name = employee.getName();
        this.permission = employee.getPermission();
    }
}
