package com.example.updateemployee.service;

import com.example.updateemployee.model.Emp;
import com.example.updateemployee.repo.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpService {

    @Autowired
    private EmpRepo empRepo;

    public Emp createEmp(Emp e) {
        e.setLastUpdated(LocalDateTime.now());
        return empRepo.save(e);
    }

    public List<Emp> getAllEmp() {
        return empRepo.findAll();
    }

    public Emp getOneEmp(Long id) {
        return empRepo.findById(id).orElseThrow(() -> new RuntimeException("Emp not found"));
    }

    public Emp updateEmpById(Long id, Emp newData) {
        Emp e = empRepo.findById(id).orElseThrow(() -> new RuntimeException("Emp not found"));

        if (newData.getEmpName() != null) e.setEmpName(newData.getEmpName());
        if (newData.getEmpRole() != null) e.setEmpRole(newData.getEmpRole());

        e.setLastUpdated(LocalDateTime.now());

        return empRepo.save(e);
    }

    public void deleteEmp(Long id) {
        empRepo.deleteById(id);
    }

    public List<Emp> getEmpByRole(String role) {
        return empRepo.findByEmpRoleIgnoreCase(role);
    }
}
