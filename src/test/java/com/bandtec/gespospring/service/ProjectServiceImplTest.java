package com.bandtec.gespospring.service;

import com.bandtec.gespospring.DTO.request.ProjectUpdateDTO;
import com.bandtec.gespospring.entity.table.Employee;
import com.bandtec.gespospring.entity.table.Project;
import com.bandtec.gespospring.repository.EmployeeRepository;
import com.bandtec.gespospring.repository.ProjectRepository;
import com.bandtec.gespospring.service.Project.ProjectService;
import com.bandtec.gespospring.service.Project.ProjectServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProjectServiceImplTest {

    private Class serviceClass = ProjectServiceImpl.class;

    @MockBean
    private ProjectRepository projectRepository;

    @MockBean
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProjectService projectService;

    private Project project = new Project();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testConfigService() {
        assertTrue(this.serviceClass.isAnnotationPresent(Service.class));
        assertTrue(this.serviceClass.isAnnotationPresent(Transactional.class));
    }

    @Test
    void findById() {
        this.project.setId(1);
        Mockito.when(this.projectRepository.findById(this.project.getId())).thenReturn(Optional.of(this.project));

        Project project = this.projectService.findById(this.project.getId());
        assertEquals(this.project, project);
    }

    @Test
    void findByIdWhenProjectNotFound() {
        this.project.setId(1);
        Mockito.when(this.projectRepository.findById(2)).thenReturn(Optional.empty());

        Project project = this.projectService.findById(2);
        assertNull(project);
    }

    @Test
    void update() {
        ProjectUpdateDTO projectUpdateDTO = new ProjectUpdateDTO();
        projectUpdateDTO.setId(1);

        Mockito.when(this.projectRepository.findById(projectUpdateDTO.getId())).thenReturn(Optional.of(this.project));

        assertTrue(this.projectService.update(projectUpdateDTO));
        Mockito.verify(this.projectRepository, Mockito.times(1)).save(this.project);
    }

    @Test
    void updateWhenProjectNotFound() {
        ProjectUpdateDTO projectUpdateDTO = new ProjectUpdateDTO();
        projectUpdateDTO.setId(2);

        Mockito.when(this.projectRepository.findById(2)).thenReturn(Optional.empty());

        assertFalse(this.projectService.update(projectUpdateDTO));
        Mockito.verify(this.projectRepository, Mockito.never()).save(this.project);
    }

    @Test
    void delete() {
        this.project.setId(1);
        Mockito.when(this.projectRepository.findById(this.project.getId())).thenReturn(Optional.of(this.project));

        assertTrue(this.projectService.delete(this.project.getId()));
        Mockito.verify(this.projectRepository, Mockito.times(1)).delete(this.project);
    }

    @Test
    void deleteWhenProjectNotFound() {
        this.project.setId(1);
        Mockito.when(this.projectRepository.findById(2)).thenReturn(Optional.empty());

        assertFalse(this.projectService.delete(2));
        Mockito.verify(this.projectRepository, Mockito.never()).delete(this.project);
    }

    @Test
    void addResourceAllocation() {
        this.project.setId(1);
        List<Employee> employees = new ArrayList<>(Arrays.asList(new Employee(), new Employee()));
        employees.get(0).setId(1);
        this.project.setEmployees(employees);

        Mockito.when(this.projectRepository.findById(this.project.getId())).thenReturn(Optional.of(this.project));
        Mockito.when(this.employeeRepository.findById(employees.get(0).getId())).thenReturn(Optional.of(employees.get(0)));

        assertTrue(this.projectService.addResourceAllocation(employees.get(0).getId(), this.project.getId()));
    }

    @Test
    void addResourceAllocationWhenProjectNotFound() {
        this.project.setId(1);
        List<Employee> employees = new ArrayList<>(Arrays.asList(new Employee(), new Employee()));
        employees.get(0).setId(1);
        this.project.setEmployees(employees);

        Mockito.when(this.projectRepository.findById(this.project.getId())).thenReturn(Optional.empty());
        Mockito.when(this.employeeRepository.findById(employees.get(0).getId())).thenReturn(Optional.of(employees.get(0)));

        assertFalse(this.projectService.addResourceAllocation(employees.get(0).getId(), this.project.getId()));
    }

    @Test
    void addResourceAllocationWhenEmployeeNotFound() {
        this.project.setId(1);
        List<Employee> employees = new ArrayList<>(Arrays.asList(new Employee(), new Employee()));
        employees.get(0).setId(1);
        this.project.setEmployees(employees);

        Mockito.when(this.projectRepository.findById(this.project.getId())).thenReturn(Optional.of(this.project));
        Mockito.when(this.employeeRepository.findById(employees.get(0).getId())).thenReturn(Optional.empty());

        assertFalse(this.projectService.addResourceAllocation(employees.get(0).getId(), this.project.getId()));
    }

    @Test
    void removeResourceAllocation() {
        this.project.setId(1);
        List<Employee> employees = new ArrayList<>(Arrays.asList(new Employee(), new Employee()));
        employees.get(0).setId(1);
        this.project.setEmployees(employees);

        Mockito.when(this.projectRepository.findById(this.project.getId())).thenReturn(Optional.of(this.project));
        Mockito.when(this.employeeRepository.findById(employees.get(0).getId())).thenReturn(Optional.of(employees.get(0)));

        assertTrue(this.projectService.removeResourceAllocation(employees.get(0).getId(), this.project.getId()));
    }

    @Test
    void removeResourceAllocationWhenProjectNotFound() {
        this.project.setId(1);
        List<Employee> employees = new ArrayList<>(Arrays.asList(new Employee(), new Employee()));
        employees.get(0).setId(1);
        this.project.setEmployees(employees);

        Mockito.when(this.projectRepository.findById(this.project.getId())).thenReturn(Optional.empty());
        Mockito.when(this.employeeRepository.findById(employees.get(0).getId())).thenReturn(Optional.of(employees.get(0)));

        assertFalse(this.projectService.removeResourceAllocation(employees.get(0).getId(), this.project.getId()));
    }

    @Test
    void removeResourceAllocationWhenEmployeeNotFound() {
        this.project.setId(1);
        List<Employee> employees = new ArrayList<>(Arrays.asList(new Employee(), new Employee()));
        employees.get(0).setId(1);
        this.project.setEmployees(employees);

        Mockito.when(this.projectRepository.findById(this.project.getId())).thenReturn(Optional.of(this.project));
        Mockito.when(this.employeeRepository.findById(employees.get(0).getId())).thenReturn(Optional.empty());

        assertFalse(this.projectService.removeResourceAllocation(employees.get(0).getId(), this.project.getId()));
    }
}