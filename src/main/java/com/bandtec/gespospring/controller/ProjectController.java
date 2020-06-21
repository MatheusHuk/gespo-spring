package com.bandtec.gespospring.controller;

import com.bandtec.gespospring.DTO.request.ProjectDTO;
import com.bandtec.gespospring.DTO.request.ProjectUpdateDTO;
import com.bandtec.gespospring.entity.table.Project;
import com.bandtec.gespospring.service.Project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public ResponseEntity create(
            @RequestBody @Valid ProjectDTO projects
    ) {
        try {
            projectService.save(projects);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
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
           @RequestBody @Valid ProjectUpdateDTO project
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
        List<Project> projects = projectService.findByEmployee(id);

        return !projects.isEmpty() ? ResponseEntity.status(HttpStatus.OK).body(projects) :
                ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/delete-allocation")
    public ResponseEntity removeResourceAllocation(
            @RequestParam Integer employeeId,
            @RequestParam Integer projectId
    ) {
        return projectService.removeResourceAllocation(employeeId, projectId) ?
                ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/add-allocation")
    public ResponseEntity addResourceAllocation(
            @RequestParam Integer employeeId,
            @RequestParam Integer projectId
    ){
        return projectService.addResourceAllocation(employeeId, projectId) ?
                ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
