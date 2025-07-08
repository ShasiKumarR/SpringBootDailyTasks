package com.example.Day4_SpringBootJavaIntern.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stu_id;
    private String firstname;
    private String domain;



}