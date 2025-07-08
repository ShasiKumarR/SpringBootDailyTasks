package com.example.todo;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private Map<Integer, Task> taskRepo = new HashMap<>();
    private int currentId = 1;

    @PostMapping("/add")
    public Task addTask(@RequestParam String title) {
        Task task = new Task(currentId, title, "YetToStart");
        taskRepo.put(currentId, task);
        return taskRepo.get(currentId++);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return new ArrayList<>(taskRepo.values());
    }

    @PutMapping("/move/{id}")
    public String moveTask(@PathVariable int id, @RequestParam String status) {
        if (!taskRepo.containsKey(id)) return "Task not found";
        Task task = taskRepo.get(id);
        task.setStatus(status);
        return "Task " + id + " moved to " + status;
    }
}
