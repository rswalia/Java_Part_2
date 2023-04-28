package Project_MovieDB;

public class search_company_panel extends javax.swing.JPanel 
{
   public search_company_panel() 
   {
        initComponents();
        setSize(640,280);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        photolb = new javax.swing.JLabel();
        namelb = new javax.swing.JLabel();
        idlb = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setLayout(null);

        photolb.setText("photo");
        photolb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));
        add(photolb);
        photolb.setBounds(10, 10, 160, 260);

        namelb.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        namelb.setText("name");
        add(namelb);
        namelb.setBounds(210, 20, 350, 60);

        idlb.setText("id");
        add(idlb);
        idlb.setBounds(210, 120, 310, 40);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel idlb;
    public javax.swing.JLabel namelb;
    public javax.swing.JLabel photolb;
    // End of variables declaration//GEN-END:variables
}