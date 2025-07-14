package com.example.updateemployee.repo;

import com.example.updateemployee.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepo extends JpaRepository<Task, Long> {
    List<Task> findByEmpEmpId(Long empId);
}
