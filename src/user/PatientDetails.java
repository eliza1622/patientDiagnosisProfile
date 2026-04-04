
package user;

import config.session;
import config.dbConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import dhp.Signup;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PatientDetails extends javax.swing.JFrame {
    
    public String selectedImagePath;
    
    public PatientDetails() {
        initComponents();
         loadUserProfile();
    }
    
       private void loadUserProfile() {
    dbConnector dbc = new dbConnector();
    session sess = session.getInstance();

    String query = "SELECT u_image FROM tbl_user WHERE u_id = ?";

    try (Connection conn = dbc.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(query)) {

        pstmt.setInt(1, sess.getUid());
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            String imagePath = rs.getString("u_image");

            if (imagePath != null && !imagePath.isEmpty()) {
                ImageIcon icon = new ImageIcon(imagePath);
                image.setIcon(icon);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Log the error
        JOptionPane.showMessageDialog(this, "Error loading profile image: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}   
  public boolean updateCheck(){
        
     dbConnector dbc = new dbConnector();
    session sess = session.getInstance();

    try {
        String query = "SELECT * FROM tbl_user WHERE (u_username = '" + acc_email.getText() 
                     + "' OR u_email = '" + acc_uname.getText() 
                     + "') AND u_id != '" + sess.getUid() + "'";

        ResultSet resultSet = dbc.getData(query);

        if (resultSet.next()) {
            String email = resultSet.getString("u_email"); 
            if (email.equals(acc_uname.getText())) { 
                JOptionPane.showMessageDialog(null, "Email is Already Used!");
                acc_uname.setText(""); 
            }

            String username = resultSet.getString("u_username");
            if (username.equals(acc_email.getText())) { 
                JOptionPane.showMessageDialog(null, "Username is Already Used!");
                acc_email.setText(""); 
            }

            return true;
        } else {
            return false;
        }
    } catch (SQLException ex) {
        System.out.println("" + ex);
        return false;
    }
        
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        acc_id = new javax.swing.JLabel();
        acc_type = new javax.swing.JLabel();
        cancel = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        acc_email = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        acc_fname = new javax.swing.JTextField();
        acc_lname = new javax.swing.JTextField();
        acc_uname = new javax.swing.JTextField();
        acc_name = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel9MouseClicked(evt);
            }
        });
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/wave.png"))); // NOI18N
        jPanel9.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 170));

        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 180, 170));

        acc_id.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        acc_id.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acc_id.setText("ID");
        jPanel3.add(acc_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 110, 20));

        acc_type.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        acc_type.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acc_type.setText("Type");
        jPanel3.add(acc_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 110, 20));

        cancel.setBackground(new java.awt.Color(255, 255, 255));
        cancel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cancel.setForeground(new java.awt.Color(27, 57, 77));
        cancel.setText("Cancel");
        cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelMouseClicked(evt);
            }
        });
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel3.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 130, 40));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setText("SAVE");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, 130, 40));

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton3.setText("SELECT IMAGE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 140, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 460));

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("First Name :");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 110, 40));

        acc_email.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        acc_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acc_emailActionPerformed(evt);
            }
        });
        jPanel2.add(acc_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 400, 40));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Email :");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 60, 40));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Last Name :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 110, 40));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Username :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 100, 40));

        acc_fname.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        acc_fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acc_fnameActionPerformed(evt);
            }
        });
        jPanel2.add(acc_fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 400, 40));

        acc_lname.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        acc_lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acc_lnameActionPerformed(evt);
            }
        });
        jPanel2.add(acc_lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 400, 40));

        acc_uname.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        acc_uname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acc_unameActionPerformed(evt);
            }
        });
        jPanel2.add(acc_uname, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 400, 40));

        acc_name.setFont(new java.awt.Font("Times New Roman", 3, 40)); // NOI18N
        acc_name.setForeground(new java.awt.Color(255, 255, 255));
        acc_name.setText("jLabel5");
        jPanel2.add(acc_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 380, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 460, 460));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       session sess = session.getInstance();
        if (sess.getUid() == 0) {

           Signup fm = new Signup();
                   fm.setVisible(true);
                   this.dispose();
            JOptionPane.showMessageDialog(null, "No Account, Login FIrst");
        } else {
            
            
            acc_name.setText("Greetings to you," + sess.getFname());
            acc_fname.setText("" + sess.getFname());
            acc_lname.setText("" + sess.getLname());
            acc_email.setText("" + sess.getEmail());
            acc_uname.setText("" + sess.getUsername());
            acc_type.setText("" + sess.getType());
            acc_id.setText("" + sess.getUid());  
        }// TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelMouseClicked

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed

        PatientDashboard ed = new PatientDashboard();
                ed.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void jPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel9MouseClicked

    private void acc_unameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acc_unameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_acc_unameActionPerformed

    private void acc_lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acc_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_acc_lnameActionPerformed

    private void acc_fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acc_fnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_acc_fnameActionPerformed

    private void acc_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acc_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_acc_emailActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
                                      
    // 1. Capture all fields for display/logic
    String id = acc_id.getText().trim();
    String email = acc_email.getText().trim();
    String username = acc_uname.getText().trim();
    String firstName = acc_fname.getText().trim();
    String lastName = acc_lname.getText().trim();
    
    // Get the current user from session for the logs
    config.session sess = config.session.getInstance();

    // 2. Validation
    if (id.isEmpty() || email.isEmpty() || username.isEmpty() || firstName.isEmpty() || lastName.isEmpty()) {
        JOptionPane.showMessageDialog(this, "All fields are required for the update.", "Validation Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // 3. Format Validation (Email & Username)
    if (!email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
        JOptionPane.showMessageDialog(this, "Invalid Email format!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    if (!username.matches("[a-zA-Z0-9_]{5,}")) {
        JOptionPane.showMessageDialog(this, "Username must be 5+ characters.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        dbConnector dbc = new dbConnector();
        Connection conn = dbc.getConnection();

        // 4. Check for duplicates
        String checkQuery = "SELECT COUNT(*) FROM tbl_user WHERE (u_username = ? OR u_email = ?) AND u_id != ?";
        try (PreparedStatement checkPst = conn.prepareStatement(checkQuery)) {
            checkPst.setString(1, username);
            checkPst.setString(2, email);
            checkPst.setInt(3, Integer.parseInt(id));

            try (ResultSet rs = checkPst.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    JOptionPane.showMessageDialog(this, "Username or Email already taken!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        }

        // 5. UPDATE the profile
        String updateQuery = "UPDATE tbl_user SET u_email = ?, u_username = ?, u_fname = ?, u_lname = ? WHERE u_id = ?";

        try (PreparedStatement updatePst = conn.prepareStatement(updateQuery)) {
            updatePst.setString(1, email);
            updatePst.setString(2, username);
            updatePst.setString(3, firstName);
            updatePst.setString(4, lastName);
            updatePst.setInt(5, Integer.parseInt(id));

            int rows = updatePst.executeUpdate();
            if (rows > 0) {
                // --- ADD LOGGING HERE ---
                String logMsg = "Updated Profile Info for: " + firstName + " " + lastName + " (ID: " + id + ")";
                dbc.recordLog(sess.getUsername(), sess.getType(), logMsg);
                // ------------------------

                JOptionPane.showMessageDialog(this, "Profile updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                new PatientDashboard().setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "User not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Invalid User ID.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png"));

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            File destinationFolder = new File("src/images/");

            if (!destinationFolder.exists()) {
                destinationFolder.mkdirs();
            }

            // Rename file based on ID to prevent overwriting
            String fileName = acc_id.getText() + "_" + selectedFile.getName();
            File destinationFile = new File(destinationFolder, fileName);

            try {
                Files.copy(selectedFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                selectedImagePath = "src/images/" + fileName;

                // 1. Update the UI Label immediately
                image.setIcon(resizeImage(destinationFile.getAbsolutePath(), null));
                image.setText("");

                // 2. DATABASE UPDATE
                dbConnector dbc = new dbConnector();
                String sql = "UPDATE tbl_user SET u_image = '" + selectedImagePath + "' WHERE u_id = '" + acc_id.getText() + "'";

                if(dbc.insertData(sql)){
                    // --- CRITICAL CHANGE HERE ---
                    // Update the session so it displays when the window is activated/reopened
                    session sess = session.getInstance();
                    sess.setPic(selectedImagePath);
                    // ----------------------------

                    JOptionPane.showMessageDialog(this, "Profile Picture Updated!");
                }

            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PatientDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PatientDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PatientDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PatientDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PatientDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField acc_email;
    public javax.swing.JTextField acc_fname;
    private javax.swing.JLabel acc_id;
    public javax.swing.JTextField acc_lname;
    private javax.swing.JLabel acc_name;
    private javax.swing.JLabel acc_type;
    public javax.swing.JTextField acc_uname;
    public javax.swing.JButton cancel;
    private javax.swing.JLabel image;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration//GEN-END:variables
public javax.swing.ImageIcon resizeImage(String imgPath, byte[] pic) {
    javax.swing.ImageIcon myImage = null;
    if (imgPath != null) {
        myImage = new javax.swing.ImageIcon(imgPath);
    } else {
        myImage = new javax.swing.ImageIcon(pic);
    }
    java.awt.Image img = myImage.getImage();
    // 200x180 matches your AbsoluteConstraints in jPanel9
    java.awt.Image newImg = img.getScaledInstance(200, 180, java.awt.Image.SCALE_SMOOTH);
    return new javax.swing.ImageIcon(newImg);
}
}
