package scjp.com.java.algorithm.hackerrank;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/*
Problem Statement

You are given an integer, N. Write a program to determine if N is an element of the Fibonacci Sequence.

The first few elements of fibonacci sequence are 0,1,1,2,3,5,8,13,⋯ A fibonacci sequence is one where every element is a sum of the previous two elements in the sequence. The first two elements are 0 and 1.

Formally:
fib0fib1⋮fibn=0=1=fibn−1+fibn−2∀n>1

Input Format
The first line contains T, number of test cases.
T lines follows. Each line contains an integer N.

Output Format
Display IsFibo if N is a fibonacci number and IsNotFibo if it is not a fibonacci number. The output for each test case should be displayed in a new line.

Constraints
1≤T≤105
1≤N≤1010

Sample Input

3
5
7
8

Sample Output

IsFibo
IsNotFibo
IsFibo

Explanation
5 is a Fibonacci number given by fib5=3+2
7 is not a Fibonacci number
8 is a Fibonacci number given by fib6=5+3
*/

public class IsFibo
{
	public static <V> void main( String[] args ) throws IOException
	{
		int no = ConsoleReader.getInstance().readInteger();

		Long arr[][] = new Long[no][2];
		for ( int i = 0; i < no; i++ )
		{
			arr[i][0] = ConsoleReader.getInstance().readLong();
			arr[i][1] = ( long ) i;
		}

		Arrays.sort( arr, new Comparator<Long[]>()
		{
			@Override
			public int compare( Long[] o1, Long[] o2 )
			{
				return o1[0].compareTo( o2[0] );
			}
		} );

		Map<Long, String> indexToResultMap = new TreeMap<Long, String>();

		long prev = 0;
		long next = 1;
		for ( int i = 0; i < arr.length; i++ )
		{
			if ( arr[i][0] == prev + next )
				indexToResultMap.put( arr[i][1], "IsFibo" );
			else if ( arr[i][0] < prev + next )
				indexToResultMap.put( arr[i][1], "IsNotFibo" );
			else
			{
				next += prev;
				prev = next - prev;
				i--;
			}
		}

		for ( Entry<Long, String> entry : indexToResultMap.entrySet() )
			System.out.println( entry.getValue() );

		//		printIsFibo( arr, 0, 0, 1, indexToResultMap );  // Giving stack overflow error for large data

		ConsoleReader.getInstance().close();
	}

	private static void printIsFibo( Long[][] arr, int index, long prev, long next, Map<Long, String> indexToResultMap )
	{
		if ( index == arr.length )
			return;
		else if ( arr[index][0] == prev + next )
		{
			indexToResultMap.put( arr[index][1], "IsFibo" );
			printIsFibo( arr, ++index, prev, next, indexToResultMap );
		}
		else if ( arr[index][0] < prev + next )
		{
			indexToResultMap.put( arr[index][1], "IsNotFibo" );
			printIsFibo( arr, ++index, prev, next, indexToResultMap );
		}
		else
			printIsFibo( arr, index, next, prev + next, indexToResultMap );
	}
}