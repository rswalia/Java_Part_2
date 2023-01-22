package GUI;

import java.awt.*;

public class fr4 extends Frame
 {
    fr4()
    {
        setSize(500,500);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g)
    {
        //square oval circle arc polygon
        g.setColor(Color.RED);//square
        g.drawRect(50, 50, 100, 100);
        
        g.setColor(Color.GREEN);//oval
        g.drawOval(50, 250, 150, 50);
        
        g.setColor(Color.ORANGE);//circle
        g.drawOval(250, 50, 100, 100);
        
        g.setColor(Color.darkGray);//Arc
        g.fillArc(250,250,100,100,0,90);
        
        g.fillArc(200, 300, 100, 100, 45, 90);//swipe angle
        
    }
    
    public static void main(String[] args) 
    {
        fr4 obj = new fr4();
    }
}
