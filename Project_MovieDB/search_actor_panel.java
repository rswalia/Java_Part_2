package Project_MovieDB;

public class search_actor_panel extends javax.swing.JPanel 
{
    public search_actor_panel() 
    {
        initComponents();
        setSize(200,300);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb1 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        photolb = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setLayout(null);

        lb1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        lb1.setText("name");
        add(lb1);
        lb1.setBounds(20, 190, 169, 33);

        lb2.setText("known_for");
        add(lb2);
        lb2.setBounds(20, 230, 160, 30);

        lb3.setText("popularity");
        add(lb3);
        lb3.setBounds(20, 260, 169, 22);

        photolb.setText("photo");
        photolb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(photolb);
        photolb.setBounds(20, 20, 155, 155);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel lb1;
    public javax.swing.JLabel lb2;
    public javax.swing.JLabel lb3;
    public javax.swing.JLabel photolb;
    // End of variables declaration//GEN-END:variables
}