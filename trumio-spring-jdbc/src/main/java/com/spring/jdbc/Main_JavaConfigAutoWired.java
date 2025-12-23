package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.jdbc.config.JavaAutowiredConfig;
import com.spring.jdbc.dao.StudentDAO;
import com.spring.jdbc.entities.Student;

public class Main_JavaConfigAutoWired {
	public static void main(String[] args) {
		System.out.println("START of main()");

//		Via JAVA config Autowiring
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaAutowiredConfig.class);
		StudentDAO studentDAO = context.getBean("studentDAO", StudentDAO.class);

		List<Student> students = studentDAO.getMultipleStudent();
		for (Student student : students) {
			System.out.println(student);
		}

		System.out.println("END of main()");

	}
}
