package com.spring.orm.entities;

import jakarta.persistence.*;

/*Correct Bidirectional Mapping (Your Case)
Project (Owning side)*/
@Entity
@Table(name = "projects")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String projectName;

	@ManyToOne
	@JoinColumn(name = "emp_id") // emp_id refers to the foreign key column name
	private Employee employee;

	// Getters and Setters
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}