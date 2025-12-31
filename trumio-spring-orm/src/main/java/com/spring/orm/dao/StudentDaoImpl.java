package com.spring.orm.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.spring.orm.entities.Student;

//@Component
@Repository("studentDao")
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private SessionFactory sessionFactory;

	// 1. CREATE (Insert)
	@Transactional
	public int insert(Student student) {
		// 'persist' is the new Hibernate replacement for 'save'
		sessionFactory.getCurrentSession().persist(student);
		return student.getId();
	}

	// 2. READ (Single Student)
	@Transactional(readOnly = true)
	public Student getStudent(int studentId) {
		return sessionFactory.getCurrentSession().get(Student.class, studentId);
	}

	@Transactional(readOnly = true)
	public List<Student> getStudentsByCity(String city) {
		// This is the equivalent of a @Query("from Student where city = :c")
		return sessionFactory.getCurrentSession().createQuery("from Student where city = :c", Student.class)
				.setParameter("c", city).getResultList();
	}

	// 3. READ ALL
	@Transactional(readOnly = true)
	public List<Student> getAllStudents() {
		return sessionFactory.getCurrentSession().createQuery("from Student", Student.class).list();
//        .createSelectionQuery("from Student", Student.class) // New in Hibernate 6
//        .getResultList();
	}

	// 4. UPDATE
	@Transactional
	public void updateStudent(Student student) {
		// 'merge' is the modern way to update detached objects
		sessionFactory.getCurrentSession().merge(student);
	}

	// 5. DELETE
	@Transactional
	public void deleteStudent(int studentId) {
		Session session = sessionFactory.getCurrentSession();
		Student student = session.get(Student.class, studentId);
		if (student != null) {
			session.remove(student); // 'remove' replaces 'delete' in Hibernate 6
		}
	}
	
	
	@Transactional
	public void testDirtyChecking() {
	    Session session = sessionFactory.getCurrentSession();

	    // Fetch student 101: Hibernate takes a Snapshot (Name: "Amit", City: "Delhi")
	    Student student = session.get(Student.class, 101);

	    // Change the city
	    student.setCity("Mumbai"); 

	    // Change it back to the ORIGINAL value
	    student.setCity("Delhi");

	    // Transaction ends here.
	    // Dirty Check: Current("Delhi") == Snapshot("Delhi")? YES.
	    // Result: NO UPDATE SQL is fired at all!
	    
	}
}