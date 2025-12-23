package com.spring.orm.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.orm.entities.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * TRIGGERING THE N+1 PROBLEM This query only selects Employees. When you loop
	 * through them later, Hibernate fires N extra queries for projects.
	 */
	@Transactional(readOnly = true)
	public List<Employee> getEmployeesBadWay() {
		List<Employee> employees = sessionFactory.getCurrentSession().createQuery("from Employee", Employee.class)
				.getResultList();

//		for (Employee e : employees) {
//			System.out.println(e.getProjects().size());
//		}

//	    employees.get(0).getProjects().size(); // triggers Only batch load

		employees.forEach(e -> // BEST
		Hibernate.initialize(e.getProjects()));

		return employees;
	}

	/**
	 * FIXING THE N+1 PROBLEM The 'JOIN FETCH' keyword tells Hibernate to grab
	 * Projects in the SAME query as Employees using a SQL JOIN.
	 */
	@Transactional(readOnly = true)
	public List<Employee> getEmployeesGoodWay() {
		return sessionFactory.getCurrentSession()
				.createQuery("select e from Employee e join fetch e.projects", Employee.class).getResultList();// HQL /
																												// JPQL
																												// (Object-centric)

		/*
		 * SELECT e.id, e.name, p.id, p.project_name FROM employees e JOIN projects p ON
		 * p.emp_id = e.id;
		 */

	}
}