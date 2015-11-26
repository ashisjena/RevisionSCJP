package scjp.com.java.dynamicProgramming;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.print.attribute.standard.PrinterMoreInfoManufacturer;

public class AnagramString
{
	static int counter1 = 0;
	static int counter2 = 0;

	public static void main( String[] args )
	{
		String str = "abcde";
		String prefix = "";
		List<String> anagrams1 = new ArrayList<String>();
		List<String> anagrams2 = new ArrayList<String>();
		permutation( prefix, str, anagrams1 );
		permutation( str, anagrams2 );
		System.out.println( counter1++ );
		System.out.println( anagrams1 );
		System.out.println( counter2++ );
		System.out.println( anagrams2 );
	}

	private static void permutation( String prefix, String str, List<String> anagrams )
	{
	  counter1++;
	  if(str.length() == 0)
	  {
	    anagrams.add(prefix);
	    return;
	  }
	  for(int i = 0; i < str.length(); i++)
	    permutation(prefix + str.charAt(i), str.substring(0,i) + str.substring(i+1),anagrams);
	}

	private static void permutation( String str, List<String> anagrams )
	{
		char[] chars = str.toCharArray();
		LinkedList<Character> queue = new LinkedList<Character>();
		for ( char ch : chars )
			queue.add( ch );

		int length = chars.length;

		for ( int index = 0; index < length; index++ )
		{
			LinkedList<Character> subQueue = new LinkedList<Character>( queue );
			String prefix = "";
			for ( int j = 0; j < length - 1; j++ )
			{
				prefix += subQueue.poll();

				for ( int m = 0; m < subQueue.size(); m++ )
				{
					String result = prefix;
					for ( Character chrs : subQueue )
					{
						result += chrs;
						counter2++;
					}

					anagrams.add( result );
					subQueue.offer( subQueue.poll() );
				}
			}
			queue.offer( queue.poll() );
		}
	}
}