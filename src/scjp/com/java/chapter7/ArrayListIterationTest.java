package scjp.com.java.chapter7;

import java.util.ArrayList;
import java.util.List;

public class ArrayListIterationTest
{
	public static void main( String[] args )
	{
		List<Integer> list = new ArrayList<Integer>();//Arrays.asList( new Integer[]	{ 2, 4, 5, 1, 7 } );
		
		for(int i = 0; i < 10; i++)
			list.add( i );

		for ( Integer i : list )
		{
			if ( i == 5 )
				list.add( 14 );
			System.out.println( i );
		}
	}
}