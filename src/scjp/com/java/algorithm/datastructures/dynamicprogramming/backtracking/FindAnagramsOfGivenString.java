package scjp.com.java.algorithm.datastructures.dynamicprogramming.backtracking;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

/*
  "god"

  "god"
  "gdo"
  "dog"
  "dgo"
  "ogd"
  "odg"
 */
public class FindAnagramsOfGivenString {
  public static void main(String[] args) {
    String str = "good";
//    printAllAnagrams(str, new Stack<>());
    char[] inputArray = str.toCharArray();
    Arrays.sort(inputArray);
    printAllAnagrams(inputArray, new char[str.length()], new boolean[str.length()], 0);
  }

  static void printAllAnagrams(char[] input, char[] anagram, boolean[] isVisited, int index) {
    if (index == input.length) {
      System.out.println(String.copyValueOf(anagram));
      return;
    }

    for (int i = 0; i < input.length; i++) {
      if (!isVisited[i] && !(i > 0 && input[i] == input[i - 1] && !isVisited[i - 1])) { // The second condition is for nearby duplicate characters
        isVisited[i] = true;
        anagram[index] = input[i];
        printAllAnagrams(input, anagram, isVisited, index + 1);
        isVisited[i] = false;
      }
    }
  }

  static void printAllAnagrams(String input, Stack<Character> partial) {
    if (input.length() == 0) {
      System.out.println(partial.stream().map(String::valueOf).collect(Collectors.joining()));
    }

    for (int i = 0; i < input.length(); i++) {
      partial.push(input.charAt(i));
      printAllAnagrams(input.substring(0, i) + input.substring(i + 1), partial);
      partial.pop();
    }
  }
}
