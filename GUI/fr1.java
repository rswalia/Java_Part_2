package GUI;

import java.awt.*;

public class fr1 extends Frame //Inheritance
{
    fr1() //Constructor
    {
        setTitle("This is a Frame");
        setSize(500,500);
        setVisible(true);
    }
    
    public static void main(String[] args)
    {
        fr1 obj = new fr1();
//        obj.setSize(500,500);
//        obj.setVisible(true);
//        obj.setTitle("Frame 1");
    }
}
