package com.spring.orm.service;

import com.opencsv.CSVReader;
import com.spring.orm.entities.Employee;
import com.spring.orm.entities.Project;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeCsvLoaderService {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void loadDataFromCsv() {
        // Map to ensure we don't create duplicate Employee objects
        Map<String, Employee> employeeMap = new HashMap<>();

        try (CSVReader reader = new CSVReader(new InputStreamReader(
                getClass().getClassLoader().getResourceAsStream("data/employees.csv")))) {
            
            String[] line;
            reader.readNext(); // Skip Header Line

            while ((line = reader.readNext()) != null) {
                String empName = line[0];
                String projName = line[1];

                // 1. Check if we already created this employee in this loop
                Employee emp = employeeMap.get(empName);
                if (emp == null) {
                    emp = new Employee();
                    emp.setName(empName);
                    emp.setProjects(new ArrayList<>());
                    employeeMap.put(empName, emp);
                }

                // 2. Create Project and Link (Bi-directional)
                Project p = new Project();
                p.setProjectName(projName);
                p.setEmployee(emp); // Set the foreign key reference
                
                emp.getProjects().add(p); // Add to the employee's list
            }

            // 3. Persist all employees
            // CascadeType.ALL ensures projects are saved automatically
            for (Employee emp : employeeMap.values()) {
                sessionFactory.getCurrentSession().persist(emp);
            }
            
            System.out.println("Import successful! Saved " + employeeMap.size() + " unique employees.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}