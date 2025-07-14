package com.example.updateemployee.service;

import com.example.updateemployee.model.Emp;
import com.example.updateemployee.model.Task;
import com.example.updateemployee.repo.EmpRepo;
import com.example.updateemployee.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepo taskRepo;

    @Autowired
    private EmpRepo empRepo;

    public Task addTaskToEmp(Long empId, Task task) {
        Emp emp = empRepo.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        task.setEmp(emp);
        task.setCreatedAt(LocalDateTime.now());

        return taskRepo.save(task);
    }

    public List<Task> getTasksByEmpId(Long empId) {
        return taskRepo.findByEmpEmpId(empId);
    }

    public Task updateTask(Long taskId, Task updated) {
        Task t = taskRepo.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));

        if (updated.getTaskTitle() != null) t.setTaskTitle(updated.getTaskTitle());
        if (updated.getTaskDescription() != null) t.setTaskDescription(updated.getTaskDescription());
        if (updated.getTaskStatus() != null) t.setTaskStatus(updated.getTaskStatus());

        return taskRepo.save(t);
    }

    public void deleteTask(Long taskId) {
        taskRepo.deleteById(taskId);
    }
}
