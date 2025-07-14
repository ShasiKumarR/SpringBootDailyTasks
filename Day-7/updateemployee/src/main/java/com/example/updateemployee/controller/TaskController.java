package com.example.updateemployee.controller;

import com.example.updateemployee.model.Task;
import com.example.updateemployee.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/emp/{empId}")
    public Task addTask(@PathVariable Long empId, @RequestBody Task task) {
        return taskService.addTaskToEmp(empId, task);
    }

    @GetMapping("/emp/{empId}")
    public List<Task> getTasksForEmp(@PathVariable Long empId) {
        return taskService.getTasksByEmpId(empId);
    }

    @PutMapping("/{taskId}")
    public Task updateTask(@PathVariable Long taskId, @RequestBody Task task) {
        return taskService.updateTask(taskId, task);
    }

    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
    }
}
