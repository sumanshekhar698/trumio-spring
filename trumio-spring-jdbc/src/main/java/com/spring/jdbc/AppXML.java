package com.spring.jdbc;

import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mysql.cj.util.StringUtils;
import com.spring.jdbc.dao.StudentDAOImp1;
import com.spring.jdbc.entities.Student;
import com.spring.jdbc.entities.TimestampEntity;

public class AppXML {
	public static void main(String[] args) {
		System.out.println("START of main()");

//		via XML
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
		JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
		StudentDAOImp1 si = context.getBean("studentDAO", StudentDAOImp1.class);

		int updated = 0;
//		INSERT Query 1
		String query1 = "INSERT INTO STUDENT(ID,NAME,CITY) VALUES(?,?,?)";
		updated = template.update(query1, 06, "Vijay", "Kolkata");// fire query
		System.out.println("ROWS UPDATED Q1: " + updated);

		updated = si.insert(new Student(10, "Balwinder", "Punjab"));
		System.out.println("ROWS UPDATED Q1.1: " + updated);

//		INSERT Query 2 
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
//				System.out.println(index + " " + params.get(index));
				ps.setObject(index, params.get(index));
			}
		});
		System.out.println("ROWS UPDATED Q4: " + updated);
		System.out.println("END of main()");
	}
}
