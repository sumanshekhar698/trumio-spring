package com.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.jdbc.entities.Student;
import com.spring.jdbc.mapper.RowMapperImp1;

@Repository("studentDAO")
public class StudentDAOImp1 implements StudentDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// This matches the p:namedJdbcTemplate-ref in XML
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

//	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insert(Student student) {
		// insert query
		String query = "INSERT INTO STUDENT(ID,NAME,CITY) VALUES(?,?,?)";
		int rowsInserted = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());

		return rowsInserted;
	}

	public int change(Student student) {
		// update data
		String query = "UPDATE STUDENT SET NAME=? , CITY=? WHERE ID=?";
		int rowsUpdated = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
		return rowsUpdated;
	}

	public int delete(int sId) {
		// delete data
		String query = "DELETE FROM STUDENT WHERE ID=?";
		int rowsDeleted = this.jdbcTemplate.update(query, sId);
		return rowsDeleted;
	}

	public int deleteMultipleStudentsUsingMapSql(List<Integer> ids) {
		String sql = "DELETE FROM STUDENT WHERE ID IN (:idList)";

		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("idList", ids);

		return namedJdbcTemplate.update(sql, parameters);
	}

	public int deleteMultipleStudentsUsingJava(List<Integer> ids) {
		String sql = "DELETE FROM STUDENT WHERE ID IN (:idList)";

		// Using Map.of (Java 9+) is even shorter
		Map<String, Object> params = Collections.singletonMap("idList", ids);

		return namedJdbcTemplate.update(sql, params);
	}

	public Student getSingleStudent(int sId) {
		// select single Student data
//		using RowMapperImp1 class
		RowMapper<Student> rowMapper = new RowMapperImp1();
		String query = "SELECT * FROM STUDENT WHERE ID=?";

//		using anonymous inner class
		Student student = this.jdbcTemplate.queryForObject(query, new RowMapper<Student>() {
			// <Object> by default if we don't specify <Student>
			// this will be used by JAVA internally
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Student student = new Student();
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setCity(rs.getString(3));

				return student;
			}
		}, sId);// sID and other parameter depends on the number of placeholder in the Query
		return student;

	}

	public List<Student> getMultipleStudent() {
		// TODO Auto-generated method stub
		// select multiple Student data
		String query = "SELECT * FROM STUDENT WHERE 1=1";
		RowMapper<Student> rowMapper = new RowMapperImp1();

//		using anonymous inner class
		List<Student> students = this.jdbcTemplate.query(query, rowMapper);
		return students;
	}

	@Transactional
	public void transferStudentData(int fromId, int toId) {
		// 1. Update the first student (e.g., changing city as a 'move')
		jdbcTemplate.update("UPDATE student SET city = 'MOVED' WHERE id = ?", fromId);

		// 2. Simulate a Syntax Error or Business Logic Failure
		// This will trigger the BadSqlGrammarException you saw earlier
		jdbcTemplate.update("INSERT INTO non_existent_table VALUES ('error')");//Exception

		// 3. Update the second student
		jdbcTemplate.update("UPDATE student SET city = 'RECEIVED' WHERE id = ?", toId);
	}

}
