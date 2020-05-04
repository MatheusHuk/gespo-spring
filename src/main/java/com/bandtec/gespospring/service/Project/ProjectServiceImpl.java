package com.bandtec.gespospring.service.Project;

import com.bandtec.gespospring.entity.table.Project;
import com.bandtec.gespospring.entity.view.VwSimpleProject;
import com.bandtec.gespospring.repository.EmployeeRepository;
import com.bandtec.gespospring.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

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
    public Boolean update(Project project) {
        return projectRepository.findById(project.getId()).map( proj -> {
            proj.setName(project.getName());
            proj.setDsProject(project.getDsProject());
            proj.setManager(project.getManager());
            proj.setIsDone(project.getIsDone());
            proj.setCostCenter(project.getCostCenter());
            proj.setEmployees(project.getEmployees());

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
    public Set<VwSimpleProject> findByEmployee(Integer id) {
        return employeeRepository.findById(id).map(employee -> projectRepository.findByEmployees(id))
                .orElse(null);
    }
}
