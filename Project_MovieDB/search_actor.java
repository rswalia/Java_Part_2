package Project_MovieDB;

import com.mashape.unirest.http.*;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

public class search_actor extends javax.swing.JFrame 
{
    public search_actor() 
    {
        initComponents();
        setSize(700,650);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tf = new javax.swing.JTextField();
        bt = new javax.swing.JButton();
        jsp = new javax.swing.JScrollPane();
        mainpanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Search Actor");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 700, 60);
        getContentPane().add(tf);
        tf.setBounds(100, 90, 517, 36);

        bt.setText("Search");
        bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActionPerformed(evt);
            }
        });
        getContentPane().add(bt);
        bt.setBounds(310, 140, 86, 45);

        javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
        mainpanel.setLayout(mainpanelLayout);
        mainpanelLayout.setHorizontalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 688, Short.MAX_VALUE)
        );
        mainpanelLayout.setVerticalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        jsp.setViewportView(mainpanel);

        getContentPane().add(jsp);
        jsp.setBounds(30, 230, 650, 360);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActionPerformed
        mainpanel.removeAll();
        String actor = tf.getText();
        String actor_space = actor.replace(" ", "%20");
        String api = "980d96176457a6e65b8bc282bcadccd4";
        try 
        {
            int x=10, y=10, k=0;
            HttpResponse<String> res =
                    Unirest.get("https://api.themoviedb.org/3/search/person?api_key="+api+
                            "&language=en-US&query="+actor_space+"&page=1&include_adult=false").asString();
            if(res.getStatus()==200)
            {
                String ans = res.getBody();
                JSONParser parser = new JSONParser();
                JSONObject mainobj = (JSONObject) parser.parse(ans);
                JSONArray myarray = (JSONArray) mainobj.get("results");
                for(int i=0; i<myarray.size(); i++)
                {
                    k++; // count panels
                    JSONObject singleobj = (JSONObject) myarray.get(i);
                    String name = (String) singleobj.get("name");
                    String known_for = (String) singleobj.get("known_for_department");
                    Double popularity = (Double) singleobj.get("popularity");
                    search_actor_panel obj = new search_actor_panel();
                    obj.lb1.setText(name);
                    obj.lb2.setText(known_for);
                    obj.lb3.setText(popularity+"");
                    
                    ImageIcon im = new ImageIcon("src/images/img1.jpg");
                    Image img = im.getImage().getScaledInstance
                    (obj.photolb.getWidth(), obj.photolb.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon im1 = new ImageIcon(img);
                    obj.photolb.setIcon(im1);
                    
                    obj.setBounds(x,y,200,300);
                    mainpanel.add(obj);
                    x=x+220;
                    repaint();
                }
                mainpanel.setPreferredSize(new Dimension(220*k, 300));
            }
        }
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new search_actor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jsp;
    public static javax.swing.JPanel mainpanel;
    private static javax.swing.JTextField tf;
    // End of variables declaration//GEN-END:variables
}