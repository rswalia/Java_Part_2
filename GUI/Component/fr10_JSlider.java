//JSlider
package GUI.Component;

import javax.swing.*;
import javax.swing.event.*;

public class fr10_JSlider extends JFrame implements ChangeListener
{
    JSlider js;
    JLabel lb;
    
    fr10_JSlider()
    {
        comp();
        
        js.setPaintTicks(true);
        js.setMinorTickSpacing(10);
        
        js.setPaintLabels(true);
        js.setMajorTickSpacing(20);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        setVisible(true);
    }
    
    void comp()
    {
        setLayout(null);
        
        js = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        lb = new JLabel("This is a Label");
        
        js.setBounds(100,100,300,50);
        lb.setBounds(100,150,300,50);
        
        add(js);
        add(lb);
        
        //register js with ChangeState Listener
        js.addChangeListener(this);
    }
    
    public static void main(String[] args) 
    {
        fr10_JSlider obj = new fr10_JSlider();
    }

    @Override
    public void stateChanged(ChangeEvent e) 
    {
        //logic
        int n = js.getValue();
        lb.setText(n+" DB");
    }
}