package com.bandtec.gespospring.service;

import com.bandtec.gespospring.model.Employee;
import com.bandtec.gespospring.repository.EmployeeRepository;
import com.bandtec.gespospring.repository.PermissionRepository;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(Employee employee) {
        employee.setPassword(bCryptPasswordEncoder.encode(employee.getPassword()));
        employeeRepository.save(employee);
    }

    @Override
    public Employee findByUsername(String cpf) {
        return employeeRepository.findByCpf(cpf);
    }
}
