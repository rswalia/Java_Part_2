package Networking;

import com.mashape.unirest.http.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Unirest_demo3_JSON_Parsing 
{
    public static void main(String[] args) 
    {
        try 
        {
            HttpResponse<String> res =
                    Unirest.get("https://www.vmmeducation.com/vmmapi/student/3").asString();
            
            if(res.getStatus()==200)
            {
                String ans = res.getBody();
                
                //Raw JSON
                System.out.println(ans);
                System.out.println("--------------------------------------");
                
                // Create a JSON Parser
                JSONParser parser = new JSONParser();
                
                // Extract JSONObject from String
                JSONObject mainobj = (JSONObject) parser.parse(ans);
                
                // Use in Java
                long rollno = (long) mainobj.get("rollno");
                String name = (String) mainobj.get("name");
                long marks = (long) mainobj.get("marks");
                String photo = (String) mainobj.get("photo");
                
                System.out.println(rollno);
                System.out.println(name);
                System.out.println(marks);
                System.out.println(photo);
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