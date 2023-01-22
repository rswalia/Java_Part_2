package GUI.Component;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class krishnam extends JFrame implements ActionListener,ItemListener
{
    JTextField tf1;
    JTextField tf2;
    JTextField tf3;
    JPasswordField tf4;
    JButton bt1;
    JCheckBox c1;
    JRadioButton r1,r2,r3,r4;
    ButtonGroup grp;
    JLabel lb1,lb2,lb3,lb4,lb6;
    JProgressBar jp;
    

krishnam() 
{
    setLayout(null);
    
    comp();
        
    setTitle("Fee column ");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(1500,1500);
    setVisible(true);
        
    moveBar();
}
    
    void comp()
    {
        tf1= new JTextField();
    tf2= new JTextField();
    tf3= new JTextField();
    tf4= new JPasswordField();
lb1= new JLabel("name");
lb2= new JLabel("year");
lb3= new JLabel("student id");
lb4= new JLabel("password");
lb6= new JLabel();
c1= new JCheckBox("semester");
r1= new JRadioButton("1st");
r2= new JRadioButton("2nd");
r3= new JRadioButton("3rd");
r4= new JRadioButton("4th");
grp= new ButtonGroup();
bt1= new JButton("submit");
jp= new JProgressBar(JProgressBar.HORIZONTAL,0,100);
    
tf1.setBounds(200,100,200,30);
tf2.setBounds(200,150,200,30);
tf3.setBounds(200,450,200,30);
tf4.setBounds(200,500,200,30);
c1.setBounds(200,200,200,30);
r1.setBounds(300,250,200,30);
r2.setBounds(300,300,200,30);
r3.setBounds(300,350,200,30);
r4.setBounds(300,400,200,30);
bt1.setBounds(100,550,200,30);
lb1.setBounds(100,100,200,30);
lb2.setBounds(100,150,200,30);
lb6.setBounds(500,0,500,100);
lb6.setFont(new Font("arial", Font.BOLD, 30));
lb3.setBounds(100,450,200,30);
lb4.setBounds(100,500,200,30);
jp.setBounds(600,300, 400, 70);
jp.setValue(0);
jp.setStringPainted(true);
jp.setString("% completed");
jp.setForeground(Color.green);
jp.setBackground(Color.white);
grp.add(r1);
grp.add(r2);
grp.add(r3);
grp.add(r4);

        add(lb1);
        add(lb2);
        add(lb3);
        add(lb4);
        add(c1);
        add(r1);
        add(r2);
        add(r3);
        add(r4);
        add(tf1);
        add(tf2);
        add(tf3);
        add(tf4);
        add(lb6);
        add(bt1);
        add(jp);
        bt1.addActionListener(this);
        c1.addItemListener(this);
        r1.setVisible(false);
        r2.setVisible(false);
        r3.setVisible(false);
        r4.setVisible(false);
    }

    void moveBar()
    {
        //Move Progress Bar
        for(int i=0;i<=100;i++)
        {
           jp.setValue(i);
           jp.setString(i +" %completed");
           try 
           {
                {
                   Thread.sleep(20);
                }
           } 
           catch (Exception ex) 
           {
               ex.printStackTrace();
           }
        }
            jp.setVisible(false);
           
                    
          String s= JOptionPane.showInputDialog(this, "enter name");
          while (true){
          if(s.isEmpty())
          {
            JOptionPane.showMessageDialog(this, "enter name");
            s= JOptionPane.showInputDialog(this, "enter name");
          }
         
          else{
          lb6.setText("Welcome  " + s);
          }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        JOptionPane.showConfirmDialog(this, "do you want to submit");
        String u=tf3.getText();
        String f=tf4.getText();
        
        if(tf1.getText().isEmpty()||tf2.getText().isEmpty()||u.isEmpty()||f.isEmpty()||!c1.isSelected()||!r1.isSelected()&&!r2.isSelected()&&!r3.isSelected()&&!r4.isSelected())
        {
            JOptionPane.showMessageDialog(this, "enter the credentials");
        }
       
        if(u.equals("krishnam")&&f.equals("123"))
        {
         
            JOptionPane.showMessageDialog(this, "login successful");
        }
        else
        {
           
            JOptionPane.showMessageDialog(this, "login unsuccessful");
        }
    }
    
    public void itemStateChanged(ItemEvent e)
    {
        if(c1.isSelected())
        {
            r1.setVisible(true);
            r2.setVisible(true);
            r3.setVisible(true);
            r4.setVisible(true);
        }
        else
        {
            r1.setVisible(false);
            r2.setVisible(false);
            r3.setVisible(false);
            r4.setVisible(false);
        }
    }
    
    public static void main(String[] args) 
    {
        krishnam obj= new krishnam();
    }
}