package com.example.updateemployee.controller;

import com.example.updateemployee.model.Emp;
import com.example.updateemployee.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpService empService;

    @PostMapping
    public Emp createEmp(@RequestBody Emp e) {
        return empService.createEmp(e);
    }

    @GetMapping
    public List<Emp> getAll() {
        return empService.getAllEmp();
    }

    @GetMapping("/{id}")
    public Emp getOne(@PathVariable Long id) {
        return empService.getOneEmp(id);
    }

    @PutMapping("/{id}")
    public Emp updateEmp(@PathVariable Long id, @RequestBody Emp e) {
        return empService.updateEmpById(id, e);
    }

    @DeleteMapping("/{id}")
    public void deleteEmp(@PathVariable Long id) {
        empService.deleteEmp(id);
    }

    @GetMapping("/role/{role}")
    public List<Emp> getByRole(@PathVariable String role) {
        return empService.getEmpByRole(role);
    }
}
