package com.bandtec.gespospring.service.Task;

import com.bandtec.gespospring.entity.table.Task;
import com.bandtec.gespospring.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void save(List<Task> tasks) {
        taskRepository.saveAll(tasks);
    }

    @Override
    public Task findById(Integer id) {
        return null;
    }

    @Override
    public Boolean update(Task task) {
        return null;
    }

    @Override
    public Boolean delete(Integer id) {
        return null;
    }

    @Override
    public List<Task> findByProject(Integer projectId) {
        return taskRepository.findByProject_Id(projectId);
    }
}
