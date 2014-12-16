package scjp.com.java.chapter9;

public class ThreadPoolTest
{

    /**
     * @param args
     * @throws InterruptedException 
     */
    public static void main( String[] args ) throws InterruptedException
    {
        ThreadPool threadPool = new ThreadPool( 2, 5 );
        for(int i = 0 ; i <6 ; i++)
        {
//            if (i==2)
//                Thread.sleep( 100 );
            threadPool.execute( new MyRunnable() );
        }
            
        Thread.sleep( 100 );
        threadPool.stop();
        
        
//        BlockingQueue blockingQueue = new BlockingQueue();
//        InterruptTestThread t1 = new InterruptTestThread( blockingQueue );
//        InterruptTestThread t2 = new InterruptTestThread( blockingQueue );
//        t1.start();
//        t2.start();
//        
//        t1.interrupt();
//        t2.interrupt();
    }
}

class MyRunnable implements Runnable
{

    @Override
    public void run()
    {
       /* try
        {
            Thread.sleep( 100 );
        }
        catch ( InterruptedException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
        System.out.println( "Hi" );
    }
}

class InterruptTestThread extends Thread
{
    private BlockingQueue queue;

    InterruptTestThread(BlockingQueue queue)
    {
        this.queue = queue;
    }
    
    public void run()
    {
        queue.dequeue();
    }
}
