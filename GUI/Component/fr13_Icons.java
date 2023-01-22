package GUI.Component;

import javax.swing.*;

public class fr13_Icons extends JFrame
{
    JButton bt1, bt2;
    
    fr13_Icons()
    {
        initComp();
        
        bt1.setIcon(new ImageIcon("C:\\Users\\Asus\\Downloads\\icon1.png"));
        bt2.setIcon(new ImageIcon("C:\\Users\\Asus\\Downloads\\icon2.png"));
    }
    
    void initComp()
    {
        setLayout(null);
        
        bt1 = new JButton("Button 1");
        bt2 = new JButton("Button 2");
        
        bt1.setBounds(100,50,300,200);
        bt2.setBounds(100,300,300,200);
        
        add(bt1);
        add(bt2);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,600);
        setVisible(true);
    }
    
    public static void main(String[] args) 
    {
        fr13_Icons obj = new fr13_Icons();
    }
}