package scjp.com.java.companies.morganstanley;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution implements Runnable
{
	public static void main( String[] args )
	{
		//new Thread( null, new Solution(), "", 256 * MathUtil._1MB_AS_BYTES ).start();

		/*System.out.println(reverseNo( 1200 ));
		System.out.println( CalculateReverseSum( 15, 43 ) );*/

		//System.out.println( getWinner( 13 ) );

		System.out.println( getIntegerComplement( 5 ) );
		
		/*double d = 10.0 / -0;
		if( d== Double.POSITIVE_INFINITY)
			System.out.println("Hi");
		
		int a[] = {1};
		incr(a);
		System.out.println(a[a.length - 1]);
		
		int a1 = 5;
		int b = 0;
		int c = a1/b;*/
		
		
		StringBuilder sb = new StringBuilder(Integer.toBinaryString( 50 ));
		System.out.println(sb.toString());
		sb.reverse();
		System.out.println(sb.toString());
		
		System.out.println(Integer.parseInt( sb.toString(), 2 ));

	}
	
	static void incr(int[] i)
	{
		i[i.length - 1]++;
		System.out.println(Arrays.toString( i ));
	}

	static int getIntegerComplement( int n )
	{
		int result = 0;
		while ( n != 0 )
		{
			result <<= 1;
			result |= ~( n & 1 );
			n >>= 1;
		}
		return Math.abs( result );
	}

	static String getWinner( int input1 )
	{
		int i = 0;

		while ( input1 > 0 )
			if ( input1 % 2 == 0 )
			{
				i++;
				input1 /= 2;
			}
			else
			{
				int noOfDigits = findDigits( input1 );
				if ( noOfDigits % 2 != 0 )
				{
					i++;
					input1--;
				}
				else
				{
					int power = noOfDigits / 2;

					if ( input1 / ( power * 10 ) > input1 % ( power * 10 ) )
					{
						i++;
						input1++;
					}
					else
					{
						i++;
						input1--;
					}
				}
			}

		if ( i == 0 || i % 2 != 0 )
			return "Tushar";
		else
			return "Ankush";
	}

	private static int findDigits( int no )
	{
		int result = 0;

		if ( no < 10 )
			return 1;

		result++;

		return result + findDigits( no / 10 );
	}

	static int CalculateReverseSum( int input1, int input2 )
	{
		return reverseNo( reverseNo( input1 ) + reverseNo( input2 ) );
	}

	private static int reverseNo( int no )
	{
		if ( no == 0 )
			return 0;

		int n = no;
		int power = 1;

		while ( n >= 10 )
		{
			n = n / 10;
			power = power * 10;
		}
		return ( n + reverseNo( no - n * power ) * 10 );
	}

	@Override
	public void run()
	{

	}
}

final class MathUtil
{
	public static final long _1MB_AS_BYTES = 1 << 20;

	public static long permutation( int n, int r )
	{
		return ( findFactorial( n ) / findFactorial( n - r ) );
	}

	public static long combination( int n, int r )
	{
		return ( findFactorial( n ) / ( findFactorial( r ) * findFactorial( n - r ) ) );
	}

	public static long arrangementsWithIndistinguisableElements( int n, int... noOfObjects )
	{
		long result = findFactorial( n );
		for ( int no : noOfObjects )
			result /= findFactorial( no );
		return result;
	}

	public static long findFactorial( int no )
	{
		if ( no <= 1 )
			return 1;

		return no * findFactorial( no - 1 );
	}

	public static boolean isEven( int no )
	{
		return no % 2 == 0 ? true : false;
	}
}

final class ConsoleReader
{
	private final BufferedReader br;

	private static class LazyHolder
	{
		private static ConsoleReader INSTANCE = new ConsoleReader();
	}

	public static ConsoleReader getInstance()
	{
		return LazyHolder.INSTANCE;
	}

	private ConsoleReader()
	{
		if ( LazyHolder.INSTANCE != null )
			throw new RuntimeException( "ConsoleReader Singleton object is already intitialized" );

		br = new BufferedReader( new InputStreamReader( System.in ) );
	}

	public String readLine() throws IOException
	{
		return this.br.readLine();
	}

	public int readInteger() throws NumberFormatException, IOException
	{
		return Integer.parseInt( readLine() );
	}

	public long readLong() throws NumberFormatException, IOException
	{
		return Long.parseLong( readLine() );
	}

	public double readDouble() throws NumberFormatException, IOException
	{
		return Double.parseDouble( readLine() );
	}

	@SuppressWarnings( "unchecked" )
	public <T> T[] readLineNSplitWithSpace( Class<T> clazz ) throws IOException
	{
		final String[] words = readLine().split( "\\s+" );
		int i = 0;
		if ( clazz.equals( String.class ) )
			return ( T[] ) words;
		else if ( clazz.equals( Integer.class ) )
		{
			final Integer[] arr = new Integer[words.length];
			for ( String str : words )
				arr[i++] = Integer.parseInt( str );
			return ( T[] ) arr;
		}
		else if ( clazz.equals( Long.class ) )
		{
			final Long[] arr = new Long[words.length];
			for ( String str : words )
				arr[i++] = Long.parseLong( str );
			return ( T[] ) arr;
		}
		else if ( clazz.equals( Double.class ) )
		{
			final Double[] arr = new Double[words.length];
			for ( String str : words )
				arr[i++] = Double.parseDouble( str );
			return ( T[] ) arr;
		}
		else
			throw new RuntimeException( "Wrong type specified" );
	}

	public String[] readLineNSplitLetterWise() throws IOException
	{
		return readLine().split( "(?!^)" );
	}

	public void close() throws IOException
	{
		this.br.close();
		LazyHolder.INSTANCE = null;
	}
}