package scjp.com.java.algorithm.recursion;

import java.util.Arrays;
import java.util.stream.Collectors;

public class GenerateAllStringsOfLengthN {
  public static int noOfElements = 3;
  public static int maxValue = 5;

  public static void main(String[] args) {
    int[] arr = new int[noOfElements];

    recurr(noOfElements, maxValue, arr);
  }

  private static void recurr(int noOfElements, int maxValue, int[] arr) {
    if (noOfElements == 0) {
      System.out.println(Arrays.toString(arr));
      return;
    }

    for (int i = 1; i <= maxValue; i++) {
      arr[noOfElements - 1] = i;
      recurr(noOfElements - 1, maxValue, arr);
    }
  }


}