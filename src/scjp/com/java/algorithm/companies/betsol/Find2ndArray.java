package scjp.com.java.algorithm.companies.betsol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Today Oz is playing with two lists A and B. List A contains N elements. List B is formed by replacing every element of List A by average value of all elements before current element including current one. For example :
If list A is like : a, b, c then
list B will be like : a/1, (a+b)/2, (a+b+c)/3
Now you are given list B and you have to find list A. So help Oz with this task.

Input :
First line contain an integer N - size of list B
Second line contains N space separated integers - elements of list B

Output :
Output N space separated integers - elements of list A
Test data is such that list A elements are always integers.

Constraints :
1 ≤ N ≤ 100
1 ≤ value of each element ≤ 109
Sample Input
(Plaintext Link)

4
3 2 3 5

Sample Output
(Plaintext Link)

3 1 5 11*/


public class Find2ndArray {
  public static void main(String[] args) throws Exception {
    try(ConsoleReader reader = ConsoleReader.getInstance())
    {
      reader.readInteger();
      Long[] inputArray = reader.readLineNSplitWithSpace(Long.class);
      
      int index = 1;
      long prev = 0;
      for(long val : inputArray)
      {
        System.out.print(val * index - prev * (index++ - 1));
        System.out.print(" ");
        prev = val;
      }
    }
    catch(Exception e)
    {
      throw e;
    }
    
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
