package com.spring.jdbc;

import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mysql.cj.util.StringUtils;
import com.spring.jdbc.dao.StudentDAOImp1;
import com.spring.jdbc.entities.Student;
import com.spring.jdbc.entities.TimestampEntity;

public class Main_BatchUpdateUsingSpringJDBC {
	public static void main(String[] args) {
		System.out.println("START of main()");

//		via XML
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
		JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
		StudentDAOImp1 dao = context.getBean("studentDAO", StudentDAOImp1.class);

		int updated = 0;
		List<Integer> listOfStudnetIds = List.of(6, 10);

//		Pre Cleanup
		int[] deleteBatch = deleteBatch(listOfStudnetIds, template);
		System.out.println(Arrays.toString(deleteBatch));
		
		dao.deleteMultipleStudentsUsingJava(listOfStudnetIds);
		dao.deleteMultipleStudentsUsingMapSql(listOfStudnetIds);
		
		
		String query0 = "INSERT INTO STUDENT(ID,NAME,CITY) VALUES(?,?,?)";
		updated = template.update(query0, 3, "Shalini", "Bombay");// fire query
		System.out.println("ROWS UPDATED Q1: " + updated);
		


//		INSERT Query_1
		String query1 = "INSERT INTO STUDENT(ID,NAME,CITY) VALUES(?,?,?)";
		updated = template.update(query1, 06, "Vijay", "Kolkata");// fire query
		System.out.println("ROWS UPDATED Q1: " + updated);

		updated = dao.insert(new Student(10, "Talwinder", "Punjab"));
		System.out.println("ROWS UPDATED Q1.1: " + updated);

//		INSERT Query_2 for TimeStamp Table
		String query2 = "INSERT INTO example_timestamp (DATA,CUR_TIMESTAMP) VALUES(?,?)";
		TimestampEntity et = new TimestampEntity();
		et.setData("TimeStamp Testing");
		System.out.println("CHECK => " + StringUtils.isEmptyOrWhitespaceOnly(et.getData()));
		et.setCur_timestamp(new Timestamp(System.currentTimeMillis()));
		updated = template.update(query2, et.getData(), et.getCur_timestamp());
		System.out.println("ROWS UPDATED Q2: " + updated);

//		INSERT Query 3
		String query3 = "INSERT INTO example_timestamp (DATA,CUR_TIMESTAMP) VALUES(?,CURRENT_TIMESTAMP(5))";
		updated = template.update(query3, et.getData());
		System.out.println("ROWS UPDATED Q3: " + updated);

//		updated = template.update(query3, et.getData(), et.getCur_timestamp());// only 1 place holder in query3
//		System.out.println("ROWS UPDATED Q3.1: " + updated);

//		Using HashMap to store the place-holders parameter
		final Map<Integer, Object> params = new HashMap<Integer, Object>();
		params.put(1, "the current time is");
//		params.put(3, et.getCur_timestamp());// only 1 place holder in query3

//		for (Integer key : params.keySet()) {
//			System.out.println(key + " " + params.get(key));
//			ps.setObject(index, params.get(index));
//		}

		updated = template.update(query3, (PreparedStatement ps) -> {
			for (Integer index : params.keySet()) {
				ps.setObject(index, params.get(index));
			}
		});
		System.out.println("ROWS UPDATED Q4: " + updated);
		System.out.println("END of main()");
	}

	public static int[] deleteBatch(List<Integer> ids, JdbcTemplate jdbcTemplate) {
		String sqlQuery = "DELETE FROM STUDENT WHERE ID = ?";

		return jdbcTemplate.batchUpdate(sqlQuery, new BatchPreparedStatementSetter() {
			@Override
			public void setValues(java.sql.PreparedStatement ps, int i) throws java.sql.SQLException {
				ps.setInt(1, ids.get(i));
			}

			@Override// 1.
			public int getBatchSize() {
				return ids.size();
			}
		});
	}
}
