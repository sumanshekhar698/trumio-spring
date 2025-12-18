package com.spring.jdbc.basics;

import java.util.List;

import com.spring.jdbc.entities.Student;

//CRUD operation
public interface StudentDAO {

	public int insert(Student student);// C

	public Student getSingleStudent(int sId);// R

	public List<Student> getMultipleStudent();// R

	public int change(Student student);// U

	public int delete(int sId);// D

}
