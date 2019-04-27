package scjp.com.java.algorithm.recursion;

public class SortedArrayCheckWithRecursion
{
	public static void main( String[] args )
	{
		int[] arr = { 1, 3, 2, 5, 6 };
		if ( isSortedArray( arr, 0 ) )
			System.out.println( "It is a sorted Array" );
		else
			System.out.println( "It is not a sorted Array" );
	}

	public static boolean isSortedArray( int[] arr, int index )
	{
		if ( index == arr.length - 1 )
			return true;

		return arr[index] < arr[index + 1] ? isSortedArray( arr, index + 1 ) : false;
	}
}