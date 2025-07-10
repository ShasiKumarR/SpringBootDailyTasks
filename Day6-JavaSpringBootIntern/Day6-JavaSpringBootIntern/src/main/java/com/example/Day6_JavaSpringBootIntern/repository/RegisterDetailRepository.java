package com.example.Day6_JavaSpringBootIntern.repository;

import com.example.Day6_JavaSpringBootIntern.models.RegisterDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegisterDetailRepository extends JpaRepository<RegisterDetails,Integer> {

    RegisterDetails findByEmail(String email);
}