package Exception_Handling;

import java.util.*;

public class demo2 
{
    public static void main(String[] args) 
    {
        int a,b,c;
        
        Scanner sc = new Scanner(System.in);
        
        for(int i=1; i<=5; i++)
        {
            try 
            {
               System.out.println("Enter two numbers");
                a = sc.nextInt();
                b = sc.nextInt();
            
                c = a/b;
        
                System.out.println("Answer is "+ c); 
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
    }
}