package GUI;

import java.awt.*;

public class fr2 extends Frame
{
    public fr2()
    {
        setTitle("Drawing Line");
        setSize(500,500);
        setVisible(true);
    }
    
    @Override
    public void paint(Graphics g)
    {
        g.setColor(Color.RED);
        g.drawLine(100, 100, 300, 300);
        
        g.setColor(Color.BLUE);
        g.drawLine(300, 100, 100, 300);
        
        g.setColor(Color.magenta);
        for(int i=1; i<=10; i++)
        {
            g.drawLine(100+(10*i), 100, 300+(10*i), 300);
        }
    }
    
    public static void main(String[] args)
    {
        fr2 obj = new fr2();
    }
}
