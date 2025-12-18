package org.trumio.java.language.jdbc;

import java.sql.*;

public class JdbcOfficeDML {

    public static void main(String[] args) {
        JdbcOfficeDML demo = new JdbcOfficeDML();
        String testCode = "99"; // Our unique officeCode

        System.out.println("=== STARTING OFFICE LIFECYCLE (Schema Match) ===\n");

        // 1. ADD - Must include all NOT NULL columns from your DDL
        demo.addOffice(testCode, "Bangalore", "+91 80 1234", "123 Tech Park", "India", "560001", "APAC");
        demo.fetchOffice(testCode);

        // 2. UPDATE - Update the city and state (state is nullable, so this is safe)
        demo.updateOffice(testCode, "Mysore", "Karnataka");
        demo.fetchOffice(testCode);

        // 3. DELETE - Cleanup
        demo.deleteOffice(testCode);
        demo.fetchOffice(testCode);
    }

    private void addOffice(String code, String city, String phone, String addr, String country, String zip, String territory) {
        System.out.println("STEP 1: Inserting new office...");
        String sql = "INSERT INTO offices (officeCode, city, phone, addressLine1, country, postalCode, territory) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, code);
            pstmt.setString(2, city);
            pstmt.setString(3, phone);
            pstmt.setString(4, addr);
            pstmt.setString(5, country);
            pstmt.setString(6, zip);
            pstmt.setString(7, territory);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Insert failed: " + e.getMessage());
        }
    }

    private void updateOffice(String code, String newCity, String newState) {
        System.out.println("STEP 2: Updating city and state...");
        String sql = "UPDATE offices SET city = ?, state = ? WHERE officeCode = ?";
        
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, newCity);
            pstmt.setString(2, newState);
            pstmt.setString(3, code);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Update failed: " + e.getMessage());
        }
    }

    private void deleteOffice(String code) {
        System.out.println("STEP 3: Deleting office...");
        String sql = "DELETE FROM offices WHERE officeCode = ?";
        
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, code);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Delete failed: " + e.getMessage());
        }
    }

    private void fetchOffice(String code) {
        String sql = "SELECT * FROM offices WHERE officeCode = ?";
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, code);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    System.out.printf(">> FOUND: [%s] %s, %s | Phone: %s | Zip: %s%n%n",
                        rs.getString("officeCode"), 
                        rs.getString("city"), 
                        rs.getString("state"), // Might be null
                        rs.getString("phone"),
                        rs.getString("postalCode"));
                } else {
                    System.out.println(">> NOT FOUND: Office " + code + " does not exist.\n");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}