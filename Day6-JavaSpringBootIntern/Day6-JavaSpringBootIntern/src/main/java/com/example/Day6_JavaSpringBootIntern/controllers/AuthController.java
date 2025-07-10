package com.example.Day6_JavaSpringBootIntern.controllers;

import com.example.Day6_JavaSpringBootIntern.models.RegisterDetails;
import com.example.Day6_JavaSpringBootIntern.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public String addNewuser(@RequestBody RegisterDetails register){

        return authService.addNewEmployee(register);
    }

    @PostMapping("/login")
    public String login(@RequestBody RegisterDetails login){

        return authService.authenticate(login);
    }

}