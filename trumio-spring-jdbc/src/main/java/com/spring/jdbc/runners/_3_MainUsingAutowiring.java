package com.spring.jdbc.runners;

import java.util.List;

import com.spring.jdbc.dao.StudentDAOImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.jdbc.config.JavaAutowiredConfig;
import com.spring.jdbc.entities.Student;

public class _3_MainUsingAutowiring {
    public static void main(String[] args) {
        System.out.println("START of main()");

//		Via JAVA config Autowiring
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaAutowiredConfig.class);
        StudentDAOImpl studentDAO = context.getBean("studentDAO", StudentDAOImpl.class);

        List<Student> students = studentDAO.getMultipleStudent();
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println(studentDAO.deleteMultipleStudentsUsingJava(List.of(2, 54)));;
        System.out.println("END of main()");

    }
}
