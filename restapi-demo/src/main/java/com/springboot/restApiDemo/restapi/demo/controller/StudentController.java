package com.springboot.restApiDemo.restapi.demo.controller;

import com.springboot.restApiDemo.restapi.demo.entity.Student;
import com.springboot.restApiDemo.restapi.demo.exceptions.NotFoundException;
import com.springboot.restApiDemo.restapi.demo.model.StudentErrorResponse;
import com.springboot.restApiDemo.restapi.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {
    private StudentRepository studentRepo;

    @Autowired
    public StudentController(StudentRepository repo) {
        this.studentRepo = repo;
    }


    @GetMapping()
    public List<Student> all() {
        return studentRepo.getAll();
    }

    @PostMapping()
    public Student create(@RequestBody Student student) {
        return studentRepo.persist(student);
    }

    @GetMapping("/{id}")
    public Student find(@PathVariable Integer id) {

        return studentRepo.findOrFail(id);
    }

    @PutMapping()
    public Student update(@RequestBody Student student) {
        return studentRepo.update(student);
    }

    @DeleteMapping("/{id}")
    public Student delete(@PathVariable Integer id) {
        return studentRepo.delete(id);
    }


    //add exeption hanlder
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(NotFoundException ex) {
//
//        StudentErrorResponse error = new StudentErrorResponse();
//
//        error.setStatus(HttpStatus.NOT_FOUND.value());
//        error.setMessage(ex.getMessage());
//        error.setTimeStamp(System.currentTimeMillis());
//
//        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//    }

//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(MethodArgumentTypeMismatchException ex) {
//
//
//        StudentErrorResponse error = new StudentErrorResponse();
//
//        error.setStatus(HttpStatus.BAD_REQUEST.value());
//        error.setMessage(ex.getMessage());
//        error.setTimeStamp(System.currentTimeMillis());
//
//        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//
//    }

//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(Exception ex) {
//
//
//        StudentErrorResponse error = new StudentErrorResponse();
//
//        error.setStatus(HttpStatus.BAD_REQUEST.value());
//        error.setMessage(ex.getMessage());
//        error.setTimeStamp(System.currentTimeMillis());
//
//        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//
//    }



}
