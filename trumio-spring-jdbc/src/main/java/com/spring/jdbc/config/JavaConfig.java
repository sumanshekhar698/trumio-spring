package com.spring.jdbc.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import com.spring.jdbc.dao.StudentDAO;
import com.spring.jdbc.dao.StudentDAOImp1;

@Configuration
@PropertySource("classpath:db.properties") // Step 1: Tell Spring where the file is
public class JavaConfig {

	// Step 2: Inject values using @Value
	@Value("${db.driver}")
	private String driver;

	@Value("${db.url}")
	private String url;

	@Value("${db.username}")
	private String user;

	@Value("${db.password}")
	private String pass;

	@Bean("ds")
	public DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(driver.trim()); // trim() handles that extra space risk!
		ds.setUrl(url);
		ds.setUsername(user);
		ds.setPassword(pass);
		return ds;
	}

	@Bean("jdbcTemplate")
	public JdbcTemplate getTemplate() {
		// Pass the data source bean directly
		return new JdbcTemplate(getDataSource());
	}

	@Bean("studentDAO")
	public StudentDAO getStudentDao() {
		StudentDAOImp1 studentDAO = new StudentDAOImp1();
		studentDAO.setJdbcTemplate(getTemplate());
		return studentDAO;
	}
}