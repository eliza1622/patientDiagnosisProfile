package config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class dbConnector {

    // Removed the private 'connect' variable to prevent persistent locking

    public Connection getConnection() throws SQLException {
        String url = "jdbc:sqlite:patientdiagnosisprofile.db";
        Connection conn = DriverManager.getConnection(url);
        
        // THIS LINE FIXES THE LOCKING: Enables Write-Ahead Logging
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("PRAGMA journal_mode=WAL;");
        }
        return conn;
    }

    // Function to retrieve data
    public ResultSet getData(String sql) throws SQLException {
        // We open a fresh connection for the query
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(sql);
    }

    // Function to save data
    public boolean insertData(String sql) {
        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.executeUpdate();
            System.out.println("Inserted Successfully!");
            return true;
        } catch (SQLException ex) {
            System.out.println("Connection Error: " + ex);
            return false;
        }
    }

    // Function to update data
    public void updateData(String sql) {
        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            int rowsUpdated = pst.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Data Updated Successfully!");
            }
            pst.close();
        } catch (SQLException ex) {
            System.out.println("Connection Error: " + ex);
        }
    }
}