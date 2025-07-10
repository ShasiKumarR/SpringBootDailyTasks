package com.example.Day6_JavaSpringBootIntern.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RegisterDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empID;
    @Column(nullable = false)
    private String empName;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String gender;

    @Column(name = "Date_of_Birth",nullable = false)
    private Date dob;
    @Column(nullable = false)
    private String role;
}