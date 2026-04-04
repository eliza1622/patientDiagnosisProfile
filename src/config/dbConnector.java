package config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class dbConnector {

    public Connection getConnection() throws SQLException {
        String url = "jdbc:sqlite:patientdiagnosisprofile.db";
        Connection conn = DriverManager.getConnection(url);
        
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("PRAGMA journal_mode=WAL;");
        }
        return conn;
    }

    /**
     * NEW METHOD: Records activity logs into tbl_log
     */
    public void recordLog(String username, String userType, String description) {
        String sql = "INSERT INTO tbl_log (u_username, u_type, log_description, login_time, log_status) "
                   + "VALUES (?, ?, ?, ?, 'Active')";
        
        // SQLite doesn't have NOW(), so we generate the timestamp in Java
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, username);
            pst.setString(2, userType);
            pst.setString(3, description);
            pst.setString(4, currentTime);
            
            pst.executeUpdate();
            System.out.println("Log Recorded: " + description);
            
        } catch (SQLException ex) {
            System.out.println("Logging Error: " + ex.getMessage());
        }
    }

    public ResultSet getData(String sql) throws SQLException {
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(sql);
    }

    public boolean insertData(String sql) {
        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Connection Error: " + ex);
            return false;
        }
    }

    public void updateData(String sql) {
        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            int rowsUpdated = pst.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Data Updated Successfully!");
            }
        } catch (SQLException ex) {
            System.out.println("Connection Error: " + ex);
        }
    }
}