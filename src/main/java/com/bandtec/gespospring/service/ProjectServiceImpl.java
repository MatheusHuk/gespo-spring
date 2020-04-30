package com.bandtec.gespospring.service;

import com.bandtec.gespospring.entity.Project;
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
            proj.setCustCenter(project.getCustCenter());
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

}
