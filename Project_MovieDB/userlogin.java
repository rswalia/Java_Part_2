package Project_MovieDB;

import JDBC.DBLoader;
import java.sql.*;
import javax.swing.JOptionPane;

public class userlogin extends javax.swing.JFrame 
{
    public userlogin() 
    {
        initComponents();
        setSize(450,250);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf = new javax.swing.JTextField();
        pf = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        bt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("username");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(38, 59, 88, 16);

        jLabel2.setText("password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(38, 113, 88, 16);
        getContentPane().add(tf);
        tf.setBounds(132, 51, 199, 32);
        getContentPane().add(pf);
        pf.setBounds(132, 105, 199, 33);

        jLabel3.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("USERLOGIN");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 6, 400, 33);

        bt.setText("LOGIN");
        bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActionPerformed(evt);
            }
        });
        getContentPane().add(bt);
        bt.setBounds(193, 156, 72, 32);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActionPerformed
        try 
        {
            String user = tf.getText();
            String pass = pf.getText();
            
            String sql = "select * from login where username='"+user+"' and password='"+pass+"'";
            ResultSet rs = DBLoader.executeQuery(sql);
            
            if(rs.next())
            {
                dispose();
                welcome obj = new welcome();
                obj.setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(this, "*** Login Failed ***");
            }
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_btActionPerformed

    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new userlogin().setVisible(true);
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