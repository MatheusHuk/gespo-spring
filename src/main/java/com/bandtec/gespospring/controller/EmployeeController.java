package com.bandtec.gespospring.controller;

import com.bandtec.gespospring.dto.LoginDto;
import com.bandtec.gespospring.model.Employee;
import com.bandtec.gespospring.service.SecurityService;
import com.bandtec.gespospring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class EmployeeController {

    @Autowired
    UserService userService;

    @Autowired
    private SecurityService securityService;

    @PostMapping("/registration")
    public ResponseEntity registration(
            @RequestBody Employee employee
    ) {
        userService.save(employee);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/login")
    public ResponseEntity login(
            @RequestParam(name = "cpf") String cpf,
            @RequestParam(name = "password") String password
    ) {
        if (cpf == null || password == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        Employee user = securityService.autoLogin(cpf, password);

        return user != null ? ResponseEntity.status(HttpStatus.OK).body(user) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}

