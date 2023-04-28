package Anonymous_Inner_Class;

import java.awt.event.*;
import javax.swing.*;

public class Fr1 extends JFrame
{
    JButton bt1;
    JLabel lb1;
    
    Fr1()
    {
        initComp();
        
        // Anonymous Inner Class
//        bt1.addActionListener( new ActionListener() 
//        {
//            @Override
//            public void actionPerformed(ActionEvent e) 
//            {
//                //logic
//                lb1.setText(Math.random()+"");
//            }
//        } );
        
        // Lambda
        bt1.addActionListener((e) -> {
            //logic
            lb1.setText(Math.random()+"");
        });
    }
    
    void initComp()
    {
        setLayout(null);
        
        bt1 = new JButton("Click");
        lb1 = new JLabel("This is Label");
        
        bt1.setBounds(100, 100, 200, 30);
        lb1.setBounds(100, 150, 200, 30);
        
        add(bt1);
        add(lb1);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        setVisible(true);
    }
    
    public static void main(String[] args) 
    {
        Fr1 obj = new Fr1();
    }

//    @Override
//    public void actionPerformed(ActionEvent e) 
//    {
//        //logic
//        lb1.setText("Rohit");
//    }
}