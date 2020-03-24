package com.bandtec.gespospring.controller;

import com.bandtec.gespospring.model.Employee;
import com.bandtec.gespospring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping("/create")
    public Employee create(
            @RequestBody Employee employee
    ){
        return employeeRepository.save(employee);
    }
}

