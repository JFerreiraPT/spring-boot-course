package com.springboot.restApiDemo.restapi.demo.controller;

import com.springboot.restApiDemo.restapi.demo.entity.Employee;
import com.springboot.restApiDemo.restapi.demo.entity.Student;
import com.springboot.restApiDemo.restapi.demo.service.EmployeeService;
import com.springboot.restApiDemo.restapi.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeController {
    private EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }


    @GetMapping()
    public List<Employee> all() {
        return service.all();
    }

    @PostMapping()
    public Employee create(@RequestBody Employee employee) {
        return service.create(employee);
    }

//    @GetMapping("/{id}")
//    public Employee find(@PathVariable Integer id) {
//
//        //return service.find(id);
//    }

    @PutMapping()
    public Employee update(@RequestBody Employee employee) {
        return service.update(employee);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
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
