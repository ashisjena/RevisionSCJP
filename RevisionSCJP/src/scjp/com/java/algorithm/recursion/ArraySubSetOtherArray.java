package scjp.com.java.algorithm.recursion;

/*
 * Find an array is subset of other Array with O(n) complexity
 */

public class ArraySubSetOtherArray
{
	public static void main( String[] args )
	{
		int arr1[] = { 1, 2, 3, 4, 5 };
		int arr2[] = { 2, 4 };

		if ( isSubSet( arr1, 0, arr2, 0 ) )
			System.out.println( "Sub Set" );
		else
			System.out.println( "Not Sub Set" );
	}

	public static boolean isSubSet( int[] arr1, int index1, int[] arr2, int index2 )
	{
		if ( index1 == arr1.length )
			return false;
		else if ( arr1[index1++] == arr2[index2] && ++index2 == arr2.length )
			return true;

		return isSubSet( arr1, index1, arr2, index2 );
	}
}