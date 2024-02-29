package com.riya.Springsecex.controller;


import com.riya.Springsecex.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    List<Student> students = new ArrayList<>(List.of(
            new Student(1, "Riya", 23),
            new Student(2, "Aniket", 25)
    ));

    @GetMapping("students")
    public List<Student> getAllStudents(){
        return students;
    }

    @GetMapping("csrf-token")
    public CsrfToken getcsrf(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }


    @PostMapping("students")
    public void addStudent(@RequestBody Student student){
        students.add(student);
    }
}
