package com.example.Day6_JavaSpringBootIntern.services;

import com.example.Day6_JavaSpringBootIntern.models.RegisterDetails;
import com.example.Day6_JavaSpringBootIntern.repository.RegisterDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthService {

    @Autowired
    RegisterDetailRepository registerDetailRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public String addNewEmployee(RegisterDetails register) {
        RegisterDetails registerDetails = new RegisterDetails();
        registerDetails.setEmpID(register.getEmpID());
        registerDetails.setEmpName(register.getEmpName());
        registerDetails.setEmail(register.getEmail());
        registerDetails.setGender(register.getGender());

        registerDetails.setPassword(passwordEncoder.encode(register.getPassword()));

        registerDetails.setRole(register.getRole());
        registerDetails.setDob(register.getDob());

        registerDetailRepository.save(registerDetails);

        return "Employee Added Successfully";
    }

    public String authenticate(RegisterDetails login) {
        RegisterDetails user = registerDetailRepository.findByEmail(login.getEmail());
        if(user != null){
            if(passwordEncoder.matches(login.getPassword(), user.getPassword())){
                return "Login Successfully";
            }
            else{
                return "Password Incorrect";
            }
        }
        return "Login Not Successfully";
    }
}