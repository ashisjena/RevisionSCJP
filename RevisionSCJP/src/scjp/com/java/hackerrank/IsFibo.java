package scjp.com.java.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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
	public static void main( String[] args ) throws IOException
	{
		BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( System.in ) );
		String line = bufferedReader.readLine();
		int no = Integer.parseInt( line );

		int arr[] = new int[no];
		for ( int i = 0; i < no; i++ )
			arr[i] = Integer.parseInt( bufferedReader.readLine() );
	}
}