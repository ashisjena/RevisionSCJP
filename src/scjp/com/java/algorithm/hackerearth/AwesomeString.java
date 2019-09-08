package scjp.com.java.algorithm.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AwesomeString
{
	public static void main( String[] args ) throws Exception
	{
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

		String word = br.readLine();
		int no = Integer.parseInt( br.readLine() );

		List<Pair> values = new ArrayList<Pair>();
		for ( int index = 0; index < no; index++ )
		{
			String[] strs = word.split( "//s" );
			values.add( new Pair( Integer.parseInt( strs[0] ), Integer.parseInt( strs[1] ) ) );
		}

		for ( Pair pair : values )
		{
			String subString = word.substring( pair.x, pair.y );
			String[] strings = subString.split( "" );

			rotateStringsAndCompare( strings, word );
		}
	}

	private static void rotateStringsAndCompare( String[] strings, String word )
	{
		List<String> awesomeStrings = new ArrayList<String>();
		if ( word.toLowerCase().contains( Arrays.toString( strings ).toLowerCase() ) )
		{
			awesomeStrings.add( Arrays.toString( strings ) );
		}
		else
		{
			//if
		}
	}

	static class Pair
	{
		int x;
		int y;

		public Pair( int x, int y )
		{
			this.x = x;
			this.y = y;
		}
	}
}