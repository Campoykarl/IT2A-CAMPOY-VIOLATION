
package it2a.campoy.dvs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;




public class config {
   public static Connection connectDB() {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC"); 
            con = DriverManager.getConnection("jdbc:sqlite:DriverViolationapp.db"); 
            System.out.println("Connection Successful");
        } catch (Exception e) {
            System.out.println("Connection Failed: " + e);
        }
        return con;
    }

 public void addViol(String sql, String... values) {
        try (Connection conn = this.connectDB(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

           
            for (int i = 0; i < values.length; i++) {
                pstmt.setString(i + 1, values[i]); 
            }

            pstmt.executeUpdate();
            System.out.println("Record added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding record: " + e.getMessage());
        }
 }

public void viewViolations() {
        config con = new config();
        String sql = "SELECT * FROM DViolation";
        
        try (Connection connection = this.connectDB();
             PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
             
            while (rs.next()) {
                System.out.println("First Name: " + rs.getString("f_name"));
                System.out.println("Last Name: " + rs.getString("l_name"));
                System.out.println("Address: " + rs.getString("address"));
                System.out.println("Status: " + rs.getString("status"));
                System.out.println("Violation: " + rs.getString("violation"));
                System.out.println("----------------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving violations: " + e.getMessage());
        }
    }
}