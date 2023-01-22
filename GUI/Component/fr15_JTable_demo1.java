package GUI.Component;

import javax.swing.*;
import javax.swing.table.*;

public class fr15_JTable_demo1 extends JFrame
{
    //source of data (Array)
    String a[][] = {
                    {"1","abc","90"},
                    {"1","abc","90"},
                    {"1","abc","90"},
                    {"1","abc","90"},
                    {"1","abc","90"},
                    };
    myTableModel tm;
    JTable jt;
    JScrollPane jsp;
    
    fr15_JTable_demo1()
    {
        initComp();
        
        //attach JTable with TableModel
        jt.setModel(tm);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        setVisible(true);
    }
    
    void initComp()
    {
        setLayout(null);
        
        tm = new myTableModel(); //give memory to TableModel
        jt = new JTable();
        jsp = new JScrollPane(jt);
        
        jsp.setBounds(100,100,300,200);
        
        add(jsp);
    }
    
    /////// Inner class ////////
    class myTableModel extends AbstractTableModel
    {

        @Override
        public int getRowCount() 
        {
            return a.length;
        }

        @Override
        public int getColumnCount() 
        {
            return 3;
        }

        @Override
        public Object getValueAt(int i, int j) 
        {
            return a[i][j];
        }

        @Override
        public String getColumnName(int j) 
        {
            String col[] = {"Roll No","Name","Marks"};
            return col[j];
        }
    }
    
    public static void main(String[] args)
    {
        fr15_JTable_demo1 obj = new fr15_JTable_demo1();
    }
}