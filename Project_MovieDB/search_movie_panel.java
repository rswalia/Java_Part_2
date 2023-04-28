package Project_MovieDB;

public class search_movie_panel extends javax.swing.JPanel {

    public search_movie_panel() 
    {
        initComponents();
        setSize(640,280);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        photolb = new javax.swing.JLabel();
        titlelb = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta = new javax.swing.JTextArea();
        favbt = new javax.swing.JButton();
        launchbt = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setLayout(null);

        photolb.setText("photo");
        photolb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));
        add(photolb);
        photolb.setBounds(10, 10, 163, 260);

        titlelb.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        titlelb.setText("title");
        add(titlelb);
        titlelb.setBounds(190, 10, 390, 60);

        ta.setColumns(20);
        ta.setLineWrap(true);
        ta.setRows(5);
        jScrollPane1.setViewportView(ta);

        add(jScrollPane1);
        jScrollPane1.setBounds(190, 70, 400, 170);

        favbt.setText("Add To Favorite");
        favbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                favbtActionPerformed(evt);
            }
        });
        add(favbt);
        favbt.setBounds(420, 250, 170, 23);

        launchbt.setText("Launch Youtube Trailer");
        launchbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                launchbtActionPerformed(evt);
            }
        });
        add(launchbt);
        launchbt.setBounds(210, 250, 190, 23);
    }// </editor-fold>//GEN-END:initComponents

    private void favbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_favbtActionPerformed
        
        
    }//GEN-LAST:event_favbtActionPerformed

    private void launchbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_launchbtActionPerformed
        
    }//GEN-LAST:event_launchbtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton favbt;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JButton launchbt;
    public javax.swing.JLabel photolb;
    public javax.swing.JTextArea ta;
    public javax.swing.JLabel titlelb;
    // End of variables declaration//GEN-END:variables
}