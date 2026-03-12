package com.spring.jdbc.runners;

import java.util.Arrays;
import java.util.List;

import com.spring.jdbc.dao.StudentDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class MainBatching {
    public static void main(String[] args) {
        System.out.println("START of main()");

//		via XML
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext("beans_config/transaction_config.xml");
        JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
        StudentDAO studentDaoBean = context.getBean("studentDAO", StudentDAO.class);

        int updated = 0;
        List<Integer> listOfStudentIds = List.of(112, 10);


        int[] deleteBatch = studentDaoBean.deleteBatch(listOfStudentIds);
        System.out.println(Arrays.toString(deleteBatch));

        int res1 = studentDaoBean.deleteMultipleStudentsUsingJava(listOfStudentIds);
        System.out.println(res1);

//        int res2 = studentDaoBean.deleteMultipleStudentsUsingMapSql(List.of());//EDGE CASE
        int res2 = studentDaoBean.deleteMultipleStudentsUsingMapSql(listOfStudentIds);
        System.out.println(res2);


    }


}
