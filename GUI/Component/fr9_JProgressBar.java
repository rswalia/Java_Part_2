//JProgressBar
package GUI.Component;

import java.awt.Color;
import javax.swing.*;

public class fr9_JProgressBar extends JFrame
{
    JProgressBar pbar;
    
    fr9_JProgressBar()
    {
        comp();
        
        pbar.setValue(0);
        
        pbar.setStringPainted(true);
//        pbar.setString("Loading");
        
        pbar.setBackground(Color.white);
        pbar.setForeground(Color.red);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        setVisible(true);
        
        //Move Progress Bar
        for(int i=1; i<=100; i++)
        {
            pbar.setValue(i);
            pbar.setString(i +" % Completed");
            try
            {
                Thread.sleep(100);
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        JOptionPane.showMessageDialog(this, "Done");
    }
    
    void comp()
    {
        setLayout(null);
        
        //gives memory
        pbar = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);
        
        pbar.setBounds(100,100,200,50);
        
        add(pbar);
    }
    
    public static void main(String[] args) 
    {
        fr9_JProgressBar obj = new fr9_JProgressBar();
    }
}