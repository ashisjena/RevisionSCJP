package scjp.com.java.miscellaneous.classloader;

public class Foo implements Runnable
{
    static volatile int value = 51;
    @Override
    public void run()
    {
        while(true)
            try
            {
                System.out.println( "Iterating " + value );
                Thread.sleep( 500 );
            }
            catch ( InterruptedException e )
            {
                e.printStackTrace();
            }
    }
}