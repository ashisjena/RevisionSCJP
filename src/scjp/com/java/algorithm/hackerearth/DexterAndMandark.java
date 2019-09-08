package scjp.com.java.algorithm.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*Dexter and Mandark are playing a game. The game consists of N rounds. After each round, the winner (either Dexter or Mandark) will be awarded one point. The player with more points at the end of the game wins.

Mandark is Dexter's arch enemy. Dexter wants to prove that he is superior to Mandark.
He wants that after each round in the game he has atleast M times the points that Mandark has.
Dexter is busy planning his game strategy so he asks you to tell him the number of ways he can win the game with the condition just described.

Two ways of winning the game are said to be different if some round is won by a different person.

Input:
The first line contains T, the number of test cases.
Each test case consists of a single line with two space separated integers N and M.

Output:
For each test case, output the answer modulo 10^9 + 7

Constraints:

1<=T<=10
1<=M<=N<=1000
Sample Input (Plaintext Link)
2
3 1
3 3

Sample Output (Plaintext Link)
3
1
Explanation
For the first test case, the possible sequence of winners of rounds are:
DDD
DMD
DDM

( MDD is not possible because in that sequence, even though Dexter wins in the end, but after first round Dexter does not have atleast M times the points that Mandark has)

For the second test case, the only possible sequence is :
DDD

[D=Dexter, M=Mandark]
*/

public class DexterAndMandark
{
	public static int count = 0;

	public static void main( String[] args ) throws IOException
	{
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		String line1 = br.readLine();

		int noOfTestCases = Integer.parseInt( line1 );

		int[][] arr = new int[noOfTestCases][2];
		for ( int i = 0; i < noOfTestCases; i++ )
		{
			String line2 = br.readLine();
			String[] line2Values = line2.split( "\\s" );

			int noOfRounds = Integer.parseInt( line2Values[0] );
			int leastWinNo = Integer.parseInt( line2Values[1] );

			arr[i][0] = noOfRounds;
			arr[i][1] = leastWinNo;
		}

		List<Set<String>> result = new ArrayList<Set<String>>();
		for ( int i = 0; i < noOfTestCases; i++ )
		{
			result.add( new HashSet<String>() );
			winRecurr( "", arr[i][0], arr[i][1], 0, 0, arr[i][0], result );
			System.out.println(count);
			count = 0;
		}

		for ( Set<String> set : result )
		{
			System.out.println( set );
		}
		
		System.out.println(count);
	}

	private static void winRecurr( String winSeq, int noOfRounds, int leastWinNo, int winByDexter, int winByMandark, int fixedRound, List<Set<String>> result )
	{
		count++;
		if ( winSeq.length() == fixedRound && winByDexter >= leastWinNo )
		{
			if ( noOfRounds == 0 )
			{
				result.get( result.size() - 1 ).add( winSeq );
			}
		}

		for ( int i = 0; i < noOfRounds; i++ )
		{
			if ( winByDexter >= winByMandark )
			{
				winRecurr( winSeq + "D", noOfRounds - 1, leastWinNo, winByDexter + 1, winByMandark, fixedRound, result );
				if ( winByDexter >= winByMandark * leastWinNo && winSeq.endsWith( "D" ) )
				{
					winRecurr( winSeq + "M", noOfRounds - 1, leastWinNo, winByDexter, winByMandark + 1, fixedRound, result );
					break;
				}
			}
			else
				return;
		}
	}
}
