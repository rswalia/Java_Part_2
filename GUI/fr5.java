package GUI;

import java.awt.*;

public class fr5 extends Frame
{
    fr5()
    {
        setSize(500,500);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        //Polygon
        int x[] = {100,250,150,400};
        int y[] = {50,200,425,300};
        g.fillPolygon(x,y,4);
    }
    
    public static void main(String[] args) 
    {
        fr5 obj = new fr5();
    }
}
