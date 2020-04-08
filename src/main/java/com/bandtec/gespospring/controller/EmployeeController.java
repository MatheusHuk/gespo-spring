package com.bandtec.gespospring.controller;

import com.bandtec.gespospring.dto.LoginDto;
import com.bandtec.gespospring.model.Employee;
import com.bandtec.gespospring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping("/create")
    public Employee create(
            @RequestBody Employee employee
    ) {
        return employeeRepository.save(employee);
    }

    @GetMapping("/login")
    public ResponseEntity login(
            @RequestParam(name = "cpf") String cpf,
            @RequestParam(name = "password") String password
    ) {
        if (cpf == null || password == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        Employee user = employeeRepository.findByPasswordAndCpf(password, cpf);

        return user != null ? ResponseEntity.status(HttpStatus.OK).body(user) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}

