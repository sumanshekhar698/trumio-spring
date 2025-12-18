package org.trumio.java.language.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class MySqlApp {

    // Connection details - Update 'classicmodels' to your actual DB name
    private static final String URL = "jdbc:mysql://localhost:3306/classicmodels?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "your_pwd"; // Replace with your actual password

    public static void main(String[] args) {
        // SQL Query to execute
        String query = "SELECT customerName, city, country FROM customers LIMIT 10";

        // 1. & 2. Establish Connection and Create Statement using Try-With-Resources
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("Connected to MySQL 8.0.44 successfully!\n");
            System.out.printf("%-30s | %-15s | %-10s%n", "Customer Name", "City", "Country");
            System.out.println("------------------------------------------------------------------");

            // 3. Process the Result Set
            while (rs.next()) {
                String name = rs.getString("customerName");
                String city = rs.getString("city");
                String country = rs.getString("country");
                
                System.out.printf("%-30s | %-15s | %-10s%n", name, city, country);
            }

        } catch (SQLException e) {
            System.err.println("Database error occurred!");
            e.printStackTrace();
        }
    }
}