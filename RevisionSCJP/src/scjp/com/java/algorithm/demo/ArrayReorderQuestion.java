package scjp.com.java.algorithm.demo;

import java.util.Arrays;

public class ArrayReorderQuestion
{
	public static void main( String[] args )
	{
		String[] abc =
		{ "Rama", "Hari", "", "Shyama", "", "", "Govind" };
		method( abc );
		System.out.println( Arrays.toString( abc ) );
	}

	private static void method( String[] abc )
	{
		int countOfEmpty = 1;
		for ( int i = abc.length - 1; i >= 0; i-- )
		{
			String str = abc[i];
			if ( str.equals( "" ) )
			{
				for ( int j = i - countOfEmpty; j >= 0; j-- )
				{
					String next = abc[j];
					if ( !next.equals( "" ) )
					{
						abc[i] = next;
						abc[j] = str;
						break;
					}
					else
						countOfEmpty++;
				}
			}
		}
	}
}
