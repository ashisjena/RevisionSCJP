package scjp.com.java.algorithm.datastructures.dictionaries;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SherlockAnagrams {
  public static void main(String[] args) {
    String input = "kkkk";
    int result = sherlockAndAnagrams(input);
    System.out.println(result);
  }

  static int sherlockAndAnagrams(String s) {
    int result = 0;
    char[] charArr = s.toCharArray();
    for (int k = 0; k < charArr.length - 1; k++) {
      final Set<String> uniqueSubStrings = new HashSet<>();
      for (int i = k; i < charArr.length; i++) {
        if (!uniqueSubStrings.add(Character.toString(charArr[i]))) {
          result++;
        }

        for (int j = i + 1; j < charArr.length; j++) {
          char[] destArr = new char[j - i + 1];
          System.arraycopy(charArr, i, destArr, 0, j - i + 1);
          Arrays.sort(destArr);
          String uniqueSubString = String.copyValueOf(destArr);
          if (!uniqueSubStrings.add(uniqueSubString)) {
            result++;
          }
        }
      }
    }
    return result;
  }
}
