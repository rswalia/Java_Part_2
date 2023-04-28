package Project_MovieDB;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class search_movie extends javax.swing.JFrame 
{
    public search_movie() 
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
        jLabel1.setText("Search Movies");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 700, 59);
        getContentPane().add(tf);
        tf.setBounds(110, 87, 484, 38);

        bt.setText("Search");
        bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActionPerformed(evt);
            }
        });
        getContentPane().add(bt);
        bt.setBounds(289, 143, 92, 42);

        javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
        mainpanel.setLayout(mainpanelLayout);
        mainpanelLayout.setHorizontalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 698, Short.MAX_VALUE)
        );
        mainpanelLayout.setVerticalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 407, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(mainpanel);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 200, 680, 409);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActionPerformed
        mainpanel.removeAll();
        String movie = tf.getText();
        String movie_space = movie.replace(" ", "%20");
        String api = "980d96176457a6e65b8bc282bcadccd4";
        try 
        {
            int x=10, y=10, k=0;
            HttpResponse<String> res =
                    Unirest.get("https://api.themoviedb.org/3/search/movie?api_key="+api+
                            "&language=en-US&query="+movie_space+"&page=1&include_adult=false").asString();
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
                    String title = (String) singleobj.get("title");
                    String title1 = title.replace(" ", "%20");
                    String photo = (String) singleobj.get("poster_path");
                    String overview = (String) singleobj.get("overview");
                    search_movie_panel obj = new search_movie_panel();
                    obj.titlelb.setText(title);
                    
                    ImageIcon im = new ImageIcon("src/images/img1.jpg");
                    Image img = im.getImage().getScaledInstance
                    (obj.photolb.getWidth(), obj.photolb.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon im1 = new ImageIcon(img);
                    obj.photolb.setIcon(im1);
                    
                    obj.ta.setText(overview);
                    
                    obj.launchbt.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) 
                        {
                            try 
                            {
                                URI u = new URI("www.youtube.com/results?search_query="+title1);
                                Desktop d = Desktop.getDesktop();
                                d.browse(u);
                            } 
                            catch (MalformedURLException ex) {
                                Logger.getLogger(search_movie.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (URISyntaxException ex) {
                                Logger.getLogger(search_movie.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {
                                Logger.getLogger(search_movie.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    });
                    
//                    obj.favbt.addActionListener(ActionEvent e)
//                    {
//                        try {
//                        ResultSet rs=favouritecode.executeQuery("select * from favouritetvshow where id='"+id2+"'");
//                        if(rs.next())
//                        {
//                            obj2.favouritebutton.setText("Remove from favourite");
//                            obj2.favouritebutton.addActionListener(new ActionListener()
//                            {
//                                @Override
//                                public void actionPerformed(ActionEvent e) {
//                                    try {
//                                        rs.deleteRow();
//                                    } catch (SQLException ex) {
//                                       ex.printStackTrace();                                    
//                                }
//                                }                      
//                            }
//                                    
//                            );
//                            
//                        }
//                        else
//                        {
//                            obj2.favouritebutton.setText("Add to favourite");
//                            try {
//                                rs.moveToInsertRow();
//                            rs.updateInt("id", id2);
//                            rs.updateString("name", title);
//                            rs.updateString("overview",overview);
//                            rs.updateString("photo",photo);
//                            rs.updateString("date", date);
//                            rs.insertRow();
//                            } catch (Exception e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }
                    obj.setBounds(x,y,640,280);
                    
                    
                    mainpanel.add(obj);
                    y=y+300;
                    repaint();
                }
                mainpanel.setPreferredSize(new Dimension(650, 300*k));
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
                new search_movie().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JTextField tf;
    // End of variables declaration//GEN-END:variables
}