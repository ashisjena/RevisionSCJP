package scjp.com.java.companies.snapwiz;

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

/*private static List<String> findRoutes( String source, String destination )
	{
		List<String> result = new ArrayList<String>();
		List<String> level1Destination = sourceToAllDestinationsMap.get( source );

		if ( level1Destination != null )
			for ( String conn1Station : level1Destination )
			{
				if ( destination.equals( conn1Station ) )
				{
					result.add( source + " -> " + destination );
					continue;
				}

				List<String> level2Destination = sourceToAllDestinationsMap.get( conn1Station );
				if ( level2Destination == null )
					continue;
				else
				{
					for ( String conn2Station : level2Destination )
					{
						if ( destination.equals( conn2Station ) )
						{
							result.add( source + " -> " + conn1Station + " -> " + destination );
							continue;
						}

						List<String> level3Destination = sourceToAllDestinationsMap.get( conn2Station );
						if ( level3Destination == null )
							continue;
						else
						{
							for ( String conn3Station : level3Destination )
							{
								if ( destination.equals( conn3Station ) )
								{
									result.add( source + " -> " + conn1Station + " -> " + conn2Station + " -> " + destination );
									continue;
								}
							}
						}
					}
				}
			}

		return result;
	}*/