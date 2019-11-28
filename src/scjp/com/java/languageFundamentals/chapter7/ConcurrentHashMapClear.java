package scjp.com.java.languageFundamentals.chapter7;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapClear
{
    public static void main( String[] args ) throws InterruptedException
    {
        Map< String, Integer > concurrenthashMap = new ConcurrentHashMap< String, Integer >();
        Map< String, Integer > hashMap = new HashMap< String, Integer >();
        BlockingQueue< String > blockingQueue = new ArrayBlockingQueue< String >( 10 );
        for(int i = 0; i < 10; i++)
            concurrenthashMap.put( "key" + i, i );
        Thread producer = new Thread( new Producer( blockingQueue, concurrenthashMap ) );
        Thread consumer = new Thread( new Consumer( blockingQueue, concurrenthashMap ) );
        
        
        
        consumer.start();
        Thread.sleep( 1 );
        producer.start();
        
        Thread.sleep( 100 );
        
        System.out.println(concurrenthashMap.size());
    }
}

class Producer implements Runnable
{
    private BlockingQueue<String> queue;
    private Map< String, Integer > map;

    Producer( BlockingQueue<String> queue, Map< String, Integer > map )
    {
        this.queue = queue;
        this.map = map;
    }

    @Override
    public void run()
    {
        System.out.println("Clearing the map : Producer");
        this.map.clear();
        System.out.println("Clearing the map : Producer");
        /*try
        {
            Thread.sleep( 200 );
            System.out.println("Clearing the map : Producer");
            this.map.clear();
            this.queue.put("Hi");
            Thread.sleep( 100 );
        }
        catch ( InterruptedException e )
        {
            e.printStackTrace();
        }*/
    }
}


class Consumer implements Runnable
{
    private BlockingQueue<String> queue;
    private Map< String, Integer > map;

    Consumer( BlockingQueue<String> queue, Map< String, Integer > map )
    {
        this.queue = queue;
        this.map = map;
    }

    @Override
    public void run()
    {
        int count = 0;
        for(Entry<String, Integer> entry : map.entrySet())
        {
            /*if(++count == 5)
                try
                {
                    this.queue.take();
                    System.out.println("got the queue");
                }
                catch ( InterruptedException e )
                {
                    e.printStackTrace();
                }*/
            System.out.println(entry.getKey());
        }
    }
}
