package com.spring.orm.service;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentConcurrencyService {

	@Autowired
	private StudentDao studentDao;

	public void simulateStaleStudentUpdate() {
		System.out.println("--- Starting Student Optimistic Locking Test ---");

		int studentId = 111;
		// PRE-CONDITION: Ensure Student 101 exists in DB
		studentDao.deleteStudent(studentId);
		studentDao.insert(new Student(studentId, "Original Student", "Delhi"));

		// 1. User A fetches the student (Version is 0)
		Student studentUserA = studentDao.getStudent(studentId);//2
		System.out.println("User A loaded: " + studentUserA.getName() + " | Version: " + studentUserA.getVersion());

		// 2. User B fetches the SAME student (Version is 0)
		Student studentUserB = studentDao.getStudent(studentId);//2
		System.out.println("User B loaded: " + studentUserB.getName() + " | Version: " + studentUserB.getVersion());

		// 3. User A updates the name and saves
		studentUserA.setName("Name Updated by User A");
		studentDao.updateStudent(studentUserA);//Version will increase 3
		System.out.println("User A saved successfully. DB Version is now 1.");

		// 4. User B tries to update the name using their OLD version (0)
		try {
			System.out.println("User B attempting to save with stale Version 0...");
			studentUserB.setName("Name Updated by User B");
			studentDao.updateStudent(studentUserB);
		} catch (Exception e) {
			System.out.println("\n[ERROR] StaleObjectStateException caught!");
			System.out.println("Message: " + e.getMessage());
			System.out.println("Result: User B's changes were REJECTED because the data changed in the background.");
		}
	}

}