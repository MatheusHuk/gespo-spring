package com.bandtec.gespospring.service.Project;

import com.bandtec.gespospring.DTO.update.ProjectUpdateDTO;
import com.bandtec.gespospring.entity.table.Employee;
import com.bandtec.gespospring.entity.table.Project;
import com.bandtec.gespospring.repository.EmployeeRepository;
import com.bandtec.gespospring.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void save(List<Project> projects) {
        projectRepository.saveAll(projects);
    }

    @Override
    public Project findById(Integer id) {
        return projectRepository.findById(id)
                .orElse(null);
    }

    @Override
    public Boolean update(ProjectUpdateDTO project) {
        return projectRepository.findById(project.getId()).map( proj -> {
            proj.setName(project.getName());
            proj.setDsProject(project.getDsProject());
            proj.setManager(project.getManager());
            proj.setCostCenter(project.getCostCenter());

            projectRepository.save(proj);
            return true;
        }).orElse(false);
    }

    @Override
    public Boolean delete(Integer id) {
        return projectRepository.findById(id).map( project -> {
            projectRepository.deleteById(id);
            return true;
        }).orElse(false);
    }

    @Override
    public List<Project> findByEmployee(Integer id) {
        Employee employee = new Employee();
        employee.setId(id);

        return projectRepository.findByEmployees(employee);
    }

    @Override
    public Boolean addResourceAllocation(Integer employeeId, Integer projectId) {
        projectRepository.findById(projectId).map(project -> employeeRepository.findById(employeeId).map(employee -> {
            project.getEmployees().add(employee);
            return true;
        }).orElse(false));
        return false;
    }

    @Override
    public Boolean removeResourceAllocation(Integer employeeId, Integer projectId) {
        return projectRepository.findById(projectId).map(project ->
                employeeRepository.findById(employeeId).map(employee ->
                        project.getEmployees().remove(employee))
                        .orElse(false))
                .orElse(false);
    }
}
