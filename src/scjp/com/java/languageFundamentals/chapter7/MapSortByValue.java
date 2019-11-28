package scjp.com.java.languageFundamentals.chapter7;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MapSortByValue
{
	public static void main( String[] args )
	{
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put( "rama", 2 );
		map.put( "sita", 1 );
		map.put( "hari", 8 );
		map.put( "govinda", 4 );

		Map<String, Integer> sortedMap = new TreeMap<String, Integer>( new ValueComparator<String>( map ) );
		sortedMap.putAll( map );
		
		for(Entry<String, Integer> entry : sortedMap.entrySet())
		{
			System.out.println(entry.getValue());
		}
	}
}