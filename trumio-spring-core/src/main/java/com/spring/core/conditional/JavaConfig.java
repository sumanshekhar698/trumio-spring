package com.spring.core.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Conditional;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import java.util.concurrent.Executor;

@Configuration
@ComponentScan("com.spring.core.events")
@EnableAsync 
public class JavaConfig {

    // 1. The Trigger Bean
    @Bean
    public String telephonyService() {
        return "GSM-Module-Active";
    }

    // 2. The Conditional Bean (Only created if telephonyService exists)
    @Bean
    @Conditional(TelephonyCondition.class)
    public SmsListener smsListener() {
        return new SmsListener();
    }

    // 3. The Thread Pool for @Async
    @Bean(name = "taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setThreadNamePrefix("EventThread-");
        executor.initialize();
        return executor;
    }
}