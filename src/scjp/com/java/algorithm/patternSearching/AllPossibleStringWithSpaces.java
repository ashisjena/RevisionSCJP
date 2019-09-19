package scjp.com.java.algorithm.patternSearching;

/*
Input:  str[] = "ABC"
Output: ABC
        AB C
        A BC
        A B C
 */

public class AllPossibleStringWithSpaces {
  public static void main(String[] args) {
    String str = "ABC";
    printPatternUtil(str, String.valueOf(str.charAt(0)), 1);
  }

  static void printPatternUtil(String str, String result, int i) {
    if (i == str.length()) {
      System.out.println(result);
      return;
    }

    // Either put the character
    printPatternUtil(str, result + str.charAt(i), i + 1);

    // Or put a space followed by next character
    printPatternUtil(str, result + " " + str.charAt(i), i + 1);
  }
}
