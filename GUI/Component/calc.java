package GUI.Component;

import java.awt.*;
import java.awt.event.*;

public class calc extends Frame implements ActionListener
{
    TextField tf1,tf2,tf3;
    Button bt1,bt2,bt3,bt4;
    
    calc()
    {
        setLayout(null);
        
        //gives memory
        tf1 = new TextField();
        tf2 = new TextField();
        tf3 = new TextField();
        bt1 = new Button("Add");
        bt2 = new Button("Subtract");
        bt3 = new Button("Multiply");
        bt4 = new Button("Divide");
        
        tf1.setBounds(50, 120, 120, 50);
        tf2.setBounds(250, 120, 120, 50);
        tf3.setBounds(400, 120, 50, 50);
        bt1.setBounds(50, 250, 70, 70);
        bt2.setBounds(150, 250, 70, 70);
        bt3.setBounds(250, 250, 70, 70);
        bt4.setBounds(350, 250, 70, 70);
        
        add(tf1);
        add(tf2);
        add(tf3);
        add(bt1);
        add(bt2);
        add(bt3);
        add(bt4);
        
        //register all buttons with ActionListener
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt3.addActionListener(this);
        bt4.addActionListener(this);
        
        setTitle("Calculator");
        setSize(500,500);
        setVisible(true);
    }
    
    public static void main(String[] args) 
    {
        calc obj = new calc();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int a = Integer.parseInt(tf1.getText());
        int b = Integer.parseInt(tf2.getText());
        
        if(e.getSource() == bt1)
        {
            tf3.setText((a+b) + "");
            System.out.println(tf3);
        }
       
        else if(e.getSource() == bt2)
        {
            tf3.setText((a-b) + "");
            System.out.println(tf3);
        }
        else if(e.getSource() == bt3)
        {
            tf3.setText((a*b) + "");
            System.out.println(tf3);
        }
        else if(e.getSource() == bt4)
        {
            tf3.setText((a/b) + "");
            System.out.println(tf3);
        }
    }
}
