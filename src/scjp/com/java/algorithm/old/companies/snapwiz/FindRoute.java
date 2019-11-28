package scjp.com.java.algorithm.old.companies.snapwiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Assume the following static data, and write a function, findRoutes(source, destination) that efficiently outputs all possible routes.

Source      | Dest
------------------------
Bangalore  |  Mumbai
Bangalore  |  Pune
Pune       |  Mumbai
Bangalore  |  Chennai
Chennai    |  Pune

The solution for findRoutes('Bangalore', 'Mumbai') should be [Bangalore -> Mumbai, Bangalore -> Pune -> Mumbai]
*/

public class FindRoute
{
	private final static Map<String, List<String>> sourceToAllDestinationsMap;
	private final static List<String> result = new ArrayList<String>();
	private final static String DELIM = " -> ";
	static
	{
		String source;
		List<String> destinations;
		sourceToAllDestinationsMap = new HashMap<String, List<String>>();
		source = "Bangalore";
		destinations = new ArrayList<String>();
		destinations.add( "Mumbai" );
		destinations.add( "Pune" );
		destinations.add( "Chennai" );
		sourceToAllDestinationsMap.put( source, destinations );
		source = "Pune";
		destinations = new ArrayList<String>();
		destinations.add( "Mumbai" );
		sourceToAllDestinationsMap.put( source, destinations );
		source = "Chennai";
		destinations = new ArrayList<String>();
		destinations.add( "Pune" );
		sourceToAllDestinationsMap.put( source, destinations );
	}

	public static void main( String[] args )
	{
		findRoutes( "Bangalore", "Bangalore", "Mumbai" );
		System.out.println( result );
	}

	private static void findRoutes( String source, String mergedString, String destination )
	{
		List<String> destinations = sourceToAllDestinationsMap.get( source );
		if ( destinations != null )
			for ( String connectingStation : destinations )
			{
				if ( connectingStation.equals( destination ) )
				{
					result.add( mergedString + DELIM + destination );
					continue;
				}
				else
					findRoutes( connectingStation, mergedString + DELIM + connectingStation, destination );
			}
	}
}