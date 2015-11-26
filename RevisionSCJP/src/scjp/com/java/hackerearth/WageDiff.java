package scjp.com.java.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class WageDiff {
  public static void main(String args[]) throws Exception {
    ConsoleReader reader = ConsoleReader.getInstance();
    List<String> results = new ArrayList<>();
    int noOfTestCases = reader.readInteger();
    for(int i = 0; i < noOfTestCases; i++)
    {
      int noOfDays = reader.readInteger();
      Integer[] wagesOfA = reader.readLineNSplitWithSpace(Integer.class);
      Integer[] wagesOfB = reader.readLineNSplitWithSpace(Integer.class);
      for(int j = 0; j < noOfDays; j++)
        if(wagesOfA[j] != wagesOfB[j])
          results.add(wagesOfA[j] + " " + wagesOfB[j]);
    }
    
    for(String result : results)
      System.out.println(result);
  }
}


final class ConsoleReader
{
    private final BufferedReader br;

    private static class LazyHolder
    {
        private static ConsoleReader INSTANCE = new ConsoleReader();
    }

    public static ConsoleReader getInstance()
    {
        return LazyHolder.INSTANCE;
    }

    private ConsoleReader()
    {
        if ( LazyHolder.INSTANCE != null )
            throw new RuntimeException( "ConsoleReader Singleton object is already intitialized" );

        br = new BufferedReader( new InputStreamReader( System.in ) );
    }

    public String readLine() throws IOException
    {
        return this.br.readLine();
    }

    public int readInteger() throws NumberFormatException, IOException
    {
        return Integer.parseInt( readLine() );
    }

    public long readLong() throws NumberFormatException, IOException
    {
        return Long.parseLong( readLine() );
    }

    public double readDouble() throws NumberFormatException, IOException
    {
        return Double.parseDouble( readLine() );
    }

    @SuppressWarnings( "unchecked" )
    public <T> T[] readLineNSplitWithSpace( Class<T> clazz ) throws IOException
    {
        final String[] words = readLine().split( "\\s+" );
        int i = 0;
        if ( clazz.equals( String.class ) )
            return ( T[] ) words;
        else if ( clazz.equals( Integer.class ) )
        {
            final Integer[] arr = new Integer[words.length];
            for ( String str : words )
                arr[i++] = Integer.parseInt( str );
            return ( T[] ) arr;
        }
        else if ( clazz.equals( Long.class ) )
        {
            final Long[] arr = new Long[words.length];
            for ( String str : words )
                arr[i++] = Long.parseLong( str );
            return ( T[] ) arr;
        }
        else if ( clazz.equals( Double.class ) )
        {
            final Double[] arr = new Double[words.length];
            for ( String str : words )
                arr[i++] = Double.parseDouble( str );
            return ( T[] ) arr;
        }
        else
            throw new RuntimeException( "Wrong type specified" );
    }

    public String[] readLineNSplitLetterWise() throws IOException
    {
        return readLine().split( "(?!^)" );
    }

    public void close() throws IOException
    {
        this.br.close();
        LazyHolder.INSTANCE = null;
    }
}