package com.bandtec.gespospring.controller;

import com.bandtec.gespospring.entity.table.WorkSchedule;
import com.bandtec.gespospring.model.WorkScheduleModel;
import com.bandtec.gespospring.service.WorkSchedule.WorkScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
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
            @RequestParam Integer employeeId
    ) {
        List<WorkScheduleModel> workSchedulesByEmployee = workScheduleService.findByEmployee(employeeId);

        return workSchedulesByEmployee.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.status(HttpStatus.OK).body(workSchedulesByEmployee);

    }

    @GetMapping("/filter")
    public ResponseEntity readByFilter(
            @RequestParam(required = false) Integer projectId,
            @RequestParam(required = false) Integer employeeId,
            @RequestParam(required = false) String date
    ) {
        if(projectId == null && employeeId == null && date == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        WorkSchedule workSchedule = new WorkSchedule(projectId, employeeId, date);
        List<WorkScheduleModel> workScheduleModels = workScheduleService.findByFilter(workSchedule);

        return workScheduleModels.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.status(HttpStatus.OK).body(workScheduleModels);

    }
}
