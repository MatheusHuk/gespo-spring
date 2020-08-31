package com.bandtec.gespospring.controller;

import com.bandtec.gespospring.DTO.response.EmployeeDTO;
import com.bandtec.gespospring.entity.table.Employee;
import com.bandtec.gespospring.service.Security.SecurityService;
import com.bandtec.gespospring.service.Employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private SecurityService securityService;

    @GetMapping("/login")
    public ResponseEntity login(
            @RequestParam String cpf,
            @RequestParam String password
    ) {
        if (cpf == null || password == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        Employee user = securityService.autoLogin(cpf, password);

        return user != null ? ResponseEntity.status(HttpStatus.OK).body(user) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/registration")
    public ResponseEntity create(
            @RequestBody List<Employee> employees
    ) {
        try {
            employeeService.save(employees);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    public ResponseEntity read(
            @RequestParam Integer id
    ) {
        Employee employee = employeeService.findById(id);
        return employee != null ? ResponseEntity.status(HttpStatus.OK).body(employee):
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping
    public ResponseEntity update(
            @RequestBody Employee employee
    ) {
        return employeeService.update(employee) ? ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping
    public ResponseEntity delete(
            @RequestParam Integer id
    ) {
        return employeeService.delete(id) ? ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/all")
    public ResponseEntity readAll(){
        List<Employee> employees = employeeService.findAll();

        return employees.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.status(HttpStatus.OK).body(employees);
    }

    @GetMapping("/project")
    public ResponseEntity findByProject(
            @RequestParam Integer projectId
    ) {
        List<EmployeeDTO> employeeDTOList = employeeService.findByProject(projectId);

        return employeeDTOList.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.status(HttpStatus.OK).body(employeeDTOList);
    }

    @GetMapping("/category")
    public ResponseEntity findByCategory(
            @RequestParam Integer categoryId
    ) {
        List<EmployeeDTO> employeeDTOList = employeeService.findByCategory(categoryId);

        return employeeDTOList.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.status(HttpStatus.OK).body(employeeDTOList);
    }

    @GetMapping("/project-is-not")
    public ResponseEntity findDistinctByProjects(
            @RequestParam Integer projectId
    ) {
        List<Employee> employees = employeeService.findDistinctByProjects(projectId);

        return employees.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.status(HttpStatus.OK).body(employees);
    }

    @GetMapping("/manager")
    public ResponseEntity findAllManagers(){
        List<Employee> managers = employeeService.findAllManagers();

        return managers.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.status(HttpStatus.OK).body(managers);
    }
}

