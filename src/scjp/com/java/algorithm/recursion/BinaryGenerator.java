package scjp.com.java.algorithm.recursion;

import java.util.Arrays;

public class BinaryGenerator
{
	private static int n = 3;

	public static void main( String[] args )
	{
		int[] arr = new int[n];
		generateRecBinaryStrings( n, arr );
	}

	private static void generateRecBinaryStrings( int n, int[] arr )
	{
		if ( n < 1 )
			System.out.println( Arrays.toString( arr ) );
		else
		{
			arr[n - 1] = 0;
			generateRecBinaryStrings( n - 1, arr );
			arr[n - 1] = 1;
			generateRecBinaryStrings( n - 1, arr );
		}
	}
}