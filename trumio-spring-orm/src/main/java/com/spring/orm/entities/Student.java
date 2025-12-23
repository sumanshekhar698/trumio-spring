package com.spring.orm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student") // Table name change
public class Student {


	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment in MySQL
	@Column(name = "id")
	private int id;

	@Column(name = "name", nullable = false, length = 100)
	private String name;

	@Column(name = "city", length = 200)
	private String city;

	// --- Constructors ---

	// Always keep a no-args constructor for Hibernate
	public Student() {
	}

	// Constructor without ID (if ID is auto-generated)
//	public Student(String name, String city) {
//		this.name = name;
//		this.city = city;
//	}

	public Student(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}

	// --- Getters and Setters ---
	// (Keep these as you have them, or use Lombok @Data)

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", city=" + city + "]";
	}

}
