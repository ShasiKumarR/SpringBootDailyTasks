package com.example.Day4_SpringBootJavaIntern.Services;

import com.example.Day4_SpringBootJavaIntern.Models.todo;
import com.example.Day4_SpringBootJavaIntern.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class todoService {
//    List<Student> st = new ArrayList<>(
//            Arrays.asList(new Student(1, "kamalesh", "JAVA Developer"), new Student(2, "Yugesh", "VLSI"))
//    );

    @Autowired
    StudentRepo sturepo;

    public List<todo> getMethod(){
        return sturepo.findAll();
    }

    public todo getStudentByid(int stu_id){
        return  sturepo.findById(stu_id).orElse(new todo());
    }

    public List<todo> getStudentByDomain(String domain){
        return sturepo.findByDomain(domain);
    }

    public String addStudents(todo stu) {
        sturepo.save(stu);
        return "Student Added Successfully";
    }

    public String updateStudent(todo student) {
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