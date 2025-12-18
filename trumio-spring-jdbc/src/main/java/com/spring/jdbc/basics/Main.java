package com.spring.jdbc.basics;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;

import com.spring.jdbc.entities.Student;

public class Main {

	public static void main(String[] args) {
		System.out.println("START <<");
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"beans_config/jdbc_config.xml");
		StudentDAOImpl dao = context.getBean("studentDAO", StudentDAOImpl.class);

		int sId = 1;
//		SELECT
		try {
			Student singleStudent = dao.getSingleStudent(sId);
			System.out.println(singleStudent);

		} catch (EmptyResultDataAccessException e) {
			System.out.println(e);
			System.out.println(sId + " Not present");
		} catch (Exception e) {
			System.out.println(e);
		}

//		SELECT All
		List<Student> multipleStudent = dao.getMultipleStudent();
		for (Student student : multipleStudent) {
			System.out.println(student);
		}

//		DELETE
		int delete = dao.delete(100);
		System.out.println("DELETED ==> " + delete);

//		UPDATE
		int change = dao.change(new Student(1, "Balwinder", "NY"));
		System.out.println("UPDATED ==> " + change);

//		CREATE
		try {
			int created = dao.insert(new Student(100, "Sourabh", "Miami"));
			System.out.println("CREATED ==> " + created);
		} catch (DuplicateKeyException e) {
			System.out.println(e);
			System.out.println(sId + " Not present");
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("END >>");
	}
}
