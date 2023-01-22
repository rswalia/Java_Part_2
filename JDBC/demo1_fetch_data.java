package JDBC;

import java.sql.*;

public class demo1_fetch_data 
{
    public static void main(String[] args) 
    {
        try
        {
            ResultSet rs = DBLoader.executeQuery("select * from students");
            
            //Fetch data from Database
            int rollno;
            String name;
            int marks;
            
            while(rs.next())
            {
                rollno = rs.getInt("rollno");
                name = rs.getString("name");
                marks = rs.getInt("marks");
                System.out.println("rollno: "+ rollno +"\tname: "+ name +"\tmarks: "+ marks);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}