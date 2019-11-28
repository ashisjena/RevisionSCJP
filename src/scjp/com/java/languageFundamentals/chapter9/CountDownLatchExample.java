package scjp.com.java.languageFundamentals.chapter9;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample
{
    public static void main( String[] args )
    {
        CountDownLatch startSignal = new CountDownLatch( 1 ); // One driver
        CountDownLatch doneSignal = new CountDownLatch( 10 ); // 10 Workers

        new Thread( new Driver( startSignal, doneSignal ) ).start();
        for ( int i = 0; i < 10; ++i )
            // create and start threads
            new Thread( new Worker( startSignal, doneSignal ) ).start();
    }
}

class Driver implements Runnable
{
    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;

    Driver( CountDownLatch startSignal, CountDownLatch doneSignal )
    {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }

    public void run()
    {
        //doSomethingElse();            // don't let run yet
        startSignal.countDown(); // let all threads proceed
        //doSomethingElse();
        try
        {
            doneSignal.await(); // wait for all to finish
            System.out.println("Bus Started");
        }
        catch ( InterruptedException e )
        {
            // return;
        }
    }
}

class Worker implements Runnable
{
    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;

    Worker( CountDownLatch startSignal, CountDownLatch doneSignal )
    {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }

    public void run()
    {
        try
        {
            startSignal.await();
            // doWork();
            doneSignal.countDown();
//            doneSignal.countDown();
            System.out.println("Worker Complete");
        }
        catch ( InterruptedException ex )
        {
            // return;
        } 
    }
}