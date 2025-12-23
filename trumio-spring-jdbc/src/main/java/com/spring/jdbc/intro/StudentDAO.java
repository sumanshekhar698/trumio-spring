package com.spring.jdbc.intro;

import java.util.List;

import com.spring.jdbc.entities.Student;

//CRUD operation
public interface StudentDAO {//DAO = Data Access Object

	public int insert(Student student);// C

	public Student getSingleStudent(int sId);// R

	public List<Student> getMultipleStudent();// R

	public int change(Student student);// U

	public int delete(int sId);// D

}
