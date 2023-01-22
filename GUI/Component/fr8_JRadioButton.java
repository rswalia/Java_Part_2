//JRadioButton (label - color)
package GUI.Component;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class fr8_JRadioButton extends JFrame implements ItemListener
{
    JLabel lb;
    JRadioButton r1, r2, r3;
    ButtonGroup grp;
    
    fr8_JRadioButton()
    {
        comp();
        
        //register radiobuttons with ItemListener
        r1.addItemListener(this);
        r2.addItemListener(this);
        r3.addItemListener(this);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        setVisible(true);
    }
    
    void comp()
    {
        setLayout(null);
        
        //gives memory
        lb = new JLabel("This is a Label");
        r1 = new JRadioButton("Red");
        r2 = new JRadioButton("Pink");
        r3 = new JRadioButton("Blue");
        grp = new ButtonGroup();
        
        r1.setBounds(100,100,200,30);
        r2.setBounds(100,150,200,30);
        r3.setBounds(100,200,200,30);
        lb.setBounds(100,250,200,30);
        
        add(r1);
        add(r2);
        add(r3);
        add(lb);
        grp.add(r1);
        grp.add(r2);
        grp.add(r3);    
    }
    
    public static void main(String[] args) 
    {
        fr8_JRadioButton obj = new fr8_JRadioButton();
    }

    @Override
    public void itemStateChanged(ItemEvent e) 
    {
        if(e.getSource()==r1)
        {
            lb.setForeground(Color.RED);
        }
        else if(e.getSource()==r2)
        {
            lb.setForeground(Color.PINK);
        }
        else if(e.getSource()==r3)
        {
            lb.setForeground(Color.BLUE);
        }
    }
}