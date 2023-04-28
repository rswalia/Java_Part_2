package Multi_Threading;

public class sleep_demo2 
{
    public static void main(String[] args) 
    {
        for(int i=10; i>=1; i--)
        {
            System.out.println(i);
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("Go...");
    }
}