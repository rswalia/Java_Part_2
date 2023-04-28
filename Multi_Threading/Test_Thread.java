package Multi_Threading;

public class Test_Thread 
{
    public static void main(String[] args) 
    {
        A t1 = new A();
        
        t1.start();
        
        for(int i=1; i<=5; i++)
        {
            System.out.println("Parent Thread");
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }   
}