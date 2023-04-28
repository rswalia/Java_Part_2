package Networking;

import com.mashape.unirest.http.*;
import java.util.StringTokenizer;

public class Unirest_demo9_Own_Server2
{
    public static void main(String[] args) 
    {
        try 
        {
            HttpResponse<String> res = Unirest.get("http://127.0.0.1:80/three").asString();
            
            if(res.getStatus()==200)
            {
                String ans = res.getBody();
                
                StringTokenizer st = new StringTokenizer(ans,";"); // seperate at ;
                
            int n = st.countTokens();
                
                for(int i=1; i<=n; i++)
                {
                    String single = st.nextToken();
                    System.out.println(single);
                }
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}