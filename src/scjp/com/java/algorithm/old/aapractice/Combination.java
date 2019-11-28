package scjp.com.java.algorithm.old.aapractice;

import java.util.Arrays;

public class Combination {

  public static void main(String[] args) {
    String[] arr = {"A", "B", "C", "D", "E", "F", "G"};
    combinationRecurr(arr, 3, 0, new String[3]);
  }

  static void combinationRecurr(String[] arr, int len, int startPosition, String[] result) {
    if (len == 0) {
      System.out.println(Arrays.toString(result));
      return;
    }
    for (int i = startPosition; i <= arr.length - len; i++) { // arr.length - len.. As last len items are one combination.
      result[result.length - len] = arr[i];
      combinationRecurr(arr, len - 1, i + 1, result);
    }
  }
}
