package Multi_Threading;

public class P implements Runnable
{
    @Override
    public void run() 
    {
        for(int i=1; i<=5; i++)
        {
            System.out.println("Child Thread");
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}