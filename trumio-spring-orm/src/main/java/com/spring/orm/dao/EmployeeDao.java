package com.spring.orm.dao;

import com.spring.orm.entities.Employee;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class EmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * TRIGGERING THE N+1 PROBLEM
     * This query only selects Employees. 
     * When you loop through them later, Hibernate fires N extra queries for projects.
     */
    @Transactional(readOnly = true)
    public List<Employee> getEmployeesBadWay() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Employee", Employee.class)
                .getResultList();
    }

    /**
     * FIXING THE N+1 PROBLEM
     * The 'JOIN FETCH' keyword tells Hibernate to grab Projects 
     * in the SAME query as Employees using a SQL JOIN.
     */
    @Transactional(readOnly = true)
    public List<Employee> getEmployeesGoodWay() {
        return sessionFactory.getCurrentSession()
                .createQuery("select e from Employee e join fetch e.projects", Employee.class)
                .getResultList();
    }
}