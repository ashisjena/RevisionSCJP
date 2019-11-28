package scjp.com.java.languageFundamentals.chapter9;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerBlockingQueue
{
    public static void main( String[] args ) throws InterruptedException
    {
        BlockingQueue< String > blockingQueue = new ArrayBlockingQueue< String >( 4 );

        Producer prod = new Producer( blockingQueue );
        Thread producer = new Thread( prod );

        Consumer cons = new Consumer( blockingQueue );
        Thread consumer = new Thread( cons );

        producer.start();

        consumer.start();

        Thread.sleep( 50 );

        prod.stop( producer );
        cons.stop( consumer );
        
        Thread.sleep( 20 );
    }
}

class Producer implements Runnable
{
    private final BlockingQueue< String > sharedQueue;
    private boolean isActive = true;
    int count = 0;

    public Producer( BlockingQueue< String > sharedQueue )
    {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run()
    {
        while ( this.isActive )
        {
            try
            {
                Thread.sleep( 1 );
                this.sharedQueue.put( "message " + ++count );
            }
            catch ( InterruptedException e )
            { // do nothing
                System.out.println( "Producer Interrupted" );
            }
        }
    }

    public void stop( Thread thread )
    {
        this.isActive = false;
        thread.interrupt();
        System.out.println(count);
    }
}

class Consumer implements Runnable
{
    private final BlockingQueue< String > sharedQueue;
    private boolean isActive = true;

    public Consumer( BlockingQueue< String > sharedQueue )
    {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run()
    {
        while ( this.isActive || this.sharedQueue.isEmpty() )
        {
            try
            {
                System.out.println( this.sharedQueue.take() );
            }
            catch ( InterruptedException e )
            {
                System.out.println( "Consumer Interrupted" );
            }
        }
    }

    public void stop( Thread thread )
    {
        this.isActive = false;
        thread.interrupt();
    }
}