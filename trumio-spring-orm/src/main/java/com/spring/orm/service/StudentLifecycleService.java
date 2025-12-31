package com.spring.orm.service;

import com.spring.orm.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentLifecycleService {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public Student demonstrateStudentLifecycle() {
        Session session = sessionFactory.getCurrentSession();

        // 1. TRANSIENT STATE
        // Object exists in Java memory but Hibernate doesn't know about it.
        Student student = new Student(102, "Rahul", "Mumbai");
        System.out.println("1. Student is Transient. In DB? No.");

        // 2. PERSISTENT STATE
        // Calling persist() adds the object to the First-Level Cache.
        session.persist(student);
        System.out.println("2. Student is now Persistent. Hibernate is tracking it.");

        // DIRTY CHECKING
        // We change a property. No SQL UPDATE is sent yet! 
        // Hibernate simply marks this object as "dirty" in the cache.
        student.setCity("Pune");//Making it Dirty

        // L1 FIRST-LEVEL CACHE (Session Cache)
        // If we fetch the same ID again, Hibernate gives us the SAME instance from memory.
        Student sameStudent = session.get(Student.class, 102);
        System.out.println("3. Are instances identical? " + (student == sameStudent)); // true

        // 4. THE FLUSH
        // Synchronization: Hibernate sends the SQL to the DB.
        session.flush(); 
        System.out.println("4. Flush executed. SQL INSERT/UPDATE sent to DB.");

        return student; 
        // Transaction ends here. The Session closes.
        // The student object is now DETACHED.
    }

    @Transactional
    public void reattachStudent(Student detachedStudent) {
        Session session = sessionFactory.getCurrentSession();

        System.out.println("5. Student is currently Detached. Changing city...");
        detachedStudent.setCity("Bangalore");

        // 6. MERGE (Reattaching)
        // Hibernate loads the latest record from DB and merges the changes.
        Student persistentStudent = (Student) session.merge(detachedStudent);
        System.out.println("6. Student reattached and updated via merge.");
    }
}