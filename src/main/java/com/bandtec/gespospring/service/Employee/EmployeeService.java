package com.bandtec.gespospring.service.Employee;

import com.bandtec.gespospring.DTO.response.EmployeeDTO;
import com.bandtec.gespospring.entity.table.Employee;

import java.util.List;

public interface EmployeeService {
    void save(List<Employee> employees);
    Employee findByCpf(String cpf);
    Employee findById(Integer id);
    Boolean update(Employee employee);
    Boolean delete(Integer id);
    List<EmployeeDTO> findByProject(Integer projectId);
    List<EmployeeDTO> findByCategory(Integer categoryId);
    List<Employee> findDistinctByProjects(Integer projectId);
    List<Employee> findAll();
}
