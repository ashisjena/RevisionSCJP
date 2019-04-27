package scjp.com.java.chapter7;

import java.util.Map.Entry;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class LexographicalSearchTreeMap
{
	private static final Object EMPTY_STRING = "";

	public static void main( String[] args )
	{
		TreeMap<String, String> map = new TreeMap<String, String>();

		for ( int i = 0; i <= 30; i++ )
		{
			if ( i % 2 == 0 )
				map.put( "Rama" + i, "" );
			else if ( i % 3 == 0 )
				map.put( "Hari" + i, "" );
			else if ( i % 5 == 0 )
				map.put( "Govinda" + i, "" );
		}

		SortedMap<String, String> subMap = map.subMap( "Rama", true, "Ramb", false );

		for ( Entry<String, String> entry : subMap.entrySet() )
			System.out.println( entry.getKey() );

	}

	public <T> Map<String, T> subMapWithKeysThatAreSuffixes( String prefix, TreeMap<String, T> map )
	{
		if ( EMPTY_STRING.equals( prefix ) )
			return map;
		String lastKey = createLexicographicallyNextStringOfTheSameLength( prefix );
		return map.subMap( prefix, true, lastKey, false );
	}

	String createLexicographicallyNextStringOfTheSameLength( String input )
	{
		final int lastCharPosition = input.length() - 1;
		String inputWithoutLastChar = input.substring( 0, lastCharPosition );
		char lastChar = input.charAt( lastCharPosition );
		char incrementedLastChar = ( char ) ( lastChar + 1 );
		return inputWithoutLastChar + incrementedLastChar;
	}
}
