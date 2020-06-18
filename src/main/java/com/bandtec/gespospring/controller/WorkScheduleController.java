package com.bandtec.gespospring.controller;

import com.bandtec.gespospring.DTO.request.WorkScheduleUpdateDTO;
import com.bandtec.gespospring.entity.table.WorkSchedule;
import com.bandtec.gespospring.service.WorkSchedule.WorkScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        try {
            workScheduleService.save(workSchedules);
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
        WorkSchedule workSchedule = workScheduleService.findById(id);

        return workSchedule != null ? ResponseEntity.status(HttpStatus.OK).body(workSchedule) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping ResponseEntity update(
            @RequestBody @Valid WorkScheduleUpdateDTO workSchedule
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
        List<WorkSchedule> workSchedulesByEmployee = workScheduleService.findByEmployee(employeeId);

        return workSchedulesByEmployee.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.status(HttpStatus.OK).body(workSchedulesByEmployee);
    }

    @GetMapping("/filter")
    public ResponseEntity readByFilter(
            @RequestParam Integer projectId,
            @RequestParam(required = false) Integer employeeId,
            @RequestParam(required = false) String date
    ) {
        WorkSchedule workSchedule = new WorkSchedule(projectId, employeeId, date);
        List<WorkSchedule> workScheduleList = workScheduleService.findByFilter(workSchedule);

        return workScheduleList.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.status(HttpStatus.OK).body(workScheduleList);
    }
}
