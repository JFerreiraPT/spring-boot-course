package com.springboot.restApiDemo.restapi.demo.controller;

import com.springboot.restApiDemo.restapi.demo.entity.Student;
import com.springboot.restApiDemo.restapi.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {
    private StudentRepository studentRepo;

    @Autowired
    public StudentController(StudentRepository repo) {
        this.studentRepo = repo;
    }


    @GetMapping("/")
    public List<Student> all() {
        return studentRepo.getAll();
    }






}
