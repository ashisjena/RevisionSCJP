package scjp.com.java.algorithm.patternSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramString
{
	static int counter1 = 0;
	static int counter2 = 0;

	public static void main( String[] args )
	{
		String str = "abc";
		String prefix = "";
		List<String> anagrams1 = new ArrayList<String>();
		permutation( prefix, str, anagrams1 );
		System.out.println( counter1++ );
		System.out.println( anagrams1 );
		permutation2(str.toCharArray(), 0);
		System.out.println( counter2++ );
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
	
	private static void permutation2(char[] strArr, int i)
	{
	  counter2++;
	  if( i == strArr.length)
	  {
	    System.out.println(Arrays.toString(strArr));
	    return;
	  }
	  
	  for(int j = i; j < strArr.length; j++)
	  {
    	  swap(strArr, i, j);
    	  permutation2(strArr, i + 1);
    	  swap(strArr, i, j);
	  }
	}

  private static void swap(char[] strArr, int i, int j) {
    char temp = strArr[i];
    strArr[i] = strArr[j];
    strArr[j] = temp;
  }
}