package scjp.com.java.chapter9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreadSafetyTestForWritingHashMap
{
    public static void main( String[] args ) throws InterruptedException
    {
        Map< String, String > hashMap = new HashMap< String, String >();
        List< TestThread > testThread = new ArrayList< TestThread >();
        List< Thread > threads = new ArrayList< Thread >();

        for ( int i = 0; i < 20; i++ )
            testThread.add( new ThreadSafetyTestForWritingHashMap().new TestThread( hashMap ) );

        for ( TestThread thread : testThread )
            threads.add( new Thread( thread ) );

        int count = 1;
        for ( Thread thread : threads )
        {
            thread.setName( count++ + "Thread : " );
            thread.start();
        }
        
        Thread.sleep( 500 );
        System.out.println( hashMap.size() );
        //Collections.sort( new ArrayList(hashMap.keySet()) );
        
    }
    
    class TestThread implements Runnable
    {
        private Map< String, String > map;

        TestThread( Map< String, String > map )
        {
            this.map = map;
        }

        @Override
        public void run()
        {
            for ( int i = 0; i < 20; i++ )
                this.map.put( Thread.currentThread().getName() + i, "" );
        }
    }
}


