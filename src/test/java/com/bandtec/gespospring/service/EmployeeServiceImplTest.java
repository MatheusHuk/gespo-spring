package com.bandtec.gespospring.service;

import com.bandtec.gespospring.entity.table.Employee;
import com.bandtec.gespospring.repository.EmployeeRepository;
import com.bandtec.gespospring.service.Employee.EmployeeService;
import com.bandtec.gespospring.service.Employee.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeServiceImplTest {

    Class serviceClass = EmployeeServiceImpl.class;

    @Autowired
    EmployeeService employeeService;

    @MockBean
    EmployeeRepository employeeRepository;

    @MockBean
    BCryptPasswordEncoder bCryptPasswordEncoder;

    Employee employee = new Employee();

    List<Employee> employees = new ArrayList<>(Arrays.asList(new Employee(), new Employee()));

    @Test
    void testConfigService() {
        assertTrue(this.serviceClass.isAnnotationPresent(Service.class));
        assertTrue(this.serviceClass.isAnnotationPresent(Transactional.class));
    }

    @Test
    void findByCpf() {
        this.employee.setCpf("50172763860");
        Mockito.when(this.employeeRepository.findByCpf("50172763860")).thenReturn(this.employee);
        Employee employeeFounded = this.employeeService.findByCpf("50172763860");

        assertEquals(this.employee.getCpf(), employeeFounded.getCpf());
    }

    @Test
    void findById() {
        this.employee.setId(1);
        Mockito.when(this.employeeRepository.findById(1)).thenReturn(Optional.of(this.employee));
        Employee employeeFounded = this.employeeService.findById(1);

        assertEquals(this.employee, employeeFounded);
    }

    @Test
    void findByIdWhenEmployeeNotFound() {
        this.employee.setId(1);
        Mockito.when(this.employeeRepository.findById(1)).thenReturn(Optional.of(this.employee));

        assertNull(this.employeeService.findById(1));
    }

    @Test
    void update() {
        this.employee.setId(1);

        Mockito.when(this.employeeRepository.findById(this.employee.getId())).thenReturn(Optional.of(this.employee));

        assertTrue(this.employeeService.update(this.employee));
        Mockito.verify(this.employeeRepository, Mockito.times(1)).save(this.employee);
    }

    @Test
    void updateWhenEmployeeNotFound() {
        this.employee.setId(1);

        Mockito.when(this.employeeRepository.findById(this.employee.getId())).thenReturn(Optional.empty());

        assertFalse(this.employeeService.update(this.employee));
        Mockito.verify(this.employeeRepository, Mockito.never()).save(this.employee);
    }

    @Test
    void delete() {
        this.employee.setId(1);

        Mockito.when(this.employeeRepository.findById(this.employee.getId())).thenReturn(Optional.of(this.employee));

        assertTrue(this.employeeService.delete(this.employee.getId()));
        Mockito.verify(this.employeeRepository, Mockito.times(1)).delete(this.employee);
    }

    @Test
    void deleteWhenEmployeeNotFound() {
        this.employee.setId(1);

        Mockito.when(this.employeeRepository.findById(this.employee.getId())).thenReturn(Optional.empty());

        assertFalse(this.employeeService.delete(this.employee.getId()));
        Mockito.verify(this.employeeRepository, Mockito.never()).delete(this.employee);
    }

    @Test
    void findAll() {
        Mockito.when(this.employeeRepository.findAll()).thenReturn(this.employees);
        List<Employee> employees = this.employeeService.findAll();

        assertEquals(this.employees, employees);
    }
}