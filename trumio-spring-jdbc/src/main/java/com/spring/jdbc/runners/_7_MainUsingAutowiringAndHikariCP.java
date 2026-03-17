package com.spring.jdbc.runners;

import com.spring.jdbc.config.JavaAutowiredHikariCPConfig;
import com.spring.jdbc.dao.StudentDAOImpl;
import com.spring.jdbc.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class _7_MainUsingAutowiringAndHikariCP {
    public static void main(String[] args) {
        System.out.println("START of main()");

        ApplicationContext context = new AnnotationConfigApplicationContext(JavaAutowiredHikariCPConfig.class);
        StudentDAOImpl studentDAO = context.getBean("studentDAO", StudentDAOImpl.class);

        List<Student> students = studentDAO.getMultipleStudent();
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println();

        System.out.println(studentDAO.deleteMultipleStudentsUsingJava(List.of(2, 54)));;
        System.out.println();

        System.out.println(studentDAO.getStudentsStreamed());
        System.out.println("END of main()");

    }
}
