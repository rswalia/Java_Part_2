// SWINGS - 2 Buttons
package GUI.Component;

import java.awt.event.*;
import javax.swing.*;

public class fr4 extends JFrame implements ActionListener
{
    JTextField tf;
    JButton bt1, bt2;
    
    fr4()
    {
        setLayout(null);
        
        //gives memory
        tf = new JTextField();
        bt1 = new JButton("Bt1");
        bt2 = new JButton("Bt2");
        
        tf.setBounds(100, 100, 200, 50);
        bt1.setBounds(100, 200, 50, 50);
        bt2.setBounds(300, 200, 50, 50);
        
        add(tf);
        add(bt1);
        add(bt2);
        
        //register Buttons with ActionListener
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setTitle("SWINGS demo");
        setSize(500,500);
        setVisible(true);
    }
    
    public static void main(String[] args) 
    {
        fr4 obj = new fr4();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==bt1)
        {
            tf.setText("Button 1");
        }
        else if(e.getSource()==bt2)
        {
            tf.setText(Math.random()+"");
        }
    }
}