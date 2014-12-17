package scjp.com.java;

public class MathUtil
{
	public static int permutation( int n, int r )
	{
		return ( findFactorial( n ) / findFactorial( n - r ) );
	}

	public static int combination( int n, int r )
	{
		return ( findFactorial( n ) / ( findFactorial( r ) * findFactorial( n - r ) ) );
	}

	public static int findFactorial( int no )
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