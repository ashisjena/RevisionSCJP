package scjp.com.java.algorithm.demo;

import java.util.ArrayList;
import java.util.List;

public class IntegerToBinary
{

	public static void main( String[] args )
	{
		int i = 5;

		List<Integer> lists = new ArrayList<Integer>();
		for ( int len = 31; len >= 0; len-- )
		{
			int k = i >> len;
			lists.add( k );
			System.out.print( k & 1);
		}

		System.out.println( "\n" + Integer.toBinaryString( i ) );
		
		System.out.println(lists);
	}
}
