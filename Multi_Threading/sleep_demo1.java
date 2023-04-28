package Multi_Threading;

public class sleep_demo1 
{
    public static void main(String[] args) 
    {
        System.out.println("Hello");
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
        System.out.println("World");
    }
}