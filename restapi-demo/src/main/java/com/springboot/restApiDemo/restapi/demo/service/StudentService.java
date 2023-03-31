package com.springboot.restApiDemo.restapi.demo.service;

import com.springboot.restApiDemo.restapi.demo.entity.Student;
import com.springboot.restApiDemo.restapi.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service()
public class StudentService {
    private StudentRepository studentRepo;

    @Autowired
    public StudentService(StudentRepository repo) {
        this.studentRepo = repo;
    }


    public List<Student> all() {
        return studentRepo.getAll();
    }

    @Transactional
    public Student create(Student student) {
        return studentRepo.persist(student);
    }


    public Student find(Integer id) {

        return studentRepo.findOrFail(id);
    }
    @Transactional

    public Student update(Student student) {
        return studentRepo.update(student);
    }

    @Transactional
    public Student delete(Integer id) {
        return studentRepo.delete(id);
    }

}
