//JTextArea
package GUI.Component;

import java.awt.event.*;
import javax.swing.*;

public class fr12_JTextArea extends JFrame implements ActionListener
{
    JTextArea ta;
    JScrollPane sp;
    JTextField tf;
    JButton bt;
    
    fr12_JTextArea()
    {
        comp();
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        setVisible(true);
    }
    
    void comp()
    {
        setLayout(null);
        
        ta = new JTextArea();
        sp = new JScrollPane(ta);
        tf = new JTextField();
        bt = new JButton("Send");
        
        sp.setBounds(100,50,300,200);
        tf.setBounds(100,300,150,50);
        bt.setBounds(300,300,100,50);
        
        add(sp);
        add(tf);
        add(bt);
        
        ta.setEditable(false);
        
        //register bt with ActionListener
        bt.addActionListener(this);
    }
    
    public static void main(String[] args) 
    {
        fr12_JTextArea obj = new fr12_JTextArea();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        //Logic
        String s = tf.getText();
        ta.append("User : "+ s +"\n");
        tf.setText("");
        tf.requestFocus();
    }
}