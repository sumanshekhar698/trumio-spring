package com.spring.jdbc.basics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;

public class StudentDAOImpl implements StudentDAO {
	private JdbcTemplate jdbc;

	public JdbcTemplate getJdbc() {
		return jdbc;
	}

	public void setJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	@Override
	public int insert(Student student) {// C
		String query = "INSERT INTO STUDENT(ID,NAME,CITY) VALUES(?,?,?)";// ? = place holder
		int update = this.jdbc.update(query, student.getId(), student.getName(), student.getCity());
		return update;
	}

	@Override
	public Student getSingleStudent(int sId) {// R
		String query = "SELECT * FROM STUDENT WHERE ID=? ";
		Student s1 = this.jdbc.queryForObject(query, new RowMapper<Student>() {

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
		String query = "SELECT * FROM STUDENT";

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

		List<Student> students = this.jdbc.query(query, rm);
		return students;
	}

	@Override
	public int change(Student student) {// U
		String query = "UPDATE STUDENT SET NAME=? , CITY=? WHERE ID=?";
		int update = this.jdbc.update(query, student.getName(), student.getCity(), student.getId());
		return update;
	}

	@Override
	public int delete(int sId) {// D
		String query = "DELETE FROM STUDENT WHERE ID=?";
		int update = this.jdbc.update(query, sId);
		return update;
	}

}
