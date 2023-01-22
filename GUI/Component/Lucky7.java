package GUI.Component;

import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class Lucky7 extends JFrame implements ActionListener
{
    JLabel lb, lb1, lb2, lb3;
    JButton bt;
    
    Lucky7()
    {
        comp();
        
        lb.setFont(new Font("arial", Font.BOLD, 25));
        lb1.setFont(new Font("arial", Font.BOLD, 25));
        lb2.setFont(new Font("arial", Font.BOLD, 25));
        lb3.setFont(new Font("arial", Font.BOLD, 25));
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    void comp()
    {
        setLayout(null);
        
        lb = new JLabel("Lucky 7");
        lb1 = new JLabel("0");
        lb2 = new JLabel("0");
        lb3 = new JLabel("0");
        bt = new JButton("PLAY");
        
        lb.setBounds(150,50,200,50);
        lb1.setBounds(50,150,100,50);
        lb2.setBounds(225,150,100,50);
        lb3.setBounds(400,150,100,50);
        bt.setBounds(180,250,100,50);
        
        add(lb);
        add(lb1);
        add(lb2);
        add(lb3);
        add(bt);
        
        bt.addActionListener(this);
        
        setTitle("Lucky 7");
        setSize(500,500);
        setVisible(true);
    }
    
    public static void main(String[] args) 
    {
        Lucky7 obj = new Lucky7();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        int l=1, u=9;
        int num1 = (int)(l + (u-l)*Math.random());
        int num2 = (int)(l + (u-l)*Math.random());
        int num3 = (int)(l + (u-l)*Math.random());
        
        lb1.setText(num1 +"");
        lb2.setText(num2 +"");
        lb3.setText(num3 +"");
        
        // Three 7
        if(num1==7 && num2==7 && num3==7)
        {
            lb.setText("Jackpot");
        }
        // Two 7
        else if( (num1==7 && num2==7) || (num2==7 && num3==7) || (num1==7 && num3==7) )
        {
            lb.setText("You won $500");
        }
        // One 7
        else if( num1==7 || num2==7 || num3==7 )
        {
            lb.setText("You won $100");
        }
        // zero 7
        else
        {
            lb.setText("Try again");
        }
        
    }
}