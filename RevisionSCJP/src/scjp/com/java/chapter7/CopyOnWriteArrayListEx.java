package scjp.com.java.chapter7;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListEx
{
	public static void main( String[] args ) throws InterruptedException
	{
		List<Integer> list = new CopyOnWriteArrayList<Integer>();
		Thread t1 = new Thread( new T1( list ) );
		Thread t2 = new Thread( new T2( list ) );

		for ( int i = 0; i < 7; i++ )
			list.add( i * 5 );

		t2.start();
		Thread.sleep( 2 );
		t1.start();

		Thread.sleep( 1000 );
		
		System.out.println(list);
	}
}

class T1 implements Runnable
{
	private List<Integer> list;

	public T1( List<Integer> list )
	{
		this.list = list;
	}

	public void run()
	{
		final List<Integer> list = this.list;
		list.set( 4, 10 );
		System.out.println("Set");
	}
}

class T2 implements Runnable
{
	private List<Integer> list;

	public T2( List<Integer> list )
	{
		this.list = list;
	}

	public void run()
	{
		final List<Integer> list = this.list;
		for ( Integer value : list )
		{
			System.out.println( value );
			try
			{
				Thread.sleep( 1 );
			}
			catch ( InterruptedException e )
			{
			}
		}
	}
}