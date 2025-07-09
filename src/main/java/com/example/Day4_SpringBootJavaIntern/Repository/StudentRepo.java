package com.example.Day4_SpringBootJavaIntern.Repository;

import com.example.Day4_SpringBootJavaIntern.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {

    List<Student> findByDomain(String domain);
}