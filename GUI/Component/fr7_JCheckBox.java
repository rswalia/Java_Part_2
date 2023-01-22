//JCheckBox  (tick = Visible)
package GUI.Component;

import java.awt.event.*;
import javax.swing.*;

public class fr7_JCheckBox extends JFrame implements ItemListener
{
    JTextField tf;
    JCheckBox ch;
    
    fr7_JCheckBox()
    {
        setLayout(null);
        
        //gives memory
        tf = new JTextField();
        ch = new JCheckBox("Show");
        
        tf.setBounds(100,100,200,30);
        ch.setBounds(100,150,200,30);
        
        add(tf);
        add(ch);
        
        //register JCheckBox with ItemListener
        ch.addItemListener(this);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("JCheckBox");
        setSize(500,500);
        setVisible(true);
        
//        ch.setEnabled(false);
    }
    
    public static void main(String[] args) 
    {
        fr7_JCheckBox obj = new fr7_JCheckBox();
    }

    @Override
    public void itemStateChanged(ItemEvent e) 
    {
        //logic
        if(ch.isSelected())
        {
            tf.setVisible(true);//tick
        }
        else
        {
            tf.setVisible(false);//untick
        }
    }
}