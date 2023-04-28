package Anonymous_Inner_Class;

public class abc 
{
    public static void main(String[] args) 
    {
//        Q obj = new Q();
        
//        new P()
        
        P obj = new P()
        {
            @Override
            public void calculate(int a) 
            {
                int p = a*a*a;
                System.out.println("Cube is "+ p);
            }
        };
        
        obj.calculate(10);
    }
}