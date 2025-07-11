package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee updateEmployee(Long id, Employee newData) {
        Optional<Employee> empOpt = repository.findById(id);
        if (empOpt.isPresent()) {
            Employee emp = empOpt.get();
            emp.setName(newData.getName());
            emp.setRole(newData.getRole());
            emp.setTodo(newData.getTodo());
            return repository.save(emp);
        } else {
            throw new RuntimeException("Employee not found");
        }
    }

    public List<Employee> getByRole(String role) {
        return repository.findByRole(role);
    }

    public String getTodo(Long id) {
        return repository.findById(id)
                .map(emp -> "TODO for " + emp.getName() + ": " + emp.getTodo())
                .orElse("Employee not found");
    }
}