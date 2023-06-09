package com.springboot.restApiDemo.restapi.demo.controller;

import com.springboot.restApiDemo.restapi.demo.entity.Student;
import com.springboot.restApiDemo.restapi.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {
    private StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }


    @GetMapping()
    public List<Student> all() {
        return service.all();
    }

    @PostMapping()
    public Student create(@RequestBody Student student) {
        return service.create(student);
    }

    @GetMapping("/{id}")
    public Student find(@PathVariable Integer id) {

        return service.find(id);
    }

    @PutMapping()
    public Student update(@RequestBody Student student) {
        return service.update(student);
    }

    @DeleteMapping("/{id}")
    public Student delete(@PathVariable Integer id) {
        return service.delete(id);
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
