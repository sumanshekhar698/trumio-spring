package com.spring.jdbc.dao;

import java.util.List;
import com.spring.jdbc.entities.Student;

public interface StudentDAO {

	public int insert(Student student);

	public int change(Student student);

	public int delete(int sId);

	public Student getSingleStudent(int sId);

	public List<Student> getMultipleStudent();

}
