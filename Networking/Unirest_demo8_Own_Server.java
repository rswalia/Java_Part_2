package Networking;

import com.mashape.unirest.http.*;

public class Unirest_demo8_Own_Server 
{
    public static void main(String[] args) 
    {
        try 
        {
            HttpResponse<String> res = Unirest.get("http://127.0.0.1:80/three").asString();
            
            if(res.getStatus()==200)
            {
                System.out.println(res.getBody());
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}