package JDBC;

import java.sql.*;

public class demo3_update 
{
    public static void main(String[] args) 
    {
        try
        {
            int en = 2;
            String enm = "Rohit";
            int sal = 5000;
            
            ResultSet rs = DBLoader.executeQuery("select * from emp where eno="+en);
            
            if(rs.next())
            {
                rs.updateString("enam", enm);
                rs.updateInt("salary", sal);
                
                rs.updateRow();
                
                System.out.println("** Record Updated **");
            }
            else
            {
                System.out.println("** Enter valid EmpNo **");
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}