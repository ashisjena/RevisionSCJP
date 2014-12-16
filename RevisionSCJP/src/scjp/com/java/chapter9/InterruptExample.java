package scjp.com.java.chapter9;

public class InterruptExample
{

    public static void main( String[] args ) throws InterruptedException
    {
        
        Thread myThread = new MyThread();
        Thread.currentThread().setPriority( 10 );
        myThread.setPriority( 1 );
        myThread.start();
        myThread.interrupt();
        
        System.out.println( "Main has come to end" );
    }
}



class MyThread extends Thread
{
    public void run()
    {
        System.out.println( "MyThread has just started" );
        for(int i = 0; i < 10; i++)
        try
        {
            Thread.sleep( 1000 );
        }
        catch ( InterruptedException e )
        {
            e.printStackTrace();
        }
        
        System.out.println( "Everything is cool" );
    }
}
