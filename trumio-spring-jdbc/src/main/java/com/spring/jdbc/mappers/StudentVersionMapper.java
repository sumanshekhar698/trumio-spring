package com.spring.jdbc.mappers;

import com.spring.jdbc.entities.StudentVersioned;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentVersionMapper implements RowMapper<StudentVersioned> {
    @Override
    public StudentVersioned mapRow(ResultSet rs, int rowNum) throws SQLException {
        StudentVersioned student = new StudentVersioned();
        student.setId(rs.getInt("id"));
        student.setName(rs.getString("name"));
        student.setCity(rs.getString("city"));
        student.setVersion(rs.getInt("version"));
        return student;
    }
}