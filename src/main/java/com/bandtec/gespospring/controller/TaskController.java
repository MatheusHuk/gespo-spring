package com.bandtec.gespospring.controller;

import com.bandtec.gespospring.entity.table.Task;
import com.bandtec.gespospring.service.Task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/project")
    public ResponseEntity findByProject(
            @RequestParam Integer id
    ) {
        List<Task> tasks = taskService.findByProject(id);

        return tasks.isEmpty() ? ResponseEntity.status(HttpStatus.OK).body(tasks) :
                ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
