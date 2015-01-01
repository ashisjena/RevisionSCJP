package scjp.com.java;

public class MathUtil
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