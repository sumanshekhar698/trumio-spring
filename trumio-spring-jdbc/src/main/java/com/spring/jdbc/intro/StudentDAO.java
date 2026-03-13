package com.spring.jdbc.intro;

import java.util.List;
import java.util.Map;

import com.spring.jdbc.entities.Student;
import com.spring.jdbc.entities.StudentVersioned;

//CRUD operation
public interface StudentDAO {//DAO = Data Access Object

    public int insert(Student student);// C

    int insertTypeSafe(Student student);// C

    int insertVersioned(StudentVersioned student);// C

    public Student getSingleStudent(int sId);// R

    public List<Student> getMultipleStudent();// R

    List<StudentVersioned> getAllStudents();// R

    Map<Integer, StudentVersioned> getAllStudentsAsMap();// R

    public int update(Student student);// U

    int updateWithVersion(StudentVersioned student);// U

    public int delete(int sId);// D


}
