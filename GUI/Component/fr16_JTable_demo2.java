package GUI.Component;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class fr16_JTable_demo2 extends JFrame
{
    //source of data (ArrayList)
    ArrayList<Student> al;
    
    myTableModel tm;
    JTable jt;
    JScrollPane jsp;
    
    fr16_JTable_demo2()
    {   
        initComp();
        setSize(500,500);
        
        //attach JTable with TableModel
        jt.setModel(tm);
        
        // refresh
        tm.fireTableDataChanged();
    }
    
    void initComp()
    {
        setLayout(null);
        
        // gives memory
        al = new ArrayList<>();
        tm = new myTableModel();
        jt = new JTable();
        jsp = new JScrollPane(jt);
        
        // set Bounds
        jsp.setBounds(50,100,300,200);
        
        // add
        add(jsp);
        al.add(new Student(1,"abc",90));
        al.add(new Student(2,"xyz",86));
        al.add(new Student(3,"def",37));
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        setVisible(true);
    }
    
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
            String col[] = {"RollNo","Name","Marks"};
            return col[j];
        }
    }
    
    public static void main(String[] args)
    {
        fr16_JTable_demo2 obj = new fr16_JTable_demo2();
    }
}