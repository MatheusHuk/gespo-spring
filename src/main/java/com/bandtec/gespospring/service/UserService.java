package com.bandtec.gespospring.service;

import com.bandtec.gespospring.model.Employee;

public interface UserService {
    void save(Employee employee);
    Employee findByUsername(String username);
}
