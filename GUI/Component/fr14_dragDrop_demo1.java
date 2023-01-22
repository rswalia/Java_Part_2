package GUI.Component;

public class fr14_dragDrop_demo1 extends javax.swing.JFrame {

    public fr14_dragDrop_demo1() {
        initComponents();
        lb.setVisible(false);
        
        pbar.setValue(40);
        pbar.setString("Loading");
        pbar.setStringPainted(true);
        
        setSize(500,500);
        
        //Move Progress Bar
//        for(int i=1; i<=100; i++)
//        {
//            pbar.setValue(i);
//            pbar.setString(i +" % Completed");
//            try
//            {
//                Thread.sleep(100);
//            }
//            catch(Exception ex)
//            {
//                ex.printStackTrace();
//            }
//        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ch = new javax.swing.JCheckBox();
        lb = new javax.swing.JLabel();
        pbar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        ch.setText("Show");
        ch.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chItemStateChanged(evt);
            }
        });
        ch.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                chAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        ch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chActionPerformed(evt);
            }
        });
        getContentPane().add(ch);
        ch.setBounds(140, 130, 85, 20);

        lb.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lb.setText("Welcome");
        getContentPane().add(lb);
        lb.setBounds(120, 50, 140, 50);
        getContentPane().add(pbar);
        pbar.setBounds(50, 190, 270, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chActionPerformed
    }//GEN-LAST:event_chActionPerformed

    private void chItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chItemStateChanged
        // TODO add your handling code here:
        if(ch.isSelected())
        {
            lb.setVisible(true);
        }
        else
        {
            lb.setVisible(false);
        }
    }//GEN-LAST:event_chItemStateChanged

    private void chAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_chAncestorAdded
    }//GEN-LAST:event_chAncestorAdded

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
            java.util.logging.Logger.getLogger(fr14_dragDrop_demo1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fr14_dragDrop_demo1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fr14_dragDrop_demo1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fr14_dragDrop_demo1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new fr14_dragDrop_demo1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ch;
    private javax.swing.JLabel lb;
    private javax.swing.JProgressBar pbar;
    // End of variables declaration//GEN-END:variables
}
