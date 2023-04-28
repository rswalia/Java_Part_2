package Project_2_POS;

import java.sql.*;

public class DBLoader_POS
{
    public static ResultSet executeQuery(String sql) throws Exception
    {
        /////////////// ##Code //////////////////
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully....");
            
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/pos","root","System123@");
            System.out.println("Connection made successfully....");
            
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  
                     ResultSet.CONCUR_UPDATABLE);   
            System.out.println("Statement successfully....");
            
            ResultSet rs=stmt.executeQuery(sql); 
            System.out.println("ResultSet successfully....");
            /////////////// ##Code Ends //////////////////
            return rs;
    }
}