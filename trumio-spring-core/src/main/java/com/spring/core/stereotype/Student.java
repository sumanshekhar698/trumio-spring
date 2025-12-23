package com.spring.core.stereotype;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("s1") // Don't use student, use s1
@Scope("singleton")
//@Scope("prototype")
public class Student {
	@Value("Suman Shekhar")
	private String studentName;
	@Value("Bangalore")
	private String city;
	@Value("#{course}") // Field Injection :: Reflection
	private List<String> courses;

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", city=" + city + ", courses=" + courses + "]";
	}

	public String getCity() {
		return city;
	}

	public List<String> getCourses() {
		return courses;
	}

//	@Value("#{course}") // Spring now calls this method to inject the value
//	public void setCourses(List<String> courses) {
//	    System.out.println("Setting courses via Setter Injection!");
//	    this.courses = courses;
//	}

	public void setCity(String city) {
		this.city = city;
	}

}
