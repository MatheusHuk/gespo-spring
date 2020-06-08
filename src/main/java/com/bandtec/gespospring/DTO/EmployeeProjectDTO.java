package com.bandtec.gespospring.DTO;

import com.bandtec.gespospring.entity.table.Employee;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeProjectDTO {
    private Employee employee;

    public EmployeeProjectDTO(Employee employee) {
        this.employee = new Employee();

        this.employee.setId(employee.getId());
        this.employee.setName(employee.getName());
        this.employee.setCategory(employee.getCategory());
    }
}
