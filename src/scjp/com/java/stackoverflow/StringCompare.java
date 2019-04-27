package scjp.com.java.stackoverflow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCompare
{
    public static final String delimiter = " ";

    public static void main( String[] args )
    {
        String[] given = new String[20];
        given[ 0 ] = ( "do some java programming" );
        given[ 1 ] = ( "do some grocery shopping" );
        given[ 2 ] = ( "play soccer at the west field" );

        List< List< String >> listLineAsWords = new ArrayList< List< String >>();

        //split each line and store it as list.
        for ( String line : given )
        {
            if ( line == null )
                break;
            listLineAsWords.add( Arrays.asList( line.split( delimiter ) ) );
        }

        //Write your own logic to get the input line
        String inputLine = "programming do java";
        if ( compareLine( inputLine, listLineAsWords ) )
            System.out.println( "The input line is part of given lines" );
    }

    private static boolean compareLine( String inputLine, List< List< String >> listLineAsWords )
    {
        if ( inputLine == null )
            return false;
        List< String > words = Arrays.asList( inputLine.split( delimiter ) );
        for ( List< String > listOfWords : listLineAsWords )
        {
            boolean isPartOfLine = true;
            for ( String word : words )
            {
                if ( !listOfWords.contains( word ) )
                {
                    isPartOfLine = false;
                    break;
                }
            }
            if ( isPartOfLine )
                return true;
        }
        return false;
    }
}
