package com.bandtec.gespospring.controller;

import com.bandtec.gespospring.entity.table.Task;
import com.bandtec.gespospring.service.Task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PutMapping
    public ResponseEntity update(
        @RequestBody Task task
    ) {
        return taskService.update(task) ? ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/project")
    public ResponseEntity findByProject(
            @RequestParam Integer id
    ) {
        List<Task> tasks = taskService.findByProject(id);

        return tasks.isEmpty() ? ResponseEntity.status(HttpStatus.OK).body(tasks) :
                ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
