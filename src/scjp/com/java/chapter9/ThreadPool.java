package scjp.com.java.chapter9;

import java.util.ArrayList;
import java.util.List;

public class ThreadPool
{
    private BlockingQueue< Runnable > taskQueue = null;
    private List< PoolThread > threads = new ArrayList< PoolThread >();
    private boolean isStopped = false;

    public ThreadPool( int noOfThreads, int maxNoOfTasks )
    {
        taskQueue = new BlockingQueue< Runnable >( maxNoOfTasks );

        for ( int i = 0; i < noOfThreads; i++ )
            threads.add( new PoolThread( taskQueue ) );
        
        for ( PoolThread thread : threads )
            thread.start();
    }

    public synchronized void execute( Runnable task )
    {
        if ( this.isStopped )
            throw new IllegalStateException( "ThreadPool is stopped" );

        this.taskQueue.enqueue( task );
    }

    public synchronized void stop()
    {
        this.isStopped = true;
        for ( PoolThread thread : threads )
            thread.stopPoolThread();
    }
}

class PoolThread extends Thread
{

    private BlockingQueue< Runnable > taskQueue = null;
    private boolean isStopped = false;

    public PoolThread( BlockingQueue< Runnable > queue )
    {
        taskQueue = queue;
    }

    public void run()
    {
        while ( !isStopped() )
        {
            try
            {
                Runnable runnable = (Runnable)taskQueue.dequeue();
                runnable.run();
            }
            catch ( RuntimeException e )
            {
                System.out.println( e.getMessage() + " Interrupted exception has occured, Stopping the ThreadPool" );
                //log or otherwise report exception,
                //but keep pool thread alive.
            }
        }
    }

    public synchronized void stopPoolThread()
    {
        isStopped = true;
        this.interrupt(); //break pool thread out of dequeue() call.
    }

    public synchronized boolean isStopped()
    {
        return isStopped;
    }
}