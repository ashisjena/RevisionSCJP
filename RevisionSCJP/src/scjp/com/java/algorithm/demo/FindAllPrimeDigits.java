package scjp.com.java.algorithm.demo;

import java.util.ArrayList;
import java.util.List;

//Sieve of Eratosthenes algorithm
public class FindAllPrimeDigits
{
	public static void main( String[] args )
	{
		new Thread( null, new MyThread( 100 ), "", 256L * 1 << 6 ).start();
	}

	static class MyThread implements Runnable
	{
		private final int upperBound;

		MyThread( final int value )
		{
			upperBound = value;
		}

		@Override
		public void run()
		{
			final int sqrtUpperBound = ( int ) Math.sqrt( upperBound );

			final boolean[] isComposite = new boolean[upperBound + 1];
			List<Integer> primeIntegers = new ArrayList<Integer>();
			for ( int i = 2; i <= sqrtUpperBound; i++ )
			{
				if ( !isComposite[i] )
				{
					primeIntegers.add( i );
					for ( int j = i * i; j <= upperBound; j += i )
						isComposite[j] = true;
				}
			}

			for ( int i = sqrtUpperBound; i <= upperBound; i++ )
				if ( !isComposite[i] )
					primeIntegers.add( i );

			System.out.println( primeIntegers );
		}
	}
}