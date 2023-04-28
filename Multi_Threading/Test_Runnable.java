package Multi_Threading;

public class Test_Runnable 
{
    public static void main(String[] args) 
    {
        P job1 = new P();
        
        Thread t1 = new Thread(job1);
        
        t1.start();
        
        // main Thread
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