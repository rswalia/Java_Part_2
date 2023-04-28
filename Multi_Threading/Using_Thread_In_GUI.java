package Multi_Threading;

import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Using_Thread_In_GUI extends JFrame implements ActionListener
{
    JLabel lb1, lb2;
    JButton bt1, bt2;
    
    Using_Thread_In_GUI()
    {
        initComp();
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
    }
    
    void initComp()
    {
        setLayout(null);
        
        bt1 = new JButton("bt1");
        bt2 = new JButton("bt2");
        lb1 = new JLabel("lb1");
        lb2 = new JLabel("lb2");
        
        bt1.setBounds(100, 200, 100, 50);
        bt2.setBounds(300, 200, 100, 50);
        lb1.setBounds(100, 150, 100, 50);
        lb2.setBounds(300, 150, 100, 50);
        
        add(bt1);
        add(bt2);
        add(lb1);
        add(lb2);
        
        setVisible(true);
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) 
    {
        Using_Thread_In_GUI obj = new Using_Thread_In_GUI();
    }

    // Inner Class
    class myJob implements Runnable
    {
        @Override
        public void run() 
        {
            for(int i=1; i<=200; i++)
            {
                lb2.setText(i+"");
                
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Using_Thread_In_GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            bt2.setEnabled(true);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==bt1)
        {
            lb1.setText(Math.random()+"");
        }
        else if(e.getSource()==bt2)
        {
            myJob jb = new myJob();
            Thread t = new Thread(jb);
            t.start();
            bt2.setEnabled(false);
        }
    }
}