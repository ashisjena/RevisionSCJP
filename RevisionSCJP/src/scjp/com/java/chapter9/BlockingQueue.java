package scjp.com.java.chapter9;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue<E>
{
    private int limit = 10;
    private List< E > queue = new LinkedList< E >();

    public BlockingQueue()
    {
    }

    public BlockingQueue( int limit )
    {
        this.limit = limit;
    }

    public synchronized void enqueue( E entity )
    {
        if ( this.queue.size() == this.limit )
            try
            {
                wait();
            }
            catch ( InterruptedException e )
            {
                throw new RuntimeException( e );
            }

        if ( this.queue.size() == 0 )
            notifyAll();

        this.queue.add( entity );
    }

    public synchronized E dequeue()
    {
        if ( this.queue.size() == 0 )
            try
            {
                wait();
            }
            catch ( InterruptedException e )
            {
                throw new RuntimeException( e );
            }

        if ( this.queue.size() == this.limit )
            notifyAll();

        return this.queue.remove( 0 );
    }
}
