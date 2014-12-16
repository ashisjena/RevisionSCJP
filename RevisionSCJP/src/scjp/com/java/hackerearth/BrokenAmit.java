package scjp.com.java.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BrokenAmit
{
	public static void main( String args[] ) throws Exception
	{
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		String line = br.readLine();
		int noOfGirls = Integer.parseInt( line );

		List<ValuePair> valuePairs = new ArrayList<ValuePair>();
		line = br.readLine();
		String[] loveValueStrings = line.split( "\\s" );
		line = br.readLine();
		String[] decrementValueStrings = line.split( "\\s" );

		for ( int index = 0; index < noOfGirls; index++ )
			valuePairs.add( new ValuePair( Integer.parseInt( loveValueStrings[index] ), Integer.parseInt( decrementValueStrings[index] ), index ) );

		Collections.sort( valuePairs );
		int sum = 0;
		for ( int i = 0; i < noOfGirls; i++ )
		{
			for ( int j = 0; j < noOfGirls; j++ )
			{
				ValuePair pair = valuePairs.get( j );
				sum += pair.loveValue;
				if ( j == 0 )
				{
					pair.isKissed = true;
				}
				else if ( !pair.isKissed )
				{
					int value = pair.loveValue - ( pair.position * pair.decrementValue );
					if ( value < 0 )
						pair.loveValue = 0;
					else
						pair.loveValue = value;
				}
			}
			Collections.sort( valuePairs );
		}

		System.out.println( sum );
	}

	static class ValuePair implements Comparable<ValuePair>
	{
		int loveValue;
		int decrementValue;
		int position;
		boolean isKissed = false;

		public ValuePair( int loveValue, int decrementValue, int position )
		{
			this.loveValue = loveValue;
			this.decrementValue = decrementValue;
			this.position = position;
		}

		public int compareTo( ValuePair arg0 )
		{
			if ( ( !this.isKissed ) && ( !arg0.isKissed ) )
			{
				int i = Integer.valueOf( arg0.position * arg0.loveValue ).compareTo( Integer.valueOf( loveValue * position ) );
				if ( i == 0 )
					return Integer.valueOf( arg0.loveValue ).compareTo( Integer.valueOf( loveValue ) );
				else
					return i;
			}
			else if ( !this.isKissed )
				return -1;
			else if ( !arg0.isKissed )
				return 1;

			return 0;
		}
	}
}