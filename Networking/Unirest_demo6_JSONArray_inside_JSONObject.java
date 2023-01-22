package Networking;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Unirest_demo6_JSONArray_inside_JSONObject
{
    public static void main(String[] args) 
    {
        try 
        {
            HttpResponse<String> res =
                    Unirest.get("https://www.vmmeducation.com/vmmapi/getstudents").asString();
            
            // Raw JSON
            String ans = res.getBody();
            System.out.println(ans);
            System.out.println("----------------------------------");
            
            // Create a JSON Parser
            JSONParser parser = new JSONParser();
            
            // First Extract main object from String
            JSONObject mainobj = (JSONObject) parser.parse(ans);
            
            // Now Extract JSONArray from main object
            JSONArray myarray = (JSONArray) mainobj.get("ans");
            
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