package GUI;

import java.awt.*;

public class assignment_fr extends Frame
{

    assignment_fr()
    {
        setTitle("Assignment_1");
        setSize(500,500);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) 
    {
        g.setColor(Color.BLACK);
        g.drawOval(125, 50, 250, 400);//Face
        
        g.drawOval(185, 120, 50, 80);//left eye
        g.fillOval(195, 170, 30,30);//left eye circle
        
        g.drawOval(260, 120, 50, 80);//right eye
        g.fillOval(270, 170, 30,30);//right eye circle
        
        //Nose - polygon
        int x[] = {250,220,280};
        int y[] = {235,280,280};
        
        g.setColor(Color.MAGENTA);
        g.fillPolygon(x,y,3);
        
        //Arc
        g.setColor(Color.RED);
        g.drawArc(185, 230, 130, 130, 225, 90);
    }
  
    public static void main(String[] args) 
    {
        assignment_fr obj = new assignment_fr();
    }
}
