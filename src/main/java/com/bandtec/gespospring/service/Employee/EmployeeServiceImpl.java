package com.bandtec.gespospring.service.Employee;

import com.bandtec.gespospring.DTO.response.EmployeeDTO;
import com.bandtec.gespospring.entity.table.Category;
import com.bandtec.gespospring.entity.table.Employee;
import com.bandtec.gespospring.DTO.response.EmployeeLoginDTO;
import com.bandtec.gespospring.entity.table.Project;
import com.bandtec.gespospring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(List<Employee> employees) {
        for (Employee emp :
                employees) {
            emp.setPassword(bCryptPasswordEncoder.encode(emp.getPassword()));
        }
        employeeRepository.saveAll(employees);
    }

    @Override
    public EmployeeLoginDTO findByCpf(String cpf) {
        return employeeRepository.findByCpdScoped(cpf);
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.findById(id)
                .orElse(null);
    }

    @Override
    public Boolean update(Employee employee) {
        return employeeRepository.findById(employee.getId()).map(emp -> {
            emp.setCpf(employee.getCpf());
            emp.setName(employee.getName());
            emp.setPassword(bCryptPasswordEncoder.encode(employee.getPassword()));
            emp.setEmail(employee.getEmail());
            emp.setHourValue(employee.getHourValue());
            emp.setOffice(employee.getOffice());
            emp.setDtBirth(employee.getDtBirth());
            emp.setProjects(employee.getProjects());
            emp.setTeam(employee.getTeam());
            emp.setCategory(employee.getCategory());
            emp.setPermission(employee.getPermission());

            employeeRepository.save(emp);

            return true;
        }).orElse(false);
    }

    @Override
    public Boolean delete(Integer id) {
        return employeeRepository.findById(id).map(emp -> {
            employeeRepository.deleteById(id);
            return true;
        }).orElse(false);
    }

    @Override
    public List<EmployeeDTO> findByProject(Integer projectId) {
         Project project = new Project();
         project.setId(projectId);

         List<Employee> employees = employeeRepository.findByProjects(project);
         List<EmployeeDTO> employeeDTOList = new ArrayList<>();

         if(employees.isEmpty()){
             return employeeDTOList;
         }

        for (Employee employee : employees) {
            employeeDTOList.add(new EmployeeDTO(employee));
        }

        return employeeDTOList;
    }

    @Override
    public List<EmployeeDTO> findByCategory(Integer categoryId) {
        Category category = new Category();
        category.setId(categoryId);

        List<Employee> employees = employeeRepository.findByCategory(category);
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();

        if(employees.isEmpty()){
            return employeeDTOList;
        }

        for (Employee employee : employees) {
            employeeDTOList.add(new EmployeeDTO(employee));
        }

        return employeeDTOList;
    }

    @Override
    public List<Employee> findDistinctByProjects(Integer projectId) {
        Project project = new Project();
        project.setId(projectId);

        return employeeRepository.findByProjectsIsNot(project);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
