package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDAO;
import com.spring.jdbc.entities.Student;

public class AppDAOImp1 {
	public static void main(String[] args) {
		System.out.println("START of main()");

//		via XML
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
		JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);

		StudentDAO studentDAO = context.getBean("studentDAO", StudentDAO.class);

//		INSERT using DAO
//		****************************************************************
		Student student = new Student();
		student.setId(66);
		student.setName("Ritika");
//		student.setCity("Imphal");
		
		int rowsInserted = studentDAO.insert(student);
		System.out.println("RECORDS INSERTED : " + rowsInserted);

//		UPDATE using DAO
//		****************************************************************
//		Student student = new Student();
//		student.setId(05);// ID of old person
//		student.setName("Ritika");// But data is new
//		student.setCity("Delhi");
//		int rowsUpdated = studentDAO.change(student);
//		System.out.println("RECORD UPDATED -> " + rowsUpdated);

//		DELETE using DAO
//		****************************************************************
//		int rowsDeleted = studentDAO.delete(9);// No exception if id not found
//		System.out.println("RECORD DELETED -> " + rowsDeleted);

//		QUERY for Single Object
//		****************************************************************

//		Student singleStudent = studentDAO.getSingleStudent(1);
//		System.out.println(singleStudent);
//		singleStudent = studentDAO.getSingleStudent(2);
//		System.out.println(singleStudent);
//		singleStudent = studentDAO.getSingleStudent(9);// It will throw Exception if data is not present
//		System.out.println(singleStudent);
		/*
		 * Exception in thread "main"
		 * org.springframework.dao.EmptyResultDataAccessException: Incorrect result
		 * size: expected 1, actual 0 at
		 * org.springframework.dao.support.DataAccessUtils.nullableSingleResult(
		 * DataAccessUtils.java:97) at
		 * org.springframework.jdbc.core.JdbcTemplate.queryForObject(JdbcTemplate.java:
		 * 887) at
		 * com.spring.jdbc.dao.StudentDAOImp1.getSingleStudent(StudentDAOImp1.java:63)
		 * at com.spring.jdbc.AppDAOImp1.main(AppDAOImp1.java:52)
		 */
		
		
//		QUERY for Multiple Object
//		****************************************************************
//		List<Student> students = studentDAO.getMultipleStudent();
//		for (Student student1 : students) {
//			System.out.println(student1);
//		}
//			System.out.println("END of main()");


	}
}
