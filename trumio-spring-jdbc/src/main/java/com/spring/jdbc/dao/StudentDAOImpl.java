package com.spring.jdbc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.spring.jdbc.entities.StudentVersioned;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.jdbc.entities.Student;
import com.spring.jdbc.mappers.StudentEntityRowMapper;

@Repository("studentDAO")
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired// This matches the p:namedJdbcTemplate-ref in XML
    private NamedParameterJdbcTemplate namedJdbcTemplate;

    public NamedParameterJdbcTemplate getNamedJdbcTemplate() {
        return namedJdbcTemplate;
    }

    public void setNamedJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate) {
        this.namedJdbcTemplate = namedJdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Student getSingleStudent(int sId) {
        // select single Student data
//		using RowMapperImp1 class
        RowMapper<Student> rowMapper = new StudentEntityRowMapper();
        String query = "SELECT * FROM STUDENT WHERE ID=?";

// Spring will use this internally to map rs to Student
        Student student = this.jdbcTemplate.queryForObject(query,
//                rowMapper);
                (rs, rowNum) -> {//Using Lambda Expression
                    Student student1 = new Student();
                    student1.setId(rs.getInt(1));
                    student1.setName(rs.getString(2));
                    student1.setCity(rs.getString(3));

                    return student1;
                }, sId);// sId and other parameter depends on the number of placeholders in the Query
        return student;

    }

    @Override
    public List<Student> getMultipleStudent() {
        // select multiple Student data
        String query = "SELECT * FROM STUDENT WHERE 1=1";
        RowMapper<Student> rowMapper = new StudentEntityRowMapper();
        List<Student> students = this.jdbcTemplate.query(query, rowMapper);
        return students;
    }

    @Override
    public List<StudentVersioned> getStudentsStreamed() {
        // 1. Tell MySQL to stream one row at a time
        jdbcTemplate.setFetchSize(Integer.MIN_VALUE);

        String sql = "SELECT * FROM STUDENT";
        List<StudentVersioned> studentList = new ArrayList<>();

        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                // Map the current row to a POJO
                StudentVersioned student = new StudentVersioned();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setCity(rs.getString("city"));
                student.setVersion(rs.getInt("version"));

                // Add to the list
                studentList.add(student);
            }
        });

        return studentList;
    }

    @Override
    public int insert(Student student) {
        // insert query
        String query = "INSERT INTO STUDENT(ID,NAME,CITY) VALUES(?,?,?)";
        int rowsInserted = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());

        return rowsInserted;
    }

    @Override
    public int change(Student student) {
        // update data
        String query = "UPDATE STUDENT SET NAME=? , CITY=? WHERE ID=?";
        int rowsUpdated = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
        return rowsUpdated;
    }

    @Override
    public int delete(int sId) {
        // delete data
        String query = "DELETE FROM STUDENT WHERE ID=?";
        int rowsDeleted = this.jdbcTemplate.update(query, sId);
        return rowsDeleted;
    }


    //    NamedJDBCTemplate Use case

    @Override
    public int deleteMultipleStudentsUsingJava(List<Integer> ids) {

        // Guard clause: prevents SQL syntax errors on empty lists
        if (ids == null || ids.isEmpty()) {
            return 0;
        }

        String sql = "DELETE FROM STUDENT WHERE ID IN (:idList)";

        // Using Map.of (Java 9+) is even shorter
//        Map<String, Object> params = Map.of("idList", ids);
        Map<String, Object> params = Collections.singletonMap("idList", ids);

        return namedJdbcTemplate.update(sql, params);
    }

    @Override
    public int deleteMultipleStudentsUsingMapSql(List<Integer> ids) {

        // Guard clause: prevents SQL syntax errors on empty lists
        if (ids == null || ids.isEmpty()) {
            return 0;
        }

        String sql = "DELETE FROM STUDENT WHERE ID IN (:idList)";

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("idList", ids);

        return namedJdbcTemplate.update(sql, parameters);
    }


    @Override
    public int updateBulkStudentCity(String newCity, List<Integer> ids) {
        // 1. Guard Clause: Prevents SQL syntax errors like "IN ()"
        if (ids == null || ids.isEmpty()) {
            System.out.println("No IDs provided. Skipping update.");
            return 0;
        }

        // 2. SQL with Named Parameters
        String sql = "UPDATE STUDENT SET city = :newCity WHERE id IN (:idList)";

        // 3. Fluent API for Parameter Mapping
        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("newCity", newCity, Types.VARCHAR) // Explicitly set as String
                .addValue("idList", ids);                    // Spring expands this automatically

        // 4. Execution
        int rowsAffected = namedJdbcTemplate.update(sql, parameters);

        System.out.println("Successfully updated city to " + newCity + " for " + rowsAffected + " students.");
        return rowsAffected;
    }

    //    Batching
    @Override
    public int[] deleteBatch(List<Integer> ids) {
        String sqlQuery = "DELETE FROM STUDENT WHERE ID = ?";

        int[] result = jdbcTemplate.batchUpdate(sqlQuery, new BatchPreparedStatementSetter() {//Anonymous inner type
            @Override
            public void setValues(@NonNull PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1, ids.get(i));
            }

            @Override//.
            public int getBatchSize() {
                return ids.size();// ingest all ids in one batch
            }
        });
        return result;
    }

    @Override
    public int[] deleteBatchOneShot(List<Integer> ids) {
        String sql = "DELETE FROM STUDENT WHERE ID = :id";

        // Line 1: Convert your simple List into an array of MapSqlParameterSources
        SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(
                ids.stream().map(id -> Map.of("id", id)).toList()
        );

        // Line 2: Execute the batch
        return namedJdbcTemplate.batchUpdate(sql, batch);
    }


    @Transactional
    public void transferStudentData(int fromId, int toId) {
        // AIM: ALL SHOULD PASS OR ALL SHOULD FAIL (ATOMICITY)

        // 1. Update the first student (e.g., changing city as a 'move')
        jdbcTemplate.update("UPDATE student SET city = 'MOVED' WHERE id = ?", fromId);

        // 2. Simulate a Syntax Error or Business Logic Failure
        // This will trigger the BadSqlGrammarException you saw earlier
        jdbcTemplate.update("INSERT INTO suman_table VALUES ('error')");//Exception

        // 3. Update the second student
        jdbcTemplate.update("UPDATE student SET city = 'RECEIVED' WHERE id = ?", toId);
    }

}
