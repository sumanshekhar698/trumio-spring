package com.spring.jdbc.runners;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.jdbc.config.JavaConfig;
import com.spring.jdbc.dao.StudentDAO;
import com.spring.jdbc.entities.Student;

public class MainUsingJavaConfig {
	public static void main(String[] args) {
		System.out.println("START of main()");

//		via JAVA config
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		StudentDAO studentDAO = context.getBean("getStudentDao", StudentDAO.class);// Gives the ready-made class with all
																				// the dependencies injected
		List<Student> students = studentDAO.getMultipleStudent();
		for (Student student : students) {
			System.out.println(student);
		}

		System.out.println(studentDAO.deleteMultipleStudentsUsingJava(List.of(2, 54)));
		System.out.println("END of main()");

	}
}
