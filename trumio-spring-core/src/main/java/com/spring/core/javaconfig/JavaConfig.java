package com.spring.core.javaconfig;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

/*this class is handling configuration stuff,
 * So we have to inform this a maker to tell
 *  the Spring Container via @ComponentScan
 *  that it's a config file
 *  scanning using
 *  -> @ComponentScan(basePackages = "com.spring.core.javaconfig")
 * */

@Configuration
//No need to use @ComponentScan when using @Bean
//@ComponentScan(basePackages = "com.spring.core.javaconfig")
public class JavaConfig {

    //	using w/o declaring @Component on the class
    @Bean// By Default, the Bean name is getStudent
    public Student getStudent() {
        return new Student();
    }


    @Bean(name = {"student_1", "schoolBuoy"})//
    // through these names we can access the beans
    public Student getStudentWithPlainSamosa(Samosa samosa) { // Spring injects this here
        Student student = new Student(samosa);
        return student;
    }

    @Bean(name = "student_2")
    public Student getStudentWithPaneerSamosa(@Qualifier("paneerSamosa") Samosa samosa) { // Spring injects this here
        Student student = new Student(samosa);
        return student;
    }

    @Primary
    @Bean
    @Profile("dev")
    public Samosa getSamosaPlain() {
        return new Samosa();
    }


    @Primary
    @Bean(name = {"paneerSamosa"})
    public Samosa getSamosaPaneerFlavoured() {
        return new Samosa("Paneer");
    }



    @Bean
    @Profile("prod")
    public Samosa getSamosaChickenFlavoured() {
        return new Samosa("Chicken");
    }

}
