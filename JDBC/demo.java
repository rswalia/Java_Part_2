/*
select
insert
update
delete
*/
package JDBC;

import java.sql.*;

public class demo 
{
    public static void main(String[] args) 
    {
//          -- SELECT --
//        /*
        try 
        {
            int rollno;
            String name;
            int marks;
            
            String sql = "select * from demo1";
            ResultSet rs = DBLoader.executeQuery(sql);
            
            while(rs.next())
            {
                rollno = rs.getInt("rollno");
                name = rs.getString("name");
                marks = rs.getInt("marks");
                System.out.println(rollno+"\t"+name+"\t"+marks);
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
//        */
//          -- INSERT --
        /*
        try 
        {
            int rollno = 10;
            String name = "Harsh";
            int marks = 69;

            String sql = "select * from demo1 where rollno="+rollno;
            ResultSet rs = DBLoader.executeQuery(sql);
                
            if(rs.next())
            {
                System.out.println("** DUPLICACY FOUND **");
            }
            else
            {
                rs.moveToInsertRow();
                    
                rs.updateInt("rollno", rollno);
                rs.updateString("name", name);
                rs.updateInt("marks", marks);
                    
                rs.insertRow();
                    
                System.out.println("** Inserted Successfully **");
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        */
        
//        -- UPDATE --
        /*
        try 
        {
            int rollno = 5;
            
            String sql = "select * from demo1 where rollno="+rollno;
            ResultSet rs = DBLoader.executeQuery(sql);
            
            if(rs.next())
            {
                rs.updateString("name", "madhav");
                rs.updateInt("marks", 18);
                
                rs.updateRow();
                
                System.out.println("** Row Updated Successfully **");
            }
            else
            {
                System.out.println("** Invalid rollno **");
            }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        */
        
//        -- DELETE --
        /*
        try 
        {
            int rollno = 5;
            
            String sql = "select * from demo1 where rollno="+rollno;
            ResultSet rs = DBLoader.executeQuery(sql);
            
            if(rs.next())
            {
                rs.deleteRow();
                
                System.out.println("** Row Deleted Successfully **");
            }
            else
            {
                System.out.println("** Invalid rollno **");
            }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        */
            
    }
}