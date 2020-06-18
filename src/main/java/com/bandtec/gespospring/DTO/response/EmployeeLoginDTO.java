package com.bandtec.gespospring.DTO.response;

import com.bandtec.gespospring.entity.table.Employee;
import com.bandtec.gespospring.entity.table.Permission;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeLoginDTO {

    private Integer id;
    private String cpf;
    private String name;
    private Permission permission;

    public EmployeeLoginDTO(Employee employee) {
        this.id = employee.getId();
        this.cpf = employee.getCpf();
        this.name = employee.getName();
        this.permission = employee.getPermission();
    }
}
