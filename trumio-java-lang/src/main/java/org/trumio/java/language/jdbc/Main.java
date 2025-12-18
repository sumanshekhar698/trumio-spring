package org.trumio.java.language.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		// SQL Query to execute
		String query = "SELECT customerName, city, country FROM customers LIMIT 10";

		// 1. & 2. Establish Connection and Create Statement using Try-With-Resources
		try (Connection conn = DBUtils.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query)) {

			System.out.println("Connected to MySQL 8.0.44 successfully!\n");
			System.out.printf("%-30s | %-15s | %-10s%n", "Customer Name", "City", "Country");
			System.out.println("------------------------------------------------------------------");

			// 3. Process the Result Set
//			R1
//			R2
//			R3
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
