package GUI.Component;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class fr17_JTable_demo3 extends JFrame implements ActionListener
{
    JTextField tf1, tf2, tf3;
    JButton bt;
    JTable jt;
    JScrollPane jsp;
    ArrayList<Student2> al;
    myTableModel tm;
    
    fr17_JTable_demo3()
    {
        initComp();
        setSize(500,500);
        
        al.add(new Student2(1,"abc",90));
        
        // attach JTable with TableModel
        jt.setModel(tm);
        
    }
    
    void initComp()
    {
        setLayout(null);
        
        // gives memory
        al = new ArrayList<>();
        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        bt = new JButton("ADD");
        jt = new JTable();
        jsp = new JScrollPane(jt);
        tm = new myTableModel();
        
        // set Bounds
        tf1.setBounds(50, 50, 100, 50);
        tf2.setBounds(200, 50, 100, 50);
        tf3.setBounds(350, 50, 100, 50);
        bt.setBounds(200, 150, 100, 30);
        jsp.setBounds(50, 200, 400, 200);
        
        // add
        add(tf1);
        add(tf2);
        add(tf3);
        add(bt);
        add(jsp);
//        al.add(new Student2(1,"abc",90));
        
        // register bt with ActionListener
        bt.addActionListener(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        int rollno = Integer.parseInt(tf1.getText());
        String name = tf2.getText();
        int marks = Integer.parseInt(tf3.getText());
        
        Student2 st = new Student2(rollno, name, marks);
        al.add(st);
        
        System.out.println("Added to List");
        
        // refresh
        tm.fireTableDataChanged();
        
        tf1.requestFocus();
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
    //////////////////////////////
    
    public static void main(String[] args) 
    {
        fr17_JTable_demo3 obj = new fr17_JTable_demo3();
    }
}