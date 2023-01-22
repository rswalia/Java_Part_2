package GUI.Component;

import java.awt.*;

public class fr1 extends Frame
{
    TextField tf;
    Button bt;
    
    fr1()
    {
        setLayout(null);
        
        tf = new TextField();//gives memory
        bt = new Button("Click Me");
        
        tf.setBounds(100,100,250,30);
        bt.setBounds(200, 200, 60, 60);
        
        add(tf);
        add(bt);
        
        setSize(500,500);
        setVisible(true);
    }
    
    public static void main(String[] args) 
    {
        fr1 obj = new fr1();
    }
}