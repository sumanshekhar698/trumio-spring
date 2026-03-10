package com.spring.jdbc.runners;

import java.util.List;

import com.spring.jdbc.dao.StudentDAOImp1;
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
        StudentDAOImp1 studentDAO = context.getBean("studentDAO", StudentDAOImp1.class);

        List<Student> students = studentDAO.getMultipleStudent();
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println(studentDAO.getNamedJdbcTemplate());
        System.out.println("END of main()");

    }
}
