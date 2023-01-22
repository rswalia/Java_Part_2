package JDBC;

import java.sql.*;
import javax.swing.JOptionPane;

public class JDBC_Login extends javax.swing.JFrame {

    public JDBC_Login() 
    {
        initComponents();
        setSize(500,500);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tf = new javax.swing.JTextField();
        pf = new javax.swing.JPasswordField();
        lb1 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        bt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfActionPerformed(evt);
            }
        });
        getContentPane().add(tf);
        tf.setBounds(120, 60, 160, 30);
        getContentPane().add(pf);
        pf.setBounds(120, 120, 160, 30);

        lb1.setText("username");
        getContentPane().add(lb1);
        lb1.setBounds(40, 70, 70, 16);

        lb2.setText("password");
        getContentPane().add(lb2);
        lb2.setBounds(40, 130, 70, 16);

        bt.setText("LOGIN");
        bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActionPerformed(evt);
            }
        });
        getContentPane().add(bt);
        bt.setBounds(160, 180, 80, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfActionPerformed

    private void btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActionPerformed
        // TODO add your handling code here:
        try 
        {
            String u = tf.getText();
            String p = pf.getText();
            
            ResultSet rs = DBLoader.executeQuery("select * from users where username='"+u+"' and password ='"+p+"'");
            
            if(rs.next())
            {
                JOptionPane.showMessageDialog(this, "Login Successfull...");
            }
            else
            {
                JOptionPane.showMessageDialog(this, "** Login Failed **");
            }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btActionPerformed

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
            java.util.logging.Logger.getLogger(JDBC_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDBC_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDBC_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDBC_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JDBC_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JPasswordField pf;
    private javax.swing.JTextField tf;
    // End of variables declaration//GEN-END:variables
}
