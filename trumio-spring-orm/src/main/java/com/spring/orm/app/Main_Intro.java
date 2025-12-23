package com.spring.orm.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

public class Main_Intro {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans_config/orm_config.xml");
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

		// --- DELETE (Example) ---
		studentDao.deleteStudent(101);
		
		// --- CREATE ---
		Student s1 = new Student(101, "Suman Shekhar", "Bangalore");
		studentDao.insert(s1);
		System.out.println("Student saved!");

		// --- READ ---
		Student retrieved = studentDao.getStudent(101);
		System.out.println("Retrieved: " + retrieved);
		
		List<Student> bombayStudents = studentDao.getStudentsByCity("Bombay");
		System.out.println("Bombay Students: " + bombayStudents);

		// --- UPDATE ---
		retrieved.setCity("Mumbai");
		studentDao.updateStudent(retrieved);
		System.out.println("Updated City to Mumbai");

		// --- READ ALL ---
		List<Student> all = studentDao.getAllStudents();
		for (Student s : all) {
			System.out.println(s);
		}
	}
}