package scjp.com.java.patternSearching;

/*1) Input:
  txt[] =  "THIS IS A TEST TEXT"
  pat[] = "TEST"
Output:
Pattern found at index 10*/

public class StringPatternIndex {
  public static void main(String[] args) {
    String txt = "THIS IS A TEST TEXT";
    String str = "TEST";
    
    System.out.println("Pattern found at : " + findIndex(txt.toCharArray(), str.toCharArray()));
  }

  private static String findIndex(char[] txt, char[] pattern) {
    
    for(int i = 0; i < txt.length - pattern.length; i++)
    {
      int j;
      for(j = 0; j < pattern.length ; j++)
        if(txt[i+j] != pattern[j])
          break;
          
       if( j == pattern.length)
         return String.valueOf(i);
    }
    return "Not Found";
  }
}
