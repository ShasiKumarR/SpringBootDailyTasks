package com.example.Day4_SpringBootJavaIntern.Controller;

import com.example.Day4_SpringBootJavaIntern.Models.Student;
import com.example.Day4_SpringBootJavaIntern.Services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentServices hws;

    @GetMapping("/get")
    public List<Student> getMethod() {
        return hws.getMethod();
    }

    @GetMapping("/{stu_id}")
    public Student getStudentByid(@PathVariable int stu_id) {
        return hws.getStudentByid(stu_id);
    }

    @GetMapping("/job/{domain}")
    public List<Student> getStudentBYdomain(@PathVariable String domain){
        return hws.getStudentByDomain(domain);
    }

    @PostMapping("/add")
    public String postmethod(@RequestBody Student student){
        return hws.addStudents(student);
    }

    @PutMapping("/update")
    public String putmethod(@RequestBody Student student){
        return hws.updateStudent(student);
    }

    @DeleteMapping("/{stu_id}")
    public String deletemethod(@PathVariable int stu_id){
        return hws.deleteStudentByid(stu_id);
    }

    @DeleteMapping("/del")
    public String deleteAll(){
        return hws.deleteAll();
    }


}