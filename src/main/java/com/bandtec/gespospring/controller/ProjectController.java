package com.bandtec.gespospring.controller;

import com.bandtec.gespospring.entity.table.Project;
import com.bandtec.gespospring.entity.view.VwSimpleProject;
import com.bandtec.gespospring.service.Project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public ResponseEntity create(
            @RequestBody List<Project> projects
    ) {
        projectService.save(projects);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity read(
            @RequestParam Integer id
    ) {
        Project project = projectService.findById(id);
        return project != null ? ResponseEntity.status(HttpStatus.OK).body(project) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping
    public ResponseEntity update(
           @RequestBody Project project
    ) {
        return projectService.update(project) ? ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping
    public ResponseEntity delete(
            @RequestParam Integer id
    ) {
        return projectService.delete(id) ? ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/employee")
    public ResponseEntity findByEmployee(
            @RequestParam Integer id
    ) {
        Set<VwSimpleProject> projects = projectService.findByEmployee(id);

        return !projects.isEmpty() ? ResponseEntity.status(HttpStatus.OK).body(projects) :
                ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
