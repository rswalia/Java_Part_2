//Event Handling
package GUI.Component;

import java.awt.*;
import java.awt.event.*;

public class fr2 extends Frame implements ActionListener
{
    TextField tf;
    Button bt;
    
    fr2()
    { 
        setLayout(null);
        
        tf = new TextField();//gives memory
        bt = new Button("Click Me");

        tf.setBounds(100,100,150,50);
        bt.setBounds(150, 200, 50, 50);

        add(tf);
        add(bt);
        
        //register bt with ActionListener
        bt.addActionListener(this);

        setSize(500,500);
        setVisible(true);
    }
    
    public static void main(String[] args) 
    {
        fr2 obj = new fr2();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) //actionListener
    {
        //logic
        tf.setText("Hello World");
//        tf.setText(Math.random() + "");

//        int l=1,u=100;
//        int n = (int)(l+(u-l)*Math.random());
//        tf.setText(n + "");
    }
}