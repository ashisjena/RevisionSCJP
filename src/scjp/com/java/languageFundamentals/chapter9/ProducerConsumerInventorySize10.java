package scjp.com.java.languageFundamentals.chapter9;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerInventorySize10
{
	Prod producer = new Prod();
	Cons consumer1 = new Cons( producer );
	Cons consumer2 = new Cons( producer );
	Cons consumer3 = new Cons( producer );
	Cons consumer4 = new Cons( producer );
	Cons consumer5 = new Cons( producer );
	Cons consumer6 = new Cons( producer );
	Cons consumer7 = new Cons( producer );
	Cons consumer8 = new Cons( producer );
	Cons consumer9 = new Cons( producer );
	Cons consumer10 = new Cons( producer );
	Cons consumer11 = new Cons( producer );
	Cons consumer12 = new Cons( producer );
    Thread p = new Thread( producer, "Producer : " );
    Thread c1 = new Thread( consumer1, "Consumer1 : " );
    Thread c2 = new Thread( consumer2, "Consumer2 : " );
    Thread c3 = new Thread( consumer3, "Consumer3 : " );
    Thread c4 = new Thread( consumer1, "Consumer4 : " );
    Thread c5 = new Thread( consumer2, "Consumer5 : " );
    Thread c6 = new Thread( consumer3, "Consumer6 : " );
    Thread c7 = new Thread( consumer1, "Consumer7 : " );
    Thread c8 = new Thread( consumer2, "Consumer8 : " );
    Thread c9 = new Thread( consumer3, "Consumer9 : " );
    Thread c10 = new Thread( consumer1, "Consumer10 : " );
    Thread c11 = new Thread( consumer2, "Consumer11 : " );
    Thread c12 = new Thread( consumer3, "Consumer12 : " );

    
    public static void main( String[] args )
    {
        new ProducerConsumerInventorySize10().executeThreads();
    }
    
    public void executeThreads()
    {
        p.setPriority( 10 );
        p.start();
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
        c6.start();
        c7.start();
        c8.start();
        c9.start();
        c10.start();
        c11.start();
        c12.start();

        try
        {
            Thread.sleep( 500 );
        }
        catch ( InterruptedException e )
        {
            e.printStackTrace(); 
            System.exit( 0 );
        }
        producer.stopExecution = true;
    }
}

class Product
{
}

class Prod implements Runnable
{
    public volatile List< Product > inventory = new ArrayList< Product >();
    public boolean executionFlag = true;
    public boolean stopExecution = false;

    @Override public void run()
    {
        while ( executionFlag )
        {
            synchronized (inventory)
            {
                try
                {
                    if ( inventory.size() >= 10 )
                        inventory.wait();

                    /*if(inventory.size() > 0)
                        inventory.notifyAll();*/
                    inventory.add( new Product() );
                    System.out.println( Thread.currentThread().getName() + " Producing, The inventory stock is : " + inventory.size() );
                    inventory.notifyAll();
                    if ( stopExecution )
                        executionFlag = false;
                }
                catch ( Throwable e )
                {
                    e.printStackTrace();
                    System.exit( 0 );
                }
            }
        }
        if ( !executionFlag )
        {
            synchronized (inventory)
            {
                if ( inventory.size() == 0 )
                    inventory.notifyAll();
            }
        }
    }
}

class Cons implements Runnable
{
    private List< Product > inventory;
    public Prod prod;

    public Cons( Prod prod )
    {
        this.prod = prod;
        this.inventory = prod.inventory;
    }

    @Override public void run()
    {
        while ( true )
        {
            synchronized (inventory)
            {
                try
                {
                    long start = System.nanoTime();
                    if ( !checkForInventory( start ) )
                    {
                        inventory.notifyAll();
                        return;
                    }
                    inventory.remove( inventory.size() - 1 );
                    System.out.println( Thread.currentThread().getName() + " Consuming, The inventory stock is : " + inventory.size() );
                    inventory.notifyAll();
                }
                catch ( Throwable e )
                {
                    System.out.println(Thread.currentThread().getName() + e.toString());
                    String msg = "";
                    for(StackTraceElement stackTraceElement : e.getStackTrace())
                    {
                        if(!msg.equals( stackTraceElement.toString()))
                            msg = stackTraceElement.toString();
                        else
                            continue;
                        System.out.println( msg);
                    }
                    System.exit( 0 );
                }
            }
            /* try
             {
                 Thread.sleep( 1 );
             }
             catch ( InterruptedException e )
             {
                 e.printStackTrace();
             }*/
        }
    }

    public boolean checkForInventory( long start ) throws InterruptedException
    {
        synchronized (inventory)
        {
            if ( inventory.size() == 0 )
            {
                if ( !prod.executionFlag )
                    return false;
                
                inventory.wait();
                return checkForInventory( start ); //double check whether again any other consumer which got into running, has emptied the inventory or not.
            } //to avoid "java.lang.ArrayIndexOutOfBoundsException: -1" on inventory removal
            //System.out.println( Thread.currentThread().getName() + " waited for : " + TimeUnit.NANOSECONDS.toMicros( System.nanoTime() - start) );
            return true;
        }
    }
}