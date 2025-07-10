package com.example.Day6_JavaSpringBootIntern.repository;

import com.example.Day6_JavaSpringBootIntern.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}