package JDBC;

import java.util.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.sql.*;

public class JDBC_JTable_ArrayList extends JFrame
{
    ArrayList<Student> al;
    JTable jt;
    JScrollPane jsp;
    myTableModel tm;
    
    JDBC_JTable_ArrayList()
    {
        initComp();
        setSize(500,500);
        
        // attach TableModel with JTable
        jt.setModel(tm);
        
        loadDataFromDB();
    }
    
    void initComp()
    {
        setLayout(null);
        
        // give memory
        al = new ArrayList<>();
        tm = new myTableModel();
        jt = new JTable();
        jsp = new JScrollPane(jt);
        
        // set Bounds
        jsp.setBounds(100, 100, 300, 200);
        
        // add
        add(jsp);
//        al.add(new Student(1,"Rohit",92));
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
   
    ///////////// INNER CLASS /////////////////////
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
    
    void loadDataFromDB()
    {
        try 
        {
            String sql = "select * from students";
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
                
                // refresh
                tm.fireTableDataChanged();
                
                Thread.sleep(1000);
            }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) 
    {
        JDBC_JTable_ArrayList obj = new JDBC_JTable_ArrayList();
    }
}