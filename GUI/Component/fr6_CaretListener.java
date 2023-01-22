//Typing - CaretListener
package GUI.Component;

import javax.swing.*;
import javax.swing.event.*;

public class fr6_CaretListener extends JFrame implements CaretListener
{
    JTextField tf;
    JLabel lb;
    
    fr6_CaretListener()
    {
        setLayout(null);
        
        //gives memory
        tf = new JTextField();
        lb = new JLabel("This is a Label");
        
        tf.setBounds(100,100,200,30);
        lb.setBounds(100,150,200,30);
        
        add(tf);
        add(lb);
        
        //register JTextField with CaretListener
        tf.addCaretListener(this);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Typing - CaretListener");
        setSize(500,500);
        setVisible(true);
    }
    
    public static void main(String[] args) 
    {
        fr6_CaretListener obj = new fr6_CaretListener();
    }

    @Override
    public void caretUpdate(CaretEvent e) 
    {
        //logic
        String s = tf.getText();
        lb.setText(s);
    }
}