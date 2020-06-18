package com.bandtec.gespospring.service.Task;

import com.bandtec.gespospring.DTO.request.TaskUpdateDTO;
import com.bandtec.gespospring.entity.table.Task;

import java.util.List;

public interface TaskService {
    void save(List<Task> tasks);
    Task findById(Integer id);
    Boolean update(TaskUpdateDTO task);
    Boolean delete(Integer id);
    List<Task> findByProject(Integer projectId);
}
