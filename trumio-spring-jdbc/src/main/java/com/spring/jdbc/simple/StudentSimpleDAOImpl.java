package com.spring.jdbc.simple;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.jdbc.entities.StudentVersioned;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;

import com.spring.jdbc.entities.Student;

public class StudentSimpleDAOImpl implements StudentSimpleDAO {
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


// ... inside your StudentDAOImpl class ...

    @Override
    public Map<Integer, StudentVersioned> getAllStudentsAsMap() {
        String query = "SELECT * FROM STUDENT";

        // ResultSetExtractor gives us the WHOLE result set to iterate ourselves
        return this.jdbcTemplate.query(query,
                new ResultSetExtractor<Map<Integer, StudentVersioned>>() {

                    @Override
                    public Map<Integer, StudentVersioned> extractData(ResultSet rs) throws SQLException, DataAccessException {
                        Map<Integer, StudentVersioned> studentMap = new HashMap<>();

                        // We manage the loop manually here
                        while (rs.next()) {
                            StudentVersioned s = new StudentVersioned();
                            s.setId(rs.getInt("ID"));
                            s.setName(rs.getString("NAME"));
                            s.setCity(rs.getString("CITY"));
                            s.setVersion(rs.getInt("VERSION"));

                            // Logic: Mapping by ID for quick lookup in the service layer
                            studentMap.put(s.getId(), s);
                        }
                        return studentMap;
                    }
                });

    }

    @Override
    public int update(Student student) {// U
        String query = "UPDATE STUDENT SET NAME=? , CITY=? WHERE ID=?";
//        int update = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
//        return update;

        // Using ArgPreparedStatementSetter to tweak guessing
        return jdbcTemplate.update(query,
                new Object[]{student.getName(), student.getCity(), student.getId()},
                new int[]{java.sql.Types.VARCHAR, java.sql.Types.VARCHAR, java.sql.Types.INTEGER}
        );

    }

    @Override
    public int updateWithVersion(StudentVersioned student) {
        String query = "UPDATE STUDENT SET NAME=?, CITY=?, VERSION = VERSION + 1 " +
                "WHERE ID=? AND VERSION=?";

        int updatedRows = this.jdbcTemplate.update(query,
                student.getName(),
                student.getCity(),
                student.getId(),
                student.getVersion());

        if (updatedRows == 0) {
            throw new RuntimeException("Update failed: Data was modified by another user (Optimistic Lock Failure)");
        }
        return updatedRows;
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
    public int insertTypeSafe(Student student) {
//        String query = "INSERT INTO STUDENT(ID, NAME, CITY) VALUES(?, ?, ?)";

        // If student.getCity() is null, the DB will insert 'Unknown' instead
        String query = "INSERT INTO STUDENT(ID, NAME, CITY) VALUES(?, ?, COALESCE(?, 'Unknown'))";

        // Explicitly defining types for each parameter
        int update = this.jdbcTemplate.update(
                query,
                new SqlParameterValue(Types.INTEGER, student.getId()),
                // If name is null, Spring sends it as a NULL VARCHAR
                new SqlParameterValue(Types.VARCHAR, student.getName()),
                new SqlParameterValue(Types.VARCHAR, student.getCity())
        );

        return update;
    }

    @Override
    public int insertVersioned(StudentVersioned student) {// C
        String query = "INSERT INTO STUDENT(ID,NAME,CITY,VERSION) VALUES(?,?,?,?)";// ? = place holder
        int update = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity(), student.getVersion());
        return update;
    }

}
