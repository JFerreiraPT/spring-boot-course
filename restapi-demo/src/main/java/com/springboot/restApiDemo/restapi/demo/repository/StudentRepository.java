package com.springboot.restApiDemo.restapi.demo.repository;


import com.springboot.restApiDemo.restapi.demo.entity.Student;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository extends BaseRepository<Student> {

    public StudentRepository() {
        super(Student.class);
    }
}
