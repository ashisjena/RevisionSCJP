package scjp.com.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CleanAfterTest {
    public static void main(String[] args) throws IOException {
    StringBuilder result = new StringBuilder();
    try (ConsoleReader reader = ConsoleReader.getInstance()) {
      for (int i = reader.readInteger(); i > 0; i--) {
        Long[] input = reader.readLineNSplitWithSpace(Long.class);
        long a = input[0], b = input[1];
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (b != 0)
        {
          if ((b & 1) != 0)
          {
            sb.insert(0, "(" + a + "<<" + count + ") + ");
          }

          b >>= 1;
          count++;
        }
        result.append(sb.substring(0, sb.length() - 3) + System.lineSeparator());
      }
    } catch (IOException e) {
      throw e;
    }
    System.out.println(result.toString());
  }
}

final class ConsoleReader implements AutoCloseable
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

    @Override
    public void close() throws IOException
    {
        this.br.close();
        LazyHolder.INSTANCE = null;
    }
}

