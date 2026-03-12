package com.spring.jdbc.dao;

import java.util.List;
import com.spring.jdbc.entities.Student;

public interface StudentDAO {

	public int insert(Student student);

	public int change(Student student);

	public int delete(int sId);

	int deleteMultipleStudentsUsingMapSql(List<Integer> ids);

	int deleteMultipleStudentsUsingJava(List<Integer> ids);


	int updateBulkStudentCity(String newCity, List<Integer> ids);

	int[] deleteBatch(List<Integer> ids);

	public Student getSingleStudent(int sId);

	public List<Student> getMultipleStudent();

	int[] deleteBatchOneShot(List<Integer> ids);

	public void transferStudentData(int fromId, int toId);

}
