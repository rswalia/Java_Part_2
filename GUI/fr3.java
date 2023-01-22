package GUI;

import java.awt.*;

public class fr3 extends Frame
{
    public fr3()
    {
        setTitle("Drawing Rectangle");
        setSize(500,500);
        setVisible(true);
    }
    
    @Override
    public void paint(Graphics g)
    {
        g.setColor(Color.RED);
        g.drawRect(100, 100, 300, 150);
        
        for(int i=0; i<=15; i++)
        {
            g.drawLine(100+(10*i),100,250+(10*i),250);
        }
        
        g.setColor(Color.BLUE);
        g.fillRect(100, 300, 300, 150);
    }
    
    public static void main(String[] args) 
    {
        fr3 obj = new fr3();
    }
}
