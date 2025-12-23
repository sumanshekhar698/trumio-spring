package com.spring.orm.dao;

import java.util.List;

import com.spring.orm.entities.Employee;

public interface EmployeeDao {

	public List<Employee> getEmployeesGoodWay();

	public List<Employee> getEmployeesBadWay();

}
