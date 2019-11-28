package scjp.com.java.languageFundamentals.chapter9;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadScheduling
{
	public static void main( String[] args )
	{
		ExecutorService es = Executors.newFixedThreadPool( 10 );
		List<Callable<String>> callables = new ArrayList<>();
		callables.add( new DemoCallable() );
		callables.add( new DemoCallable() );
		callables.add( new DemoCallable() );
		List<Future<String>> futureList;
		try
		{
			futureList = es.invokeAll( callables );

			for ( Future<String> future : futureList )
				System.out.println( future.get() );

			//or

			CompletionService<String> cs = new ExecutorCompletionService<String>( es );
			cs.submit( new DemoRunnable(), "DemoResult1" );
			cs.submit( new DemoRunnable(), "DemoResult2" );

			for ( int i = 0; i < 2; i++ )
			{
				Future<String> future = cs.take();
				System.out.println( future.get() ); // Here get is just to get the Success Value set by us.
			}

			System.out.println( "Shutting Down" );
			es.shutdown();
		}
		catch ( InterruptedException | ExecutionException e )
		{
			e.printStackTrace();
			System.out.println( "Shutting Down Immediate" );
			es.shutdownNow();
		}
		
		System.out.println("Programm Finished");
	}
}

class DemoCallable implements Callable<String>
{
	@Override
	public String call() throws Exception
	{
		return this.toString();
	}
}

class DemoRunnable implements Runnable
{
	@Override
	public void run()
	{
		System.out.println( this.toString() );
		//throw new RuntimeException( "Exception Throw" );
	}
}
