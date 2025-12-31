package com.spring.orm.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.dao.WorkerDao;

public class Main_DirtyCheck {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans_config/orm_config.xml");
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

		studentDao.testDirtyChecking();

	}
}