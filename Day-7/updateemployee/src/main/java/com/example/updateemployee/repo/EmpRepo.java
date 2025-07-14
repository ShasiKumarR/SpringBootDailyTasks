package com.example.updateemployee.repo;

import com.example.updateemployee.model.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmpRepo extends JpaRepository<Emp, Long> {
    List<Emp> findByEmpRoleIgnoreCase(String empRole);
}
