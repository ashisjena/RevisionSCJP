package scjp.com.java.languageFundamentals.chapter9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreadSafetyForReadingHashMap
{
    static Map< String, String > hashMap = new HashMap< String, String >();

    public static void main( String[] args ) throws InterruptedException
    {
        ThreadSafetyForReadingHashMap obj = new ThreadSafetyForReadingHashMap();
        List< Thread > threads = new ArrayList< Thread >();
        for ( int i = 0; i < 20; i++ )
        {
            Thread t = obj.new TestThread();
            t.setName( i + "_Thread : " );
            for ( int j = 0; j < 20; j++ )
                hashMap.put( t.getName() + j, "" );
            threads.add( t );
        }
        
        
        for(Thread thread : threads)
        {
            thread.start();
        }
        
        for(Thread thread : threads)
        {
            thread.join();
        }
        
        int count = 0;
        for(Thread thread : threads)
        {
            count += ((TestThread)thread).count;
        }
        
        System.out.println(count);
        
    }

    class TestThread extends Thread
    {
        public int count = 0;

        @Override
        public void run()
        {
            for ( int i = 0; i < 20; i++ )
                if ( hashMap.get( Thread.currentThread().getName() + i ) != null )
                    count++;
        }
    }
}
