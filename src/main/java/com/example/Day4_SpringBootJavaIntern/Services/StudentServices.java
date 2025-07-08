package com.example.Day4_SpringBootJavaIntern.Services;

import com.example.Day4_SpringBootJavaIntern.Models.Student;
import com.example.Day4_SpringBootJavaIntern.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServices {
//    List<Student> st = new ArrayList<>(
//            Arrays.asList(new Student(1, "kamalesh", "JAVA Developer"), new Student(2, "Yugesh", "VLSI"))
//    );

    @Autowired
    StudentRepo sturepo;

    public List<Student> getMethod(){
        return sturepo.findAll();
    }

    public Student getStudentByid(int stu_id){
        return  sturepo.findById(stu_id).orElse(new Student());
    }

    public List<Student> getStudentByDomain(String domain){
        return sturepo.findByDomain(domain);
    }

    public String addStudents(Student stu) {
        sturepo.save(stu);
        return "Student Added Successfully";
    }

    public String updateStudent(Student student) {
        sturepo.save(student);
        return "Student Updated Successfully";
    }

    public String deleteStudentByid(int stu_id){
        sturepo.deleteById(stu_id);
        return "Student Deleted Successfully";
    }

    public String deleteAll(){
        sturepo.deleteAll();
        return "All Records Deleted Successfully";
    }

}