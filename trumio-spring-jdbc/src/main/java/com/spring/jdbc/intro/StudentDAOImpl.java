package com.spring.jdbc.intro;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.spring.jdbc.entities.StudentVersioned;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;

public class StudentDAOImpl implements StudentDAO {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Student getSingleStudent(int sId) {// R
        String query = "SELECT * FROM STUDENT WHERE ID=? ";
        Student s1 = this.jdbcTemplate.queryForObject(query,
                new RowMapper<Student>() {

                    @Override
                    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Student s = new Student();
                        s.setId(rs.getInt(1));
                        s.setName(rs.getString(2));
                        s.setCity(rs.getString(3));
                        return s;
                    }

                }, sId);

        return s1;
    }

    @Override
    public List<Student> getMultipleStudent() {// R
        String query = "SELECT * FROM STUDENT LIMIT 5";

        RowMapper<Student> rm = new RowMapper<Student>() {

            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student s = new Student();
                s.setId(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setCity(rs.getString(3));
                return s;
            }
        };

        List<Student> students = this.jdbcTemplate.query(query, rm);
        return students;
    }


    //If your database column names (id, name, city, version) match your Java field names exactly,
    // Spring can do the mapping for you automatically.
    @Override
    public List<StudentVersioned> getAllStudents() {
        String sql = "SELECT * FROM STUDENT";

        // Spring maps columns to setters automatically
        // This requires a default no-args constructor in your POJO (e.g., public StudentVersioned() {}).
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(StudentVersioned.class));
    }

    @Override
    public int change(Student student) {// U
        String query = "UPDATE STUDENT SET NAME=? , CITY=? WHERE ID=?";
        int update = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
        return update;
    }

    @Override
    public int delete(int sId) {// D
        String query = "DELETE FROM STUDENT WHERE ID=?";
        int update = this.jdbcTemplate.update(query, sId);
        return update;
    }

    @Override
    public int insert(Student student) {// C
        String query = "INSERT INTO STUDENT(ID,NAME,CITY) VALUES(?,?,?)";// ? = place holder
        int update = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
        return update;
    }


    @Override
    public int insertVersioned(StudentVersioned student) {// C
        String query = "INSERT INTO STUDENT(ID,NAME,CITY,VERSION) VALUES(?,?,?,?)";// ? = place holder
        int update = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity(), student.getVersion());
        return update;
    }

}
