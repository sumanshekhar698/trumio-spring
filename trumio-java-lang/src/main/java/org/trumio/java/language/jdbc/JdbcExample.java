package org.trumio.java.language.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcExample {

    public static void main(String[] args) {
        JdbcExample example = new JdbcExample();

        // 1. Static Query (No params)
        System.out.println("--- TASK 1: FETCHING ALL OFFICES ---");
        example.showAllOffices();

        System.out.println("\n");

        // 2. Parameterized Query (PreparedStatement)
        System.out.println("--- TASK 2: SEARCHING EMPLOYEES BY TITLE ---");
        example.findEmployeesByJobTitle("Sales Rep");
    }

    /**
     * Example of a simple Statement.
     * Use this ONLY for static queries where no user input is involved.
     */
    public void showAllOffices() {
        String sql = "SELECT city, phone, country FROM offices";

        try (Connection conn = DBUtils.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.printf("%-15s | %-20s | %-10s%n", "CITY", "PHONE", "COUNTRY");
            System.out.println("------------------------------------------------------------");

            while (rs.next()) {
                System.out.printf("%-15s | %-20s | %-10s%n", 
                    rs.getString("city"), 
                    rs.getString("phone"), 
                    rs.getString("country"));
            }
        } catch (SQLException e) {
            System.err.println("Error executing static statement: " + e.getMessage());
        }
    }

    /**
     * Example of a PreparedStatement.
     * This is the standard way to handle variables and prevent SQL Injection.
     */
    public void findEmployeesByJobTitle(String title) {
        // The '?' acts as a secure placeholder
        String sql = "SELECT firstName, lastName, extension FROM employees WHERE jobTitle = ?";

        try (Connection conn = DBUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Bind the parameter safely. 
            // The driver handles escaping characters like ' or ;
            pstmt.setString(1, title); 

            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.println("Results for Job Title: " + title);
                System.out.printf("%-15s | %-15s | %-10s%n", "FIRST NAME", "LAST NAME", "EXT");
                System.out.println("------------------------------------------------------------");

                boolean found = false;
                while (rs.next()) {
                    found = true;
                    System.out.printf("%-15s | %-15s | %-10s%n", 
                        rs.getString("firstName"), 
                        rs.getString("lastName"), 
                        rs.getString("extension"));
                }
                
                if (!found) {
                    System.out.println("No employees found with that title.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error executing prepared statement: " + e.getMessage());
        }
    }
}