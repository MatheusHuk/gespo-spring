package com.bandtec.gespospring.service.Employee;

import com.bandtec.gespospring.entity.table.Employee;
import com.bandtec.gespospring.model.EmployeeModel;

import java.util.List;

public interface EmployeeService {
    void save(List<Employee> employees);
    EmployeeModel findByCpf(String cpf);
    Employee findById(Integer id);
    Boolean update(Employee employee);
    Boolean delete(Integer id);
}