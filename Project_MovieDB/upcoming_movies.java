package Project_MovieDB;

import com.mashape.unirest.http.*;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import org.json.simple.*;
import org.json.simple.parser.*;

public class upcoming_movies extends javax.swing.JFrame {

    public upcoming_movies() 
    {
        initComponents();
        setSize(750,700);
        fetchJSON();
    }
    
    void fetchJSON()
    {
        String api = "980d96176457a6e65b8bc282bcadccd4";
        try 
        {
            int x=10, y=20, k=0;
            HttpResponse<String> res =
                    Unirest.get("https://api.themoviedb.org/3/movie/upcoming?api_key="+api+"&language=en-US&page=1").asString();
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
                    String release_date = (String) singleobj.get("release_date");
                    upcoming_movies_panel obj = new upcoming_movies_panel();
                    obj.datelb.setText(release_date);
                    obj.titlelb.setText(title);
                    
                    ImageIcon im = new ImageIcon("src/images/img1.jpg");
                    Image img = im.getImage().getScaledInstance
                    (obj.photolb.getWidth(), obj.photolb.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon im1 = new ImageIcon(img);
                    obj.photolb.setIcon(im1);
                    
                    obj.setBounds(x,y,200,350);
                    mainpanel.add(obj);
                    x=x+230;
                    if(k%3==0)
                    {
                        x=10;
                        y=y+380;
                    }
                    repaint();
                }
                mainpanel.setPreferredSize(new Dimension(220, 350*k));
            }
        }
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jsp = new javax.swing.JScrollPane();
        mainpanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Serif", 1, 45)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Upcoming Movies");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -10, 700, 100);

        javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
        mainpanel.setLayout(mainpanelLayout);
        mainpanelLayout.setHorizontalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 748, Short.MAX_VALUE)
        );
        mainpanelLayout.setVerticalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
        );

        jsp.setViewportView(mainpanel);

        getContentPane().add(jsp);
        jsp.setBounds(27, 119, 700, 429);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new upcoming_movies().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jsp;
    private javax.swing.JPanel mainpanel;
    // End of variables declaration//GEN-END:variables
}