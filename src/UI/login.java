package UI;

import javax.swing.JOptionPane;
import domain.Member;
import java.awt.Dimension;
import javax.swing.JFrame;

public class login extends javax.swing.JFrame {

    public login() {
        initComponents();
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tf_username = new javax.swing.JTextField();
        tf_pass = new javax.swing.JPasswordField();
        member = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        staff = new javax.swing.JButton();
        register = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/EasyExpress.PNG"))); // NOI18N

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/smaller.png"))); // NOI18N

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/q0YWfFw.jpg"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main Menu");
        setMinimumSize(new java.awt.Dimension(601, 392));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Easy Express Bus System");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(180, 30, 258, 47);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Username:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(160, 140, 63, 16);

        jLabel3.setText("Password:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(160, 170, 63, 16);

        tf_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_usernameActionPerformed(evt);
            }
        });
        getContentPane().add(tf_username);
        tf_username.setBounds(240, 140, 170, 30);

        tf_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_passActionPerformed(evt);
            }
        });
        getContentPane().add(tf_pass);
        tf_pass.setBounds(240, 170, 170, 30);

        member.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/User-Administrator-Blue-icon.png"))); // NOI18N
        member.setText("Member");
        member.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberActionPerformed(evt);
            }
        });
        getContentPane().add(member);
        member.setBounds(260, 240, 110, 33);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Log-Out-icon.png"))); // NOI18N
        jLabel4.setText("Login");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(270, 80, 110, 30);

        staff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Groups-Meeting-Light-icon.png"))); // NOI18N
        staff.setText("Staff");
        staff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffActionPerformed(evt);
            }
        });
        getContentPane().add(staff);
        staff.setBounds(400, 240, 100, 30);

        register.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Register-icon.png"))); // NOI18N
        register.setText("Register");
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });
        getContentPane().add(register);
        register.setBounds(120, 240, 120, 33);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/security-icon.png"))); // NOI18N
        jButton1.setText("Forget Password");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(240, 290, 170, 33);
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 316, 0);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/q0YWfFw.jpg"))); // NOI18N
        getContentPane().add(jLabel9);
        jLabel9.setBounds(0, 0, 600, 390);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tf_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_usernameActionPerformed

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed
        dispose();
        register r = new register();
        r.setVisible(true);
    }//GEN-LAST:event_registerActionPerformed

    private void memberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberActionPerformed
        String username = tf_username.getText();
        String password = tf_pass.getText();
        
        try{
            memberTier mt = new memberTier();
            Member m = new Member();
            m.setUsername(username);
            m.setPassword(password);
            String memID = mt.memlog(m);
                if (memID == null){
                  
                     JOptionPane.showMessageDialog(this, "Invalid Username or Password");
                    
                } else {
                     JOptionPane.showMessageDialog(this, "Login Success\n\nMember Name : "+memID);
                    String memId = m.getMemID();
                    dispose();
                    showMem sm = new showMem(memId);
                    sm.setVisible(true);
                }
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
    }//GEN-LAST:event_memberActionPerformed

    private void staffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffActionPerformed
         String username = tf_username.getText();
         String password = tf_pass.getText();
          
         try{
             staffTier st = new staffTier();
             
             String s_name = st.stafflog(username,password);
                 if (s_name == null){
                     JOptionPane.showMessageDialog(this, "Invalid Username or Password");
                 } else {
                     JOptionPane.showMessageDialog(this, "Login Success\n\nStaff Name : "+s_name);
                     dispose();
                     showStaff ss = new showStaff();
                     ss.setVisible(true);
                 }
                 
             } catch (Exception ex) {
                 JOptionPane.showMessageDialog(this, ex.getMessage());
             }

    }//GEN-LAST:event_staffActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        recover r = new recover();
        r.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tf_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_passActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton member;
    private javax.swing.JButton register;
    private javax.swing.JButton staff;
    private javax.swing.JPasswordField tf_pass;
    private javax.swing.JTextField tf_username;
    // End of variables declaration//GEN-END:variables
}
