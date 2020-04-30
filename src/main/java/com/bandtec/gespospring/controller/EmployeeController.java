package com.bandtec.gespospring.controller;

import com.bandtec.gespospring.entity.Employee;
import com.bandtec.gespospring.model.EmployeeModel;
import com.bandtec.gespospring.service.SecurityService;
import com.bandtec.gespospring.service.EmployeeService;
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

    @PostMapping
    public ResponseEntity create(
            @RequestBody List<Employee> employees
    ) {
        employeeService.save(employees);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/login")
    public ResponseEntity login(
            @RequestParam String cpf,
            @RequestParam String password
    ) {
        if (cpf == null || password == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        EmployeeModel user = securityService.autoLogin(cpf, password);

        return user != null ? ResponseEntity.status(HttpStatus.OK).body(user) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping
    public ResponseEntity read(
            @RequestParam Integer id
    ) {
        Employee employee = employeeService.findById(id);
        return employee != null ? ResponseEntity.status(HttpStatus.OK).body(employee):
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping
    public ResponseEntity delete(
            @RequestParam Integer id
    ) {
        return employeeService.delete(id) ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping
    public ResponseEntity update(
            @RequestBody Employee employee
    ) {
        return employeeService.update(employee) ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}

