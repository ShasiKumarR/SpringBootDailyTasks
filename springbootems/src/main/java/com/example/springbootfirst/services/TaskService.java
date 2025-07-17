package com.example.springbootfirst.services;


import com.example.springbootfirst.models.Tasks;
import com.example.springbootfirst.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepo  taskRepo;

    public void addtask(Tasks task) {
        taskRepo.save(task);
    }

    public List<Tasks> findall() {
        return taskRepo.findAll();
    }

    public Optional<Tasks>findallbyid(int id)
    {
        return taskRepo.findById(id);
    }

    public void deleteById(int id) {
        
        taskRepo.deleteById(id);
    }
}
