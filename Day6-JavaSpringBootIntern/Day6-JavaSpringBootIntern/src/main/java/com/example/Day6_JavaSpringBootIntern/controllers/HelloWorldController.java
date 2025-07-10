package com.example.Day6_JavaSpringBootIntern.controllers;


import com.example.Day6_JavaSpringBootIntern.models.Employee;
import com.example.Day6_JavaSpringBootIntern.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class HelloWorldController {

    @Autowired
    private HelloWorldService hws;

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/")
    public String route(){
        return "Welcome to SpringBoot Security";
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/get")
    public List<Employee> getMethod(){

        return hws.getMethod();
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{empID}")
    public Employee getEmployeeById(@PathVariable int empID){

        return hws.getEmployeeById(empID);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public String postMethod(@RequestBody Employee employee){

        return hws.addEmployee(employee);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping
    public String putMethod(@RequestBody Employee employee){

        return hws.updateEmployee(employee);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{empID}")
    public String deleteMethod(@PathVariable int empID){

        return hws.deleteEmployeeById(empID);
    }
}