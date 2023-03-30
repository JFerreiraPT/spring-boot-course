package com.springboot.cruddemo;

import com.springboot.cruddemo.dao.StudentDAO;
import com.springboot.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	//From spring Boot Framework
	//The  below code is executes after Spring Ebans have been loaded
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);
			//printStudent(studentDAO, 1);
			//printAllStudents(studentDAO);
			//getByEmail(studentDAO, "jpr@mail.pt");
			//updateFirstName(studentDAO ,1, "João PR");
			delete(studentDAO, 2);
		};
	}

	private void delete(StudentDAO studentDAO, Integer i) {
		studentDAO.delete(i);
	}

	private void updateFirstName(StudentDAO studentDAO, int i, String firstName) {
		studentDAO.update(i, firstName);
	}

	private void getByEmail(StudentDAO studentDAO, String mail) {
		System.out.println(studentDAO.findByEmail(mail));
	}


	private void printAllStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.getAll();

		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void printStudent(StudentDAO studentDAO, int i) {
		System.out.println(studentDAO.findById(i));
	}


	private void createStudent(StudentDAO studentDAO) {
		studentDAO.save(new Student("João", "Ferreira", "jpr@mail.pt"));
	}


}
