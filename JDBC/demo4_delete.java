package JDBC;

import java.sql.*;

public class demo4_delete
{
    public static void main(String[] args) 
    {
        try
        {
            int en = 2;
            
            ResultSet rs = DBLoader.executeQuery("select * from emp where eno="+en);
            
            if(rs.next())
            {
                rs.deleteRow();
                
                System.out.println("** Record Deleted **");
            }
            else
            {
                System.out.println("** enter valid EmpNo **");
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}