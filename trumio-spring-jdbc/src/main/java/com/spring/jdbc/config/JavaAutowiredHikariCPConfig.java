package com.spring.jdbc.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.spring.jdbc.dao")
@PropertySource("classpath:db.properties") // Tell Spring where db.properties the file is
public class JavaAutowiredHikariCPConfig {

    // Step 2: Inject values using @Value
    @Value("${db.driver}")
    private String driver;

    @Value("${db.url}")
    private String url;

    @Value("${db.user}")
    private String user;

    @Value("${db.password}")
    private String pass;

    @Bean(destroyMethod = "close") // Ensures the pool shuts down gracefully
    public HikariDataSource dataSource() {
//    public DataSource dataSource() {//The DataSource interface does not have a close method
        HikariConfig config = new HikariConfig();

        // ==> Basic Database Settings
        config.setDriverClassName(driver);
        config.setJdbcUrl(url);
        config.setUsername(user);
        config.setPassword(pass);

        // --- SENIOR TUNING ---
        // 1. Pool Size: Balanced for a standard app
        config.setMaximumPoolSize(10);
        // 2. minimumIdle: Minimum number of idle connections Hikari maintains
        config.setMinimumIdle(5);
        // 3. Timeout: Don't let threads wait forever (5 seconds)
        config.setConnectionTimeout(5000);
        // 4. idleTimeout: How long a connection can sit idle before being retired (10 mins)
        config.setIdleTimeout(600000);
        // 5. maxLifetime: IMPORTANT. Total life of a connection.
        // Should be 30-60 seconds shorter than your DB's connection limit.
        config.setMaxLifetime(1800000); // 30 minutes
        // 6. Leak Detection: Log an error if a connection is held > 2 seconds
        // This helps you find code where you forgot to close a transaction.
        config.setLeakDetectionThreshold(2000);


        // ==> MySQL Performance "Secret Sauce"
        // These tell the driver to cache SQL metadata and prepared statements
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        config.addDataSourceProperty("useServerPrepStmts", "true"); // Server-side speed

        // ==> Connection Health Check
        // A simple query to run when a connection is "kept alive"
        config.setConnectionTestQuery("SELECT 1");

        return new HikariDataSource(config);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource ds) {
        // This is the "big brother" of JdbcTemplate used for :namedParams
        return new NamedParameterJdbcTemplate(ds);
    }
}