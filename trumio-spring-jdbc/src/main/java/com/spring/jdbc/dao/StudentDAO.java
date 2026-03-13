package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.entities.Student;
import com.spring.jdbc.entities.StudentVersioned;

public interface StudentDAO {

    public int insert(Student student);

    public Student getSingleStudent(int sId);

    public List<Student> getMultipleStudent();

    List<StudentVersioned> getStudentsStreamed();

    public int change(Student student);

    int updateBulkStudentCity(String newCity, List<Integer> ids);

    public void transferStudentData(int fromId, int toId);

    public int delete(int sId);

    int deleteMultipleStudentsUsingMapSql(List<Integer> ids);

    int deleteMultipleStudentsUsingJava(List<Integer> ids);

    int[] deleteBatch(List<Integer> ids);

    int[] deleteBatchOneShot(List<Integer> ids);


}
