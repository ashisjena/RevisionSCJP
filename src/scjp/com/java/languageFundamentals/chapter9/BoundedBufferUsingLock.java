package scjp.com.java.languageFundamentals.chapter9;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBufferUsingLock
{
    public static void main( String[] args )
    {
        BoundedBuffer< String > boundedBuffer = new BoundedBuffer< String >();

    }
}

class BoundedBuffer<E>
{
    Lock lock = new ReentrantLock();
    Condition notFull = lock.newCondition();
    Condition notEmpty = lock.newCondition();

    Object[] items = new Object[10];
    int count, putPtr, takePtr;

    public BoundedBuffer()
    {
    }

    public void add( E value ) throws InterruptedException
    {
        lock.lock();
        synchronized (items)
        {
            try
            {
                if ( count == items.length )
                    notFull.await();

                items[ putPtr ] = value;

                if ( ++putPtr == items.length )
                    putPtr = 0;

                ++count;
                notEmpty.signal();
            }
            finally
            {
                lock.unlock();
            }
        }
    }

    public E take() throws InterruptedException
    {
        lock.lock();
        synchronized (items)
        {
            try
            {
                if ( count == 0 )
                    notEmpty.await();

                Object x = items[ takePtr ];

                if ( ++takePtr == items.length )
                    takePtr = 0;

                --count;
                notFull.signal();

                return (E)x;
            }
            finally
            {
                lock.unlock();
            }
        }
    }
}
