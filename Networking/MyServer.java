package Networking;

import JDBC.DBLoader;
import com.vmm.JHTTPServer;
import java.util.Date;
import java.util.Properties;
import JDBC.DBLoader;
import java.sql.*;

public class MyServer extends JHTTPServer
{
    public static void main(String[] args) throws Exception 
    {
        try
        {
            MyServer obj = new MyServer(80);
            
            Thread.sleep(100000);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    public Response serve(String uri, String method, Properties header, Properties parms, Properties files) 
    {
        if(uri.equals("/"))
        {
            // logic
            String ans = "Hello Rohit";

            // send response
            return (new Response(HTTP_OK, "text/plain", ans));
        }
        else if(uri.equals("/one"))
        {
            String ans = Math.random()+"";
            return (new Response(HTTP_OK, "text/plain", ans));
        }
        else if(uri.equals("/two"))
        {
            String ans = new Date().toString();
            return (new Response(HTTP_OK, "text/plain", ans));
        }
        else if(uri.equals("/three"))
        {
            try
            {
                ResultSet rs = DBLoader.executeQuery("select * from students");
                
                String ans = "";
                
                while(rs.next())
                {
                    int rollno = rs.getInt("rollno");
                    String name = rs.getString("name");
                    int marks = rs.getInt("marks");
                    
                    ans = ans + rollno+","+name+","+marks+";";
                }  
                return (new Response(HTTP_OK, "text/plain", ans));
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        return null;
    }
    
    public MyServer(int port) throws Exception 
    {
        super(port);
    }
}