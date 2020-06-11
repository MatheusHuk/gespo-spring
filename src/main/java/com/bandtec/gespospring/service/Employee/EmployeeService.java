package com.bandtec.gespospring.service.Employee;

import com.bandtec.gespospring.DTO.EmployeeDTO;
import com.bandtec.gespospring.entity.table.Employee;
import com.bandtec.gespospring.DTO.EmployeeLoginDTO;

import java.util.List;

public interface EmployeeService {
    void save(List<Employee> employees);
    EmployeeLoginDTO findByCpf(String cpf);
    Employee findById(Integer id);
    Boolean update(Employee employee);
    Boolean delete(Integer id);
    List<EmployeeDTO> findByProject(Integer projectId);
    List<EmployeeDTO> findByCategory(Integer categoryId);
    List<Employee> findDistinctByProjects(Integer projectId);
}
