package scjp.com.java.algorithm.datastructures.dynamicprogramming.backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

/*
    Input = "catsanddog"
    dictionary = ["cat", "cats", "and", "sand", "dog"]

    output:
    "cat", "sand", "dog"
    "cats", "and", "dog"
 */
public class ValidWords {
  public static void main(String[] args) {
    String str = "catsanddog";
    HashSet<String> dict = new HashSet<>(Arrays.asList(new String[]{"cat", "cats", "and", "sand", "dog"}));
    wordBreak(str, dict, new Stack<>());
  }

  private static void wordBreak(String input, HashSet<String> dict, Stack<String> partial) {
    if (input.length() == 0) {
      System.out.println(partial);
      return;
    }

    for (int i = 0; i < input.length(); i++) {
      String word = input.substring(0, i + 1);
      if (dict.contains(word)) {
        partial.push(word);
        wordBreak(input.substring(i + 1), dict, partial);
        partial.pop();
      }
    }
  }

}
