package scjp.com.java.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class PowerSet
{
	public static void main( String args[] )
	{
		int[] a =
		{ 1, 2, 3, 4 };
		for ( String str : powerSet( a ) )
		    System.out.println( str );

		System.out.println();

		/*for ( List<Integer> subSet : powerSetAsList( a ) )
			System.out.println( subSet );*/

	}

	private static List<Integer> powerSetRecurr( int[] a )
	{
		List<Integer> list = new ArrayList<Integer>();
		recurr(a, a.length, list);
		return list;
	}

	private static void recurr( int[] a, int noOfElements, List<Integer> list )
	{
	}

	private static List<String> powerSet( int[] a )
	{
		List<String> pw = new ArrayList<String>();
		pw.add( " " );
		for ( int i = 0; i < a.length; i++ ) //O(n)
		{
			ArrayList<String> tmp = new ArrayList<String>();

			for ( String e : pw )//O(n)
			{
				if ( e.equals( " " ) )
					tmp.add( "" + a[i] ); //constant time;
				else
					tmp.add( e + ", " + a[i] ); //constant time;
			}

			pw.addAll( tmp );//O(1);
		}
		pw.remove( 0 );
		return pw;
	}

	private static List<List<Integer>> powerSetAsList( int[] a )
	{
		List<List<Integer>> powerSet = new ArrayList<List<Integer>>();
		powerSet.add( new ArrayList<Integer>() );
		for ( int i = 0; i < a.length; i++ )
		{
			List<List<Integer>> subSet = new ArrayList<List<Integer>>();
			for ( List<Integer> set : powerSet )
			{
				List<Integer> list = new ArrayList<Integer>();
				if ( set.size() == 0 )
					list.add( a[i] );
				else
				{
					list.add( a[i] );
					list.addAll( set );
				}
				subSet.add( list );
			}
			powerSet.addAll( subSet );
		}
		powerSet.remove( 0 );
		return powerSet;
	}
}