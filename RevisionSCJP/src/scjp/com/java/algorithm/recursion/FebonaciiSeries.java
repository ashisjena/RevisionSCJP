package scjp.com.java.algorithm.recursion;

public class FebonaciiSeries
{
	public static Integer n = 10;

	public static void main( String[] args )
	{
		for ( int i = 0; i <= 10; i++ )
			System.out.print( febonacii( i ) + " " );
	}

	private static int febonacii( int i )
	{
		if ( i == 0 || i == 1 )
			return i;
		else
			return febonacii( i - 1 ) + febonacii( i - 2 );
	}
}