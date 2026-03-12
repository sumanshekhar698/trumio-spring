package com.spring.jdbc.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import com.spring.jdbc.dao.StudentDAO;
import com.spring.jdbc.dao.StudentDAOImpl;

@Configuration
@PropertySource("classpath:db.properties") // Tell Spring where db.properties the file is
public class JavaConfig {

    // Step 2: Inject values using @Value
    @Value("${db.driver}")
    private String driver;

    @Value("${db.url}")
    private String url;

    @Value("${db.user}")
    private String user;

    @Value("${db.password}")
    private String pass;

    @Bean("ds")
    public DataSource getDataSource() {
        DriverManagerDataSource dso = new DriverManagerDataSource();
        dso.setDriverClassName(driver.trim()); // trim() handles that extra space risk!
        dso.setUrl(url);
        dso.setUsername(user);
        dso.setPassword(pass);
        return dso;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }



    @Bean
    public StudentDAO getStudentDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        StudentDAOImpl studentDAO = new StudentDAOImpl();
        studentDAO.setJdbcTemplate(jdbcTemplate);
        studentDAO.setNamedJdbcTemplate(namedParameterJdbcTemplate);
        return studentDAO;
    }
}