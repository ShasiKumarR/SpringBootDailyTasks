package com.example.springbootfirst.controllers;


import com.example.springbootfirst.models.Tasks;
import com.example.springbootfirst.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController

public class TaskControllers {


    @Autowired
    private TaskService taskService;
    @PostMapping("/addtask")

    public void AddTask(@RequestBody Tasks task){
        taskService.addtask(task);
    }

    @GetMapping("/tasks")
    public List<Tasks> findAlltask(){
        return taskService.findall();
    }

    @GetMapping("/taaks/{id}")
    public List<Tasks>findByIdtask(@PathVariable int id){
        return taskService.findallbyid(id);
    }

    @DeleteMapping("task/{id}")
    public void deletetask(@PathVariable int id){
        taskService.deleteById(id);
    }

}
