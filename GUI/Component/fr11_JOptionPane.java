//JOptionPane
package GUI.Component;

import java.awt.event.*;
import javax.swing.*;

public class fr11_JOptionPane extends JFrame implements ActionListener
{
    JButton bt1, bt2, bt3;
    JLabel lb;
    
    fr11_JOptionPane()
    {
        comp();
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700,500);
        setVisible(true);
    }
    
    void comp()
    {
        setLayout(null);
        
        bt1 = new JButton("Message Dialog");
        bt2 = new JButton("Input Dialog");
        bt3 = new JButton("Confirm Dialog");
        lb = new JLabel("This is Label");
        
        bt1.setBounds(20,100,150,50);
        bt2.setBounds(220,100,150,50);
        bt3.setBounds(420,100,150,50);
        lb.setBounds(50,200,150,50);
        
        add(bt1);
        add(bt2);
        add(bt3);
        add(lb);
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt3.addActionListener(this);
    }
    
    public static void main(String[] args) 
    {
        fr11_JOptionPane obj = new fr11_JOptionPane();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==bt1)
        {
            JOptionPane.showMessageDialog(this, "Hello World");
        }
        else if(e.getSource()==bt2)
        {
            String s = JOptionPane.showInputDialog("Enter your name");
            lb.setText(s);
        }
        else if(e.getSource()==bt3)
        {
            int ans = JOptionPane.showConfirmDialog(this, 
                                                    "Are you sure you want to delete", 
                                                    "Delete Confirmation",
                                                    JOptionPane.YES_NO_OPTION);
            if(ans==JOptionPane.YES_OPTION)
            {
                lb.setText("Deleted");
            }
            else
            {
                lb.setText("Ignored");
            }
        }
    }
}