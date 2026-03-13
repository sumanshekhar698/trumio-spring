package com.spring.jdbc.runners;

import java.util.List;

import com.spring.jdbc.entities.StudentVersioned;
import com.spring.jdbc.intro.StudentSimpleDAOImpl;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;

import com.spring.jdbc.entities.Student;

public class MainIntro {

    public static void main(String[] args) {
        System.out.println("START <<");
        AbstractApplicationContext context = new ClassPathXmlApplicationContext(
                "beans_config/jdbc_config.xml");
        StudentSimpleDAOImpl dao = context.getBean("studentDAO", StudentSimpleDAOImpl.class);

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
        System.out.println();


//		SELECT All LIMITED
        System.out.println();
        List<Student> multipleStudent = dao.getMultipleStudent();
        for (Student student : multipleStudent) {
            System.out.println(student);
        }
        System.out.println();

//		SELECT All STUDENTS
        System.out.println(dao.getAllStudents());
        System.out.println();

//		SELECT AS A MAP
        System.out.println(dao.getAllStudentsAsMap());
        System.out.println();

//		DELETE
        int delete = dao.delete(101);
        System.out.println("DELETED ==> " + delete);
        System.out.println();

//		UPDATE
        int change = dao.update(new Student(1, "Balwinder", "LA"));
        System.out.println("UPDATED ==> " + change);
        System.out.println();

//		CREATE
        try {
            int created = dao.insertVersioned(new StudentVersioned(100, "Sourabh", "Miami", 0));
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
