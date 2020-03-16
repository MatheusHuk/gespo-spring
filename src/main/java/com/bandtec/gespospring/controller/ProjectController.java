package com.bandtec.gespospring.controller;

import com.bandtec.gespospring.model.Project;
import com.bandtec.gespospring.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @PostMapping("/cadastro")
    public Project create(
            @RequestBody Project project
    ){
        return projectRepository.save(project);
    }

}
