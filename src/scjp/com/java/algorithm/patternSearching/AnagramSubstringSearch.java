package scjp.com.java.algorithm.patternSearching;

// Manacher�s Algorithm
/*1) Input:  txt[] = "BACDGABCDA"  pat[] = "ABCD"
Output:   Found at Index 0
          Found at Index 5
          Found at Index 6
2) Input: txt[] =  "AAABABAA" pat[] = "AABA"
Output:   Found at Index 0
          Found at Index 1
          Found at Index 4*/

public class AnagramSubstringSearch {

  public static int MAX = 256;
  
  public static void main(String[] args) {
    String txt = "BACDGABCDA";
    String part = "ABCD";
    char[] txtChars = txt.toCharArray();
    char[] partChars = part.toCharArray();
    byte[] countTxt = new byte[MAX];
    byte[] countPart = new byte[MAX];
    
    // Count the number of characters and store it with byte array.
    for(int i = 0; i < part.length(); i++)
    {
      countTxt[txtChars[i]]++;  // using characters as index
      countPart[partChars[i]]++;
    }
      
    // Rendering rest of the string
    for(int i = part.length(); i < txt.length(); i++ )
    {
      if(compare(countTxt, countPart))
        System.out.println("Fount at Index : " + (i - part.length()));
      
      //Increase current character count
      countTxt[txtChars[i]]++;
      
      //Decrease the first character of previous window
      countTxt[txtChars[i - part.length()]]--;
    }
    
    // check for the last window
    if(compare(countTxt, countPart))
      System.out.println("Fount at Index : " + (txt.length() - part.length()));
  }

  private static boolean compare(byte[] countTxt, byte[] countPart) {
    for(int i = 0; i < MAX; i++)
      if(countTxt[i] != countPart[i])
        return false;
    
    return true;
  }
}
