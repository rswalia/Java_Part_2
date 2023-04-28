package Exception_Handling;

import java.util.*;

public class demo1 
{
    public static void main(String[] args) throws Exception
    {
        int a,b,c;
        
        Scanner sc = new Scanner(System.in);
        
        for(int i=1; i<=5; i++)
        {
            System.out.println("Enter two numbers");
            a = sc.nextInt();
            b = sc.nextInt();
        
            c = a/b;
        
            System.out.println("Answer is "+ c);
        }
    }
}