package com.spring.core.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*this class is handling configuration stuff
 * So we have to inform this a maker to tell
 *  the Spring Container via @ComponentScan
 *  that its a config file
 *  scanning using 
 *  -> @ComponentScan(basePackages = "com.spring.core.javaconfig")
 * */

@Configuration
//No need to use @ComponentScan when using @Bean
@ComponentScan(basePackages = "com.spring.core.javaconfig")
public class JavaConfig {

//	using w/o declaring @Component on the class
	@Bean
//	@Bean(name = {"stud","student","schoolBuoy"})
//	through these names we can access the beans
	public Student getStudent() {
		return new Student();

	}

	@Bean
	public Samosa getSamosa() {
		return new Samosa();

	}

}
