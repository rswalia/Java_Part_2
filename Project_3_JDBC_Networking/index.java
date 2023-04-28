/*
    JDBC_JTable
    JSONArray_inside_JSONObject( /getstudents )_JTable
*/
package Project_3_JDBC_Networking;

import JDBC.DBLoader;
import com.mashape.unirest.http.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.sql.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class index extends JFrame implements ActionListener
{
    ArrayList<Student> al;
    JButton bt1, bt2;
    JTable jt;
    JScrollPane jsp;
    myTableModel tm;
    
    index()
    {
        initComp();
        setSize(500,500);
        
        jt.setModel(tm);
    }
    
    void initComp()
    {
        setLayout(null);
        
        al = new ArrayList<>();
        bt1 = new JButton("Load From DataBase");
        bt2 = new JButton("Load From SERVER");
        tm = new myTableModel();
        jt = new JTable();
        jsp = new JScrollPane(jt);
        
        bt1.setBounds(100, 20, 300, 50);
        bt2.setBounds(100, 100, 300, 50);
        jsp.setBounds(100, 200, 300, 200);
        
        add(bt1);
        add(bt2);
        add(jsp);
        
        // register bt with ActionListener
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    ///////////// INNER CLASS /////////////
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
            Student st = al.get(i);
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
            String col[] = {"Rollno", "Name", "Marks"};
            return col[j];
        }
    }
    ///////////////////////////////////////
    
    void loadFromDB()
    {
        try 
            {
                al.clear();
                String sql = ("select * from students");
                ResultSet rs = DBLoader.executeQuery(sql);
                
                int rollno;
                String name;
                int marks;
                
                while(rs.next())
                {
                    rollno = rs.getInt("rollno");
                    name = rs.getString("name");
                    marks = rs.getInt("marks");
                    
                    Student st = new Student(rollno, name, marks);
                    al.add(st);
                    tm.fireTableDataChanged();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
    }
    
    void loadFromServer()
    {
        try 
            {
                al.clear();
                HttpResponse<String> res =
                        Unirest.get("https://www.vmmeducation.com/vmmapi/getstudents").asString();
                if(res.getStatus()==200)
                {
                    String json = res.getBody();
                    JSONParser parser = new JSONParser();
                    JSONObject mainobj = (JSONObject) parser.parse(json);
                    JSONArray myarray = (JSONArray) mainobj.get("ans");
                    for(int i=0; i<myarray.size(); i++)
                    {
                        JSONObject singleobj = (JSONObject) myarray.get(i);
                        long rollno = (long) singleobj.get("rollno");
                        String name = (String) singleobj.get("name");
                        long marks = (long) singleobj.get("marks");
//                        System.out.println(rollno+"\t"+name+"\t"+marks);
                        Student st = new Student(rollno, name, marks);
                        al.add(st);
                        tm.fireTableDataChanged();
                    }
                    
                }
                
            } 
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
    }
    
    public static void main(String[] args) 
    {
        index obj = new index();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==bt1)
        {
            // DATABASE
            loadFromDB();
        }
        else if(e.getSource()==bt2)
        {
            // NETWORKING
            loadFromServer();
        }
    }
}