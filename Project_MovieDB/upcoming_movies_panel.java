package Project_MovieDB;

public class upcoming_movies_panel extends javax.swing.JPanel 
{
    public upcoming_movies_panel() 
    {
        initComponents();
        setSize(200,350);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        datelb = new javax.swing.JLabel();
        titlelb = new javax.swing.JLabel();
        photolb = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setLayout(null);

        datelb.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        datelb.setText("release_date");
        add(datelb);
        datelb.setBounds(10, 300, 188, 25);

        titlelb.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        titlelb.setText("title");
        add(titlelb);
        titlelb.setBounds(10, 240, 188, 37);

        photolb.setText("photo");
        photolb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));
        add(photolb);
        photolb.setBounds(10, 10, 180, 210);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel datelb;
    public javax.swing.JLabel photolb;
    public javax.swing.JLabel titlelb;
    // End of variables declaration//GEN-END:variables
}