package scjp.com.java.algorithm.old.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Anagram {
  public static void main(String[] args) {
    String str = "abcd";
    List<String> values = new ArrayList<String>();
    anagram("", str, values);
    System.out.println(values);

    doAnagram(str.length(), str.toCharArray());
    System.out.println();
  }

  public static void anagram(String prefix, String str, List<String> values) {
    if (str.length() == 0)
      values.add(prefix);

    for (int i = 0; i < str.length(); i++)
      anagram(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1), values);
  }

  public static void doAnagram(int newSize, char[] arr) {
    if (newSize == 1) // if too small,
      return;

    for (int j = 0; j < newSize; j++) // for each position,
    {
      doAnagram(newSize - 1, arr); // anagram remaining
      if (newSize == 2) // if innermost,
        System.out.print(Arrays.toString(arr) + "\t");
      rotate(newSize, arr); // rotate word
    }
  }

  // rotate left all chars from position to end
  public static void rotate(int newSize, char[] arr) {
    int j;
    int position = arr.length - newSize;
    char temp = arr[position]; // save first letter
    for (j = position + 1; j < arr.length; j++)
      arr[j - 1] = arr[j];

    arr[j - 1] = temp; // put first on right
  }
}