package com.bandtec.gespospring.controller;

import com.bandtec.gespospring.DTO.request.TaskUpdateDTO;
import com.bandtec.gespospring.entity.table.Task;
import com.bandtec.gespospring.service.Task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity create(
            @RequestBody List<Task> task
    ) {
        try{
            taskService.save(task);
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
        Task task = taskService.findById(id);

        return task != null ? ResponseEntity.status(HttpStatus.OK).body(task) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping
    public ResponseEntity update(
        @RequestBody @Valid TaskUpdateDTO task
    ) {
        return taskService.update(task) ? ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping
    public ResponseEntity delete(
            @RequestParam Integer id
    ) {
        return taskService.delete(id) ? ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/project")
    public ResponseEntity findByProject(
            @RequestParam Integer id
    ) {
        List<Task> tasks = taskService.findByProject(id);

        return tasks.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.status(HttpStatus.OK).body(tasks);
    }

}
