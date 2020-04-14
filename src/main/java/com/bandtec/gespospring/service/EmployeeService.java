package com.bandtec.gespospring.service;

import com.bandtec.gespospring.model.Employee;

import java.util.List;

public interface EmployeeService {
    void save(List<Employee> employees);
    Employee findByCpf(String cpf);
    Employee findById(Integer id);
    Boolean update(Employee employee);
    Boolean delete(Integer id);
}
