package scjp.com.java.algorithm.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Find the number of ways of distributing N objects into R groups such that each group gets 1 or more objects.

Input:
The one and only line of input contains two numbers separated by a single space, which are N and R respectively.

Output:
The corresponding answer modulo 10000007 in a single line and if no answer exist then print "-1".

Constraints:
1 <= N <= 100
1 <= R <= 100
Sample Input (Plaintext Link)
4 2
Sample Output (Plaintext Link)
3
Explanation
Let the 2 groups be A and B respectively.
Case 1: A gets 1 object and B gets 3
Case 2: A gets 2 objects and B gets 2
Case 3: A gets 3 objects and B gets 1 
*/

public class SimpleMath
{
	public static void main( String[] args ) throws IOException
	{
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		String line1 = br.readLine();

		String[] line1Values = line1.split( "\\s" );

		int noOfObjects = Integer.parseInt( line1Values[0] );
		int noOfGroups = Integer.parseInt( line1Values[1] );

		if ( noOfGroups > noOfObjects )
		{
			System.out.println( -1 );
			return;
		}
		else if ( noOfGroups == noOfObjects )
		{
			System.out.println( 1 );
			return;
		}

		int noOfGaps = noOfObjects - 1;
		int noOfPartition = noOfGroups - 1;
		System.out.println( findFactorial( noOfGaps ) / ( findFactorial( noOfGaps - noOfPartition ) * findFactorial( noOfPartition ) ) );
	}

	private static int findFactorial( int no )
	{
		if ( no <= 1 )
			return 1;

		return no * findFactorial( no - 1 );
	}
}