package Networking;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Unirest_demo5_JSONArray 
{
    public static void main(String[] args) 
    {
        try 
        {
            HttpResponse<String> res =
                    Unirest.get("https://www.vmmeducation.com/vmmapi/allstudents").asString();
            
            // Raw JSON
            String ans = res.getBody();
            System.out.println(ans);
            System.out.println("----------------------------------");
            
            // Create a JSON Parser
            JSONParser parser = new JSONParser();
            
            // Extract JSONArray from String
            JSONArray myarray = (JSONArray) parser.parse(ans);
            
            for(int i=0; i<myarray.size(); i++)
            {
                JSONObject singleobj = (JSONObject) myarray.get(i);
//                System.out.println(singleobj);

                // use members of singleobj
                long rollno = (long) singleobj.get("rollno");
                String name = (String) singleobj.get("name");
                long marks = (long) singleobj.get("marks");
                String photo = (String) singleobj.get("photo");
                
                System.out.println(rollno +"\t"+ name +"\t"+ marks +"\t"+ photo);
                System.out.println("-----------------------------------------");
            }
           
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}