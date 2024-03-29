package Networking;

import com.mashape.unirest.http.*;

public class Unirest_demo1_HTML 
{
    public static void main(String[] args) 
    {
        try 
        {
            HttpResponse<String> res = 
                    Unirest.get("https://www.vmmeducation.com/vmmapi/student/3").asString();  
            
            if(res.getStatus()==200) //correct url
            {
                System.out.println(res.getBody());
            }
            else //wrong url
            {
                System.out.println(res.getStatus()+" "+ res.getStatusText());
            }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}