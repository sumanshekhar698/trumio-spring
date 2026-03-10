package com.spring.core.async;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync      // Enables @Async
@EnableScheduling // Enables @Scheduled
@ComponentScan("com.spring.core.async")
public class JavaConfig {
    
    // Optional: Define a custom thread pool for Async tasks
    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setThreadNamePrefix("TrumioAsync-");
        executor.initialize();
        return executor;
    }
}