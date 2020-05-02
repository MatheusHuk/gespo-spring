package com.bandtec.gespospring.controller;

import com.bandtec.gespospring.entity.WorkSchedule;
import com.bandtec.gespospring.service.WorkScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/work-schedules")
public class WorkScheduleController {

    @Autowired
    private WorkScheduleService workScheduleService;

    @PostMapping
    public ResponseEntity create(
            @RequestBody List<WorkSchedule> workSchedules
    ) {
        workScheduleService.save(workSchedules);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity read(
            @RequestParam Integer id
    ) {
        WorkSchedule workSchedule = workScheduleService.findById(id);

        return workSchedule != null ? ResponseEntity.status(HttpStatus.OK).body(workSchedule) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping ResponseEntity update(
            @RequestBody WorkSchedule workSchedule
    ) {
        return workScheduleService.update(workSchedule) ? ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping ResponseEntity delete(
            @RequestParam Integer id
    ) {
        return workScheduleService.delete(id) ? ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/employee")
    public ResponseEntity readByEmployee(
            @RequestParam Integer id
    ) {
        List<WorkSchedule> workSchedulesByEmployee = workScheduleService.findByEmployee(id);

        return !workSchedulesByEmployee.isEmpty() ? ResponseEntity.status(HttpStatus.OK).body(workSchedulesByEmployee) :
                ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
