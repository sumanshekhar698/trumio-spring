package com.spring.orm.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.entities.Student;
import com.spring.orm.service.StudentConcurrencyService;
import com.spring.orm.service.StudentLifecycleService;

public class Main_LifecycleApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans_config/orm_config.xml");
		StudentLifecycleService service = context.getBean(StudentLifecycleService.class);



//		// Step 1: Create and Persist (Moves to Detached at the end)
//		Student student = service.demonstrateStudentLifecycle();
//		// Step 2: ReAttach and Update
//		service.reattachStudent(student);
//		System.out.println("Final State: " + student);
		
//		Simulate Stale Object
		StudentConcurrencyService service2 = context.getBean(StudentConcurrencyService.class);
		service2.simulateStaleStudentUpdate();
		
	}
}