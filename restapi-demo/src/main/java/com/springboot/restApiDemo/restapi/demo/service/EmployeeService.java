package com.springboot.restApiDemo.restapi.demo.service;

import com.springboot.restApiDemo.restapi.demo.entity.Employee;
import com.springboot.restApiDemo.restapi.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service()
public class EmployeeService {
    private EmployeeRepository employeetRepo;

    @Autowired
    public EmployeeService(EmployeeRepository repo) {
        this.employeetRepo = repo;
    }


    public List<Employee> all() {
        return employeetRepo.findAll();
    }

    @Transactional
    public Employee create(Employee employee) {
        return employeetRepo.save(employee);
    }


//    public Employee find(Integer id) {
//
//        return employeetRepo.findById(id);
//    }
    @Transactional

    public Employee update(Employee employee) {
        return employeetRepo.save(employee);
    }

    @Transactional
    public void delete(Integer id) {
        employeetRepo.deleteById(id);
    }

}
