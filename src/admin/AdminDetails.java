
package admin;

import config.session;
import config.dbConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import dhp.Signup;

public class AdminDetails extends javax.swing.JFrame {

    public AdminDetails() {
        initComponents();
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        acc_email = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        acc_fname = new javax.swing.JTextField();
        acc_lname = new javax.swing.JTextField();
        acc_uname = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        acc_id = new javax.swing.JLabel();
        acc_type = new javax.swing.JLabel();
        cancel = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("First Name :");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(30, 330, 130, 30);

        acc_email.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        acc_email.setEnabled(false);
        acc_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acc_emailActionPerformed(evt);
            }
        });
        jPanel2.add(acc_email);
        acc_email.setBounds(190, 510, 340, 40);

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Email :");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(30, 510, 130, 30);

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Last Name :");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(30, 390, 130, 30);

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Username :");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(30, 450, 130, 30);

        acc_fname.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        acc_fname.setEnabled(false);
        acc_fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acc_fnameActionPerformed(evt);
            }
        });
        jPanel2.add(acc_fname);
        acc_fname.setBounds(190, 330, 340, 40);

        acc_lname.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        acc_lname.setEnabled(false);
        acc_lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acc_lnameActionPerformed(evt);
            }
        });
        jPanel2.add(acc_lname);
        acc_lname.setBounds(190, 390, 340, 40);

        acc_uname.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        acc_uname.setEnabled(false);
        acc_uname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acc_unameActionPerformed(evt);
            }
        });
        jPanel2.add(acc_uname);
        acc_uname.setBounds(190, 450, 340, 40);

        jPanel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel9MouseClicked(evt);
            }
        });
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel9);
        jPanel9.setBounds(190, 60, 220, 200);

        acc_id.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        acc_id.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acc_id.setText("ID");
        jPanel2.add(acc_id);
        acc_id.setBounds(240, 270, 110, 20);

        acc_type.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        acc_type.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acc_type.setText("Type");
        jPanel2.add(acc_type);
        acc_type.setBounds(240, 290, 110, 20);

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
        jPanel2.add(cancel);
        cancel.setBounds(240, 600, 130, 40);

        jPanel3.setBackground(new java.awt.Color(0, 102, 153));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(jPanel3);
        jPanel3.setBounds(30, 0, 100, 200);

        jPanel4.setBackground(new java.awt.Color(0, 102, 153));
        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(jPanel4);
        jPanel4.setBounds(30, 110, 530, 90);

        jPanel5.setBackground(new java.awt.Color(0, 102, 153));
        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(jPanel5);
        jPanel5.setBounds(460, 110, 100, 700);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 760));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

        AdminDashboard ads = new AdminDashboard();
        ads.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

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

    private void jPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel9MouseClicked

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
            java.util.logging.Logger.getLogger(AdminDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField acc_email;
    public javax.swing.JTextField acc_fname;
    private javax.swing.JLabel acc_id;
    public javax.swing.JTextField acc_lname;
    private javax.swing.JLabel acc_type;
    public javax.swing.JTextField acc_uname;
    public javax.swing.JButton cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration//GEN-END:variables
}
