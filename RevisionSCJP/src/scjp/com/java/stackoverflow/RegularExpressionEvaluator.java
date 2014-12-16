package scjp.com.java.stackoverflow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RegularExpressionEvaluator
{
	public static void main( String[] args )
	{
		String longStringExp = "A1 && B && ( CG5 || D )&&(ZZ2 || GRGR ) ";
		List<String> strings = new ArrayList<String>();
		recurr( longStringExp, strings );
		System.out.println( strings );
	}

	private static void recurr( String longStringExpression, List<String> result )
	{
		final int index1 = longStringExpression.indexOf( "(" );
		final int index2 = longStringExpression.indexOf( ")" );

		if ( index1 == -1 && index2 == -1 )
		{
			if ( !( longStringExpression.length() == 0 ) )
				result.addAll( Arrays.asList( longStringExpression.split( "\\s+" ) ) );
			return;
		}

		final int index;

		if ( index1 == -1 )
			index = index2;
		else if ( index2 == -1 )
			index = index1;
		else if ( index1 < index2 )
			index = index1;
		else
			index = index2;

		result.addAll( Arrays.asList( longStringExpression.substring( 0, index ).split( "\\s+" ) ) );
		String remaining = longStringExpression.substring( index );
		result.add( Character.toString( remaining.charAt( 0 ) ) );
		recurr( remaining.substring( 1 ).trim(), result );
	}
}