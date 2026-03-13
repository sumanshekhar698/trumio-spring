package com.spring.jdbc.mappers;

import com.spring.jdbc.entities.StudentVersioned;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentExtractor implements ResultSetExtractor<List<StudentVersioned>> {
    @Override
    public List<StudentVersioned> extractData(ResultSet rs) throws SQLException {
        List<StudentVersioned> students = new ArrayList<>();
        while (rs.next()) {
            StudentVersioned student = new StudentVersioned();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setCity(rs.getString("city"));
            student.setVersion(rs.getInt("version"));
            students.add(student);
        }
        return students;
    }
}