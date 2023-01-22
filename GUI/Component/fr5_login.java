package GUI.Component;

import java.awt.event.*;
import javax.swing.*;

public class fr5_login extends JFrame implements ActionListener
{
    JLabel lb1, lb2;
    JTextField tf;
    JPasswordField pf;
    JButton bt;
    
    fr5_login()
    {
        setLayout(null);
        
        //gives memory
        lb1 = new JLabel("Username");
        lb2 = new JLabel("Password");
        tf = new JTextField();
        pf = new JPasswordField();
        bt = new JButton("LOGIN");
        
        
        lb1.setBounds(100,100,200,30);
        lb2.setBounds(100,150,100,30);
        tf.setBounds(200,100,200,30);
        pf.setBounds(200,150,200,30);
        bt.setBounds(200,200,200,30);
        
        add(lb1);
        add(lb2);
        add(tf);
        add(pf);
        add(bt);
        
        //register Button with ActionListener
        bt.addActionListener(this);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setTitle("Login Form");
        setSize(500,500);
        setVisible(true);
        
//        pf.requestFocus();
    }
    
    public static void main(String[] args) 
    {
        fr5_login obj = new fr5_login();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        //Logic
        String u = tf.getText();
        String p = pf.getText();
        
        if(u.equals("abc") && p.equals("123"))
        {
            JOptionPane.showMessageDialog(this, "Login Successfull !!!");
        }
        else
        {
            JOptionPane.showMessageDialog(this, "*** Login failed ***");
        }
    }
}