package Project_MovieDB;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class search_company extends javax.swing.JFrame 
{
    public search_company() 
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
        jScrollPane1 = new javax.swing.JScrollPane();
        mainpanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Search Company");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(6, 0, 688, 59);
        getContentPane().add(tf);
        tf.setBounds(100, 100, 516, 43);

        bt.setText("Search");
        bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActionPerformed(evt);
            }
        });
        getContentPane().add(bt);
        bt.setBounds(299, 170, 103, 45);

        javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
        mainpanel.setLayout(mainpanelLayout);
        mainpanelLayout.setHorizontalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 618, Short.MAX_VALUE)
        );
        mainpanelLayout.setVerticalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 368, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(mainpanel);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 250, 620, 370);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    static void go(String s)
    {
        String api = "980d96176457a6e65b8bc282bcadccd4";
        try 
        {
            int x=10, y=10, k=0;
            HttpResponse<String> res =
                    Unirest.get("https://api.themoviedb.org/3/search/company?api_key="+ api +"&query="+ s +"&page=1").asString();
            if(res.getStatus()==200)
            {
                String ans = res.getBody();
                JSONParser parser = new JSONParser();
                JSONObject mainobj = (JSONObject) parser.parse(ans);
                JSONArray myarray = (JSONArray) mainobj.get("results"); 
//                System.out.println(myarray);
                for(int i=0; i<myarray.size(); i++)
                {
                    k++; // count panels
                    JSONObject singleobj = (JSONObject) myarray.get(i);
                    String name = (String) singleobj.get("name");
                    long id = (long) singleobj.get("id");
                    search_company_panel obj = new search_company_panel();
                    obj.namelb.setText(name);
                    obj.idlb.setText(id+"");
                    
                    ImageIcon im = new ImageIcon("src/images/img1.jpg");
                    Image img = im.getImage().getScaledInstance
                    (obj.photolb.getWidth(), obj.photolb.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon im1 = new ImageIcon(img);
                    obj.photolb.setIcon(im1);
                    
                    obj.setBounds(x,y,640,280);
                    mainpanel.add(obj);
                    y=y+300;
                    mainpanel.repaint();
                    obj.repaint();
                }
                mainpanel.setPreferredSize(new Dimension(650, 300*k));
            }
        }
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
    }
    
    private void btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActionPerformed
        mainpanel.removeAll();
        String movie = tf.getText();
        String movie_space = movie.replace(" ", "%20");
        
        go(movie_space);
        
    }//GEN-LAST:event_btActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new search_company().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JPanel mainpanel;
    private javax.swing.JTextField tf;
    // End of variables declaration//GEN-END:variables
}