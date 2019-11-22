package scjp.com.java.stackoverflow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class NumericArrayPartitionAverage
{

	public static void printSolution( List<Integer> list, HashSet<Integer> indexes )
	{
		Iterator<Integer> iter = indexes.iterator();
		while ( iter.hasNext() )
		{
			System.out.print( list.get( ( Integer ) iter.next() ) + " " );
		}
		System.out.println();
	}

	/**
	 * calculates the average of a list, but only taking into account the values
	 * of at the given indexes
	 */
	public static float avg( List<Integer> list, HashSet<Integer> indexes )
	{
		Iterator<Integer> iter = indexes.iterator();
		float sum = 0;
		while ( iter.hasNext() )
		{
			sum += ( Integer ) list.get( ( Integer ) iter.next() );
		}
		return sum / indexes.size();
	}

	/**
	 * calculates the average of a list, ignoring the values of at the given
	 * indexes
	 */
	public static float avg_e( List<Integer> list, HashSet<Integer> indexes )
	{
		float sum = 0;
		for ( int i = 0; i < list.size(); i++ )
		{
			if ( !indexes.contains( i ) )
			{
				sum += ( Integer ) list.get( i );
			}
		}
		return sum / ( list.size() - indexes.size() );
	}

	public static void backtrack( List<Integer> list, int start, HashSet<Integer> indexes )
	{
		for ( int i = start; i < list.size(); i++ )
		{
			indexes.add( i );
			if ( avg( list, indexes ) == avg_e( list, indexes ) )
			{
				System.out.println( "BarterMarket found!" );
				printSolution( list, indexes );
			}
			backtrack( list, i + 1, indexes );
			indexes.remove( i );
		}
	}

	public static void main( String[] args )
	{
		List<Integer> test = new ArrayList<Integer>();
		test.add( 2 );
		test.add( 1 );
		test.add( 3 );

		backtrack( test, 0, new HashSet<Integer>() );
	}
}