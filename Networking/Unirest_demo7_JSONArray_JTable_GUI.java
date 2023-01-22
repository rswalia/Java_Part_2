package Networking;

import com.mashape.unirest.http.*;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

public class Unirest_demo7_JSONArray_JTable_GUI extends javax.swing.JFrame 
{
    ArrayList<Student2> al;
    myTableModel tm;
    
    public Unirest_demo7_JSONArray_JTable_GUI() 
    {
        al = new ArrayList<>();
        tm = new myTableModel();
        
        initComponents();
        
        //attach JTable with TableModel
        jt.setModel(tm);
        
        setSize(800,500);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jsp = new javax.swing.JScrollPane();
        jt = new javax.swing.JTable();
        bt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jsp.setViewportView(jt);

        getContentPane().add(jsp);
        jsp.setBounds(10, 92, 630, 270);

        bt.setText("Load Student List From Server");
        bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActionPerformed(evt);
            }
        });
        getContentPane().add(bt);
        bt.setBounds(210, 30, 210, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    ///////// Inner class ////////
    class myTableModel extends AbstractTableModel
    {
        @Override
        public int getRowCount() 
        {
            return al.size();
        }

        @Override
        public int getColumnCount() 
        {
            return 3;
        }

        @Override
        public Object getValueAt(int i, int j) 
        {
            Student2 st = al.get(i);
            
            if(j==0)
                return st.rollno;
            else if(j==1)
                return st.name;
            else
                return st.marks;
        }

        @Override
        public String getColumnName(int j) 
        {
            String col[] = {"RollNo","Name","Marks"};
            return col[j];
        }
    }
    
    private void btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActionPerformed
        try 
        {
            HttpResponse<String> res =
                    Unirest.get("https://www.vmmeducation.com/vmmapi/getstudents").asString();
            
            // Raw JSON
            String ans = res.getBody();
            System.out.println(ans);
            System.out.println("----------------------------------");
            
            // Create a JSON Parser
            JSONParser parser = new JSONParser();
            
            // First Extract main object from String
            JSONObject mainobj = (JSONObject) parser.parse(ans);
            
            // Now Extract JSONArray from main object
            JSONArray myarray = (JSONArray) mainobj.get("ans");
            
            al.clear();
            
            for(int i=0; i<myarray.size(); i++)
            {
                JSONObject singleobj = (JSONObject) myarray.get(i);
//                System.out.println(singleobj);

                // use members of singleobj
                long rollno = (long) singleobj.get("rollno");
                String name = (String) singleobj.get("name");
                long marks = (long) singleobj.get("marks");
                String photo = (String) singleobj.get("photo");
                
                Student2 obj = new Student2(rollno, name, marks, photo);
                al.add(obj);
                
                System.out.println(rollno +"\t"+ name +"\t"+ marks +"\t"+ photo);
                System.out.println("-----------------------------------------");
            }
           
            // refresh JTable
            tm.fireTableDataChanged();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        
    }//GEN-LAST:event_btActionPerformed

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
            java.util.logging.Logger.getLogger(Unirest_demo7_JSONArray_JTable_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Unirest_demo7_JSONArray_JTable_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Unirest_demo7_JSONArray_JTable_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Unirest_demo7_JSONArray_JTable_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Unirest_demo7_JSONArray_JTable_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt;
    private javax.swing.JScrollPane jsp;
    private javax.swing.JTable jt;
    // End of variables declaration//GEN-END:variables
}
