package scjp.com.java;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CleanAfterTest
{

	public static final String CELL_OFFSET_REGEX = "\\(\\s*-?\\d\\s*,\\s*-?\\d\\s*\\)";

	public static void main( String[] args )
	{
		String str = "(           1, 3 )";

		if ( "(1,3)".matches( CELL_OFFSET_REGEX ) )
			System.out.println( "True" );
		else
			System.out.println( "False" );

		System.out.println( Arrays.deepToString( str.replaceAll( "\\(|\\)|\\s*", "" ).split( "," ) ) );

		System.out.println( convertUnderScoreToCamelCase( "rama_is_nice" ) );
		str = "RamaIsNice";
		System.out.println( str.trim().replaceAll( "([a-z0-9])([A-Z])", "$1_$2" ) );

		int abc = 10;
		Object xyz = abc;
		System.out.println( xyz.getClass() );
		System.out.println( 256 * ( 1 << 20 ) );
		System.out.println( Arrays.deepToString( "rama".split( "(?!^)" ) ) );

		str = "how much IS pish tegj glob glob ?";
		System.out.println( str.replaceAll( "((?i)How (?i)much (?i)is )|([\\s][\\?])", "" ) );
	}

	public static String convertUnderScoreToCamelCase( String str )
	{
		Pattern p = Pattern.compile( "_(.)" );
		Matcher m = p.matcher( str );
		StringBuffer sb = new StringBuffer();
		while ( m.find() )
		{
			m.appendReplacement( sb, m.group( 1 ).toUpperCase() );
		}

		m.appendTail( sb );
		return sb.toString();
	}

}