package GUI.Component;

import java.awt.Image;
import javax.swing.*;

public class fr13_Icons extends JFrame
{
    JButton bt1, bt2;
    
    fr13_Icons()
    {
        initComp();
        
        bt1.setIcon(new ImageIcon("C:\\Users\\Asus\\Downloads\\icon1.png"));
//        bt2.setIcon(new ImageIcon("C:\\Users\\Asus\\Downloads\\icon2.png"));

        ImageIcon img = new ImageIcon("C:\\Users\\Asus\\Downloads\\icon2.png");
        Image img1 = img.getImage().getScaledInstance(bt2.getWidth(), bt2.getHeight(), Image.SCALE_SMOOTH);
//        ImageIcon img2 = new ImageIcon(img1);
        bt2.setIcon(new ImageIcon(img1));
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