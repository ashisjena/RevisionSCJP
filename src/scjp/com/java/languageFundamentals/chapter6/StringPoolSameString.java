package scjp.com.java.languageFundamentals.chapter6;

public class StringPoolSameString
{
	public static void main( String[] args )
	{
		int[] arr =
		{ 3, 5, 6, 1, 6, 3, 7 };

		String str1 = "";
		String str2 = "";

		if ( str1 == str2 )
			System.out.println( "Same" );
		else
			System.out.println( "Not Same" );

		for ( int value : arr )
			str1 += value + "~";

		for ( int value : arr )
			str2 += value + "~";

		System.out.println( str1 );
		System.out.println( str2 );

		if ( str1 == str2 )
			System.out.println( "Same" );
		else
			System.out.println( "Not Same" );
	}
}