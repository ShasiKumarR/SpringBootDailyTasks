package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public Employee save(@RequestBody Employee emp) {
        return service.saveEmployee(emp);
    }

    @GetMapping
    public List<Employee> getAll() {
        return service.getAllEmployees();
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee newData) {
        return service.updateEmployee(id, newData);
    }

    @GetMapping("/role/{role}")
    public List<Employee> getByRole(@PathVariable String role) {
        return service.getByRole(role);
    }

    @GetMapping("/todo/{id}")
    public String getTodo(@PathVariable Long id) {
        return service.getTodo(id);
    }
}