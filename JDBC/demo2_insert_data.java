package JDBC;

import java.sql.*;

public class demo2_insert_data
{
    public static void main(String[] args) 
    {
        try
        {
            //Insert data into Database
            int rollno = 10;
            String name = "qwerty";
            int marks = 27;
            
            //Duplicacy Check for primary key
            ResultSet rs= DBLoader.executeQuery("select * from students where rollno= "+ rollno);
            
            if(rs.next())//if line comes for rollno="";
            {
                System.out.println("DUPLICACY FOUND...This rollno already exist");
            }
            else
            {
                rs.moveToInsertRow(); //create empty row
            
                //fill row
                rs.updateInt("rollno", rollno);
                rs.updateString("name", name);
                rs.updateInt("marks", marks);

                rs.insertRow();

                System.out.println("Inserted successfully...");
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}