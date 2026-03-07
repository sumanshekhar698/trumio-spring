package com.spring.core.resources;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.spring.core.resources")
public class ResourceConfig {
    // No extra beans needed! 
    // The ApplicationContext automatically provides the ResourceLoader.
}