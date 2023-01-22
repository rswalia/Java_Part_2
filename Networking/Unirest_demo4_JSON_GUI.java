package Networking;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.net.URL;
import javax.swing.ImageIcon;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Unirest_demo4_JSON_GUI extends javax.swing.JFrame 
{

    public Unirest_demo4_JSON_GUI() 
    {
        initComponents();
        setSize(800,500);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb1 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        lb4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lb1.setText("jLabel1");
        getContentPane().add(lb1);
        lb1.setBounds(80, 40, 120, 30);

        lb2.setText("jLabel2");
        getContentPane().add(lb2);
        lb2.setBounds(80, 90, 290, 30);

        lb3.setText("jLabel3");
        getContentPane().add(lb3);
        lb3.setBounds(80, 140, 140, 40);

        lb4.setText("jLabel4");
        getContentPane().add(lb4);
        lb4.setBounds(70, 190, 140, 100);

        jButton1.setText("Fetch From Server");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(230, 30, 150, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        try 
        {
            HttpResponse<String> res =
                    Unirest.get("https://www.vmmeducation.com/vmmapi/student/3").asString();
            
            if(res.getStatus()==200)
            {
                String ans = res.getBody();
                
                //Raw JSON
                System.out.println(ans);
                System.out.println("--------------------------------------");
                
                // Create a JSON Parser
                JSONParser parser = new JSONParser();
                
                // Extract JSON Object from String
                JSONObject mainobj = (JSONObject) parser.parse(ans);
                
                // Use in Java
                long rollno = (long) mainobj.get("rollno");
                String name = (String) mainobj.get("name");
                long marks = (long) mainobj.get("marks");
                String photo = (String) mainobj.get("photo");
                
//                System.out.println(rollno);
//                System.out.println(name);
//                System.out.println(marks);
//                System.out.println(photo);

                lb1.setText("Rollno: "+ rollno);
                lb2.setText("Name: "+ name);
                lb3.setText("Marks: "+ marks);
                lb4.setIcon(new ImageIcon(new URL(photo)));
                
            }
            else
            {
                System.out.println(res.getStatus()+" "+ res.getStatusText());
            }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Unirest_demo4_JSON_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Unirest_demo4_JSON_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Unirest_demo4_JSON_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Unirest_demo4_JSON_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Unirest_demo4_JSON_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb4;
    // End of variables declaration//GEN-END:variables
}