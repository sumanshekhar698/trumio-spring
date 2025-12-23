package com.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDAO;

public class Main_Transactional {

	public static void main(String[] args) {
		System.out.println("START of main()");

//		via XML
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("beans_config/transaction_config.xml");
		StudentDAO dao = context.getBean("studentDAO", StudentDAO.class);

		dao.transferStudentData(99, 66);
		System.out.println("END of main()");
	}
}
