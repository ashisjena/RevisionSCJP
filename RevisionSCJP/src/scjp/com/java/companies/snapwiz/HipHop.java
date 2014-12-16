package scjp.com.java.companies.snapwiz;

/*
Look for three chars patterns like "hip" and "hop" in the string, starting with 'h' and ending with 'p'. 
Return a string where for all such words, the middle letter is gone, so "hipXhop" yields "hpXhp".
 */

public class HipHop
{
	public static String hip = "hip";
	public static String hop = "hop";
	public static String replaceString = "hp";
	

	public static String hipHop( String str )
	{
		return str.replaceAll( hip, replaceString ).replaceAll( hop, replaceString );
	}

	public static void main( String[] args )
	{
		System.out.println( hipHop( "hipZhop" ) );
		System.out.println( hipHop( "hophop" ) );
		System.out.println( hipHop( "hihapophop" ) );
	}
}