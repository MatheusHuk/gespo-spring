package com.bandtec.gespospring.DTO;

import com.bandtec.gespospring.entity.table.Employee;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {
    private Employee employee;

    public EmployeeDTO(Employee employee) {
        this.employee = new Employee();

        this.employee.setId(employee.getId());
        this.employee.setName(employee.getName());
        this.employee.setTeam(employee.getTeam());
        this.employee.setCategory(employee.getCategory());
    }
}
