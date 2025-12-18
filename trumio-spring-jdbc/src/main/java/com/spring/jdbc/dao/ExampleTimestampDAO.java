package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.entities.TimestampEntity;
import com.spring.jdbc.entities.Student;

public interface ExampleTimestampDAO {

	public int insert(TimestampEntity et);
	public int change(TimestampEntity et);
	public int delete(TimestampEntity et);
	public Student getSingleStudent(int id);
	public List<Student> getMultipleStudent();

}
