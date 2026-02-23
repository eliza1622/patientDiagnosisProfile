/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class dbConnector {

    private Connection connect;

    public dbConnector() {
        try {
            // SQLite connection (file-based)
            connect = DriverManager.getConnection("jdbc:sqlite:patientdiagnosisprofile.db");
            System.out.println("Connected to SQLite successfully!");
        } catch (SQLException ex) {
            System.out.println("Can't connect to database: " + ex.getMessage());
        }
    }

    // Function to retrieve data
    public ResultSet getData(String sql) throws SQLException {
        Statement stmt = connect.createStatement();
        return stmt.executeQuery(sql);
    }

    // Function to save data
    public boolean insertData(String sql) {
        try {
            PreparedStatement pst = connect.prepareStatement(sql);
            pst.executeUpdate();
            pst.close();
            System.out.println("Inserted Successfully!");
            return true;
        } catch (SQLException ex) {
            System.out.println("Connection Error: " + ex);
            return false;
        }
    }

    // Function to update data
    public void updateData(String sql) {
        try {
            PreparedStatement pst = connect.prepareStatement(sql);
            int rowsUpdated = pst.executeUpdate();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Data Updated Successfully!");
            } else {
                System.out.println("Data Update Failed!");
            }

            pst.close();
        } catch (SQLException ex) {
            System.out.println("Connection Error: " + ex);
        }
    }

    public Connection getConnection() {
        return connect;
    }
}