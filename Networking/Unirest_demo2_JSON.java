package Networking;

import com.mashape.unirest.http.*;

public class Unirest_demo2_JSON 
{
    public static void main(String[] args)
    {
        try 
        {
            HttpResponse<String> res =
                    Unirest.get("https://www.vmmeducation.com/vmmapi/student/3").asString();
            
            if(res.getStatus()==200)
            {
                System.out.println(res.getBody());
            }
            else
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