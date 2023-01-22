package JDBC;

import java.sql.*;
import javax.swing.JOptionPane;

public class JDBC_Insert extends javax.swing.JFrame 
{
    public JDBC_Insert() 
    {
        initComponents();
        setSize(500,500);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tf3 = new javax.swing.JTextField();
        tf1 = new javax.swing.JTextField();
        tf2 = new javax.swing.JTextField();
        lb3 = new javax.swing.JLabel();
        lb1 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        bt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        tf3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf3ActionPerformed(evt);
            }
        });
        getContentPane().add(tf3);
        tf3.setBounds(120, 140, 150, 30);
        getContentPane().add(tf1);
        tf1.setBounds(120, 40, 150, 30);
        getContentPane().add(tf2);
        tf2.setBounds(120, 90, 150, 30);

        lb3.setText("marks");
        getContentPane().add(lb3);
        lb3.setBounds(60, 150, 70, 16);

        lb1.setText("rollno");
        getContentPane().add(lb1);
        lb1.setBounds(60, 50, 70, 16);

        lb2.setText("name");
        getContentPane().add(lb2);
        lb2.setBounds(60, 100, 70, 16);

        bt.setText("ADD");
        bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActionPerformed(evt);
            }
        });
        getContentPane().add(bt);
        bt.setBounds(160, 190, 80, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActionPerformed
        // TODO add your handling code here:
        try 
        {
            int rollno = Integer.parseInt(tf1.getText());
            String name = tf2.getText();
            int marks = Integer.parseInt(tf3.getText());
            
            String sql = "select * from demo1 where rollno="+rollno;
            ResultSet rs = DBLoader.executeQuery(sql);
            
            //Duplicacy Check
            if(rs.next())
            {
//                System.out.println("DUPLICACY FOUND...This rollno already exist");
                JOptionPane.showMessageDialog(this,"** DUPLICACY FOUND ** This rollno already exist");
            }
            else
            {
                rs.moveToInsertRow();
                
                rs.updateInt("rollno", rollno);
                rs.updateString("name", name);
                rs.updateInt("marks", marks);
                
                rs.insertRow();
                
                JOptionPane.showMessageDialog(this, "** Inserted Successfully **");
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btActionPerformed

    private void tf3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf3ActionPerformed

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
            java.util.logging.Logger.getLogger(JDBC_Insert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDBC_Insert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDBC_Insert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDBC_Insert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JDBC_Insert().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JTextField tf1;
    private javax.swing.JTextField tf2;
    private javax.swing.JTextField tf3;
    // End of variables declaration//GEN-END:variables
}