package com.springboot.cruddemo.dao;

import com.springboot.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//Supports component scanning, transaltes JDBC exceptions
@Repository
public class StudentDAOImplementation implements StudentDAO {

    private EntityManager em;

    //Inject Entity manager dependency
    @Autowired
    public StudentDAOImplementation(EntityManager em) {
        this.em = em;
    }

    //Transactinal annotations means we are doing a transaction!! Srping Boot does that for us
    @Override
    @Transactional
    public void save(Student student) {
        em.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return em.find(Student.class, id);
    }

    @Override
    public Student findByEmail(String email) {

        return em.createQuery("FROM student s WHERE s.email=:email", Student.class)
                .setParameter("email", email)
                .getSingleResult();
    }

    @Override
    public List<Student> getAll() {
        return em.createQuery("FROM student", Student.class).getResultList();
    }

    @Override
    @Transactional
    public void update(Integer id, String updatedFName) {
        //find user
        Student student = findById(id);

        if(student != null) {
            student.setFirstName(updatedFName);
            em.merge(student);
        }
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student student = findById(id);

        if(student != null) {
            em.remove(student);
        }
    }
}
