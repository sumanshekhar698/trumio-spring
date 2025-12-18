package com.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entities.Student;

@Component("studentDAO")
public class StudentDAOImp1 implements StudentDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

//	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		System.out.println("setter used");
	}

	public int insert(Student student) {
		// insert query
		// TODO Auto-generated method stub
		String query = "INSERT INTO STUDENT(ID,NAME,CITY) VALUES(?,?,?)";
		int rowsInserted = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());

		return rowsInserted;
	}

	public int change(Student student) {
		// update data
		// TODO Auto-generated method stub
		String query = "UPDATE STUDENT SET NAME=? , CITY=? WHERE ID=?";
		int rowsUpdated = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
		return rowsUpdated;
	}

	public int delete(int sId) {
		// delete data
		// TODO Auto-generated method stub
		String query = "DELETE FROM STUDENT WHERE ID=?";
		int rowsDeleted = this.jdbcTemplate.update(query, sId);
		return rowsDeleted;
	}

	public Student getSingleStudent(int sId) {
		// select single Student data
		// TODO Auto-generated method stub
//		using RowMapperImp1 class
//		RowMapper<Student> rowMapper = new RowMapperImp1();
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

}
