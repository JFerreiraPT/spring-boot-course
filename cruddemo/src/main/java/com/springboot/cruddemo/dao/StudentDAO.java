package com.springboot.cruddemo.dao;

import com.springboot.cruddemo.entity.Student;

import java.util.List;

//DAO stands dor Data Access Object
public interface StudentDAO {

    void save(Student student);
    Student findById(Integer id);

    Student findByEmail(String email);

    List<Student> getAll();

    void update(Integer id, String updatedFName);

    void delete(Integer id);
}
