package scjp.com.java.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class ConsoleReader
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
			throw new RuntimeException( "Singleton object is already intitialized" );

		br = new BufferedReader( new InputStreamReader( System.in ) );
	}

	public String readLine() throws IOException
	{
		return this.br.readLine();
	}

	public int readInteger() throws NumberFormatException, IOException
	{
		return Integer.parseInt( this.br.readLine() );
	}

	public long readLong() throws NumberFormatException, IOException
	{
		return Long.parseLong( this.br.readLine() );
	}

	public double readDouble() throws NumberFormatException, IOException
	{
		return Double.parseDouble( this.br.readLine() );
	}

	@SuppressWarnings( "unchecked" )
	public <T> T[] readLineNSplitWithSpace( Class<T> clazz ) throws IOException
	{
		final String line = readLine();
		int i = 0;
		if ( clazz.equals( String.class ) )
			return ( T[] ) line.split( "\\s+" );
		else if ( clazz.equals( Integer.class ) )
		{
			final Integer[] arr = new Integer[line.length()];
			for ( String str : line.split( "\\s+" ) )
				arr[i++] = Integer.parseInt( str );
			return ( T[] ) arr;
		}
		else if ( clazz.equals( Long.class ) )
		{
			final Long[] arr = new Long[line.length()];
			for ( String str : line.split( "\\s+" ) )
				arr[i++] = Long.parseLong( str );
			return ( T[] ) arr;
		}
		else if ( clazz.equals( Double.class ) )
		{
			final Double[] arr = new Double[line.length()];
			for ( String str : line.split( "\\s+" ) )
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