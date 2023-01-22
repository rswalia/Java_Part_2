// 2 buttons
package GUI.Component;

import java.awt.*;
import java.awt.event.*;

public class fr3 extends Frame implements ActionListener
{
    TextField tf;
    Button bt1,bt2;
    
    fr3()
    { 
        setLayout(null);
        
        tf = new TextField();//gives memory
        bt1 = new Button("Bt1");
        bt2 = new Button("Bt2");

        tf.setBounds(100,100,150,100);
        bt1.setBounds(70, 250, 50, 50);
        bt2.setBounds(200, 250, 50, 50);

        add(tf);
        add(bt1);
        add(bt2);
        
        //register bt1 & bt2 with ActionListener
        bt1.addActionListener(this);
        bt2.addActionListener(this);

        setSize(500,500);
        setVisible(true);
    }
    
    public static void main(String[] args) 
    {
        fr3 obj = new fr3();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //logic
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