package com.bandtec.gespospring.controller;

import com.bandtec.gespospring.model.EmployeeModel;
import com.bandtec.gespospring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/usuario")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping("/cadastro")
    public EmployeeModel create(
            @RequestBody EmployeeModel employee
    ){
        return employeeRepository.save(employee);
    }
}

