package Project_2_POS;

import java.sql.*;
import javax.swing.*;

public class admin_login extends javax.swing.JFrame 
{

    public admin_login() 
    {
        initComponents();
        setTitle("Admin_Login");
        setSize(500,500);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tf = new javax.swing.JTextField();
        pf = new javax.swing.JPasswordField();
        bt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Admin Login");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(140, 0, 150, 40);

        jLabel2.setText("password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(80, 110, 100, 30);

        jLabel3.setText("username");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(80, 60, 110, 20);
        getContentPane().add(tf);
        tf.setBounds(150, 60, 180, 30);
        getContentPane().add(pf);
        pf.setBounds(150, 110, 180, 30);

        bt.setText("LOGIN");
        bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActionPerformed(evt);
            }
        });
        getContentPane().add(bt);
        bt.setBounds(150, 170, 120, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActionPerformed
        // LOGIN
        try 
        {
            String user = tf.getText();
            String pass = pf.getText();
            
            String sql = "select * from admin where username='"+ user +"' and password='"+ pass +"'";
            ResultSet rs = DBLoader_POS.executeQuery(sql);
            
            if(rs.next())
            {
                JOptionPane.showMessageDialog(this, "Login Successfull !!!");
                
                dispose();
                admin_home obj = new admin_home();
                obj.setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(this, "*** Login Failed ***");
            }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_btActionPerformed

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
            java.util.logging.Logger.getLogger(admin_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField pf;
    private javax.swing.JTextField tf;
    // End of variables declaration//GEN-END:variables
}
