package JDBC;

import java.sql.*;
import javax.swing.JOptionPane;

public class CRUD_Login extends javax.swing.JFrame
{
    public CRUD_Login()
    {
        initComponents();
        setSize(500,500);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf = new javax.swing.JTextField();
        bt1 = new javax.swing.JButton();
        pf = new javax.swing.JPasswordField();
        bt2 = new javax.swing.JButton();
        bt3 = new javax.swing.JButton();
        bt4 = new javax.swing.JButton();
        bt5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("username");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(70, 40, 100, 30);

        jLabel2.setText("password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(70, 100, 110, 30);
        getContentPane().add(tf);
        tf.setBounds(150, 40, 200, 40);

        bt1.setText("INSERT");
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt1);
        bt1.setBounds(280, 250, 90, 30);
        getContentPane().add(pf);
        pf.setBounds(150, 100, 200, 40);

        bt2.setText("LOGIN");
        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });
        getContentPane().add(bt2);
        bt2.setBounds(200, 160, 110, 50);

        bt3.setText("SELECT");
        bt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt3ActionPerformed(evt);
            }
        });
        getContentPane().add(bt3);
        bt3.setBounds(150, 250, 90, 30);

        bt4.setText("UPDATE");
        bt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt4ActionPerformed(evt);
            }
        });
        getContentPane().add(bt4);
        bt4.setBounds(150, 320, 90, 30);

        bt5.setText("DELETE");
        bt5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt5ActionPerformed(evt);
            }
        });
        getContentPane().add(bt5);
        bt5.setBounds(280, 320, 90, 30);

        jLabel3.setText("( login schema )");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(220, 290, 110, 16);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
        // INSERT
        try 
        {
            String user = tf.getText();
            String pass = pf.getText();

            String sql = "select * from login where username='"+user+"'";
            ResultSet rs = DBLoader.executeQuery(sql);
            
            if(rs.next())
            {
                JOptionPane.showMessageDialog(this, "*** Username already exist ***");
            }
            else
            {
                rs.moveToInsertRow();
                
                rs.updateString("username", user);
                rs.updateString("password", pass);
                
                rs.insertRow();
                
                JOptionPane.showMessageDialog(this, "Inserted Successfully !!!");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_bt1ActionPerformed

    private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt2ActionPerformed
        // LOGIN
        try 
        {
            String user = tf.getText();
            String pass = pf.getText();
            
            String sql = "select * from login where username='"+user+"' and password='"+pass+"'";
            ResultSet rs = DBLoader.executeQuery(sql);
            
            if(rs.next())
            {
                JOptionPane.showMessageDialog(this, "Login Successfull !!!");
                
                dispose();
                JDBC_Insert obj = new JDBC_Insert();
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
    }//GEN-LAST:event_bt2ActionPerformed

    private void bt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt3ActionPerformed
        // SELECT
        try 
        {
            String user;
            String pass;
            
            String sql = "select * from login";
            ResultSet rs = DBLoader.executeQuery(sql);
            
            while(rs.next())
            {
                user = rs.getString("username");
                pass = rs.getString("password");
//                JOptionPane.showMessageDialog(this, user+"\t"+pass);
                System.out.println(user+"\t"+pass);
            }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_bt3ActionPerformed

    private void bt4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt4ActionPerformed
        // UPDATE
        try 
        {
            String user = tf.getText();
            String pass = pf.getText();
            
            String sql = "select * from login where username='"+user+"'";
            ResultSet rs = DBLoader.executeQuery(sql);
            
            if(rs.next())
            {
                rs.updateString("username", user);
                rs.updateString("password", pass);
                
                rs.updateRow();
                
                JOptionPane.showMessageDialog(this, "Updated Successfully !!!");
            }
            else
            {
                JOptionPane.showMessageDialog(this, "*** Not Found ***");
            }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_bt4ActionPerformed

    private void bt5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt5ActionPerformed
        // DELETE
        try 
        {
            String user = tf.getText();
            
            String sql = "select * from login where username='"+user+"'";
            ResultSet rs = DBLoader.executeQuery(sql);
            
            if(rs.next())
            {
                rs.deleteRow();
                
                JOptionPane.showMessageDialog(this, "Deleted Successfully !!!");
            }
            else
            {
                JOptionPane.showMessageDialog(this, "*** Not Found ***");
            }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_bt5ActionPerformed

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
            java.util.logging.Logger.getLogger(CRUD_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CRUD_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CRUD_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CRUD_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CRUD_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt1;
    private javax.swing.JButton bt2;
    private javax.swing.JButton bt3;
    private javax.swing.JButton bt4;
    private javax.swing.JButton bt5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField pf;
    private javax.swing.JTextField tf;
    // End of variables declaration//GEN-END:variables
}
