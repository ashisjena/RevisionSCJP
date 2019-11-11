package scjp.com.java.algorithm.datastructures.dynamicprogramming.backtracking;

import java.util.Arrays;
import java.util.Stack;

/*
[1, 2, 5]
[1, 7]
[1, 6, 1]
[2, 6]
[2, 1, 5]
[7, 1]
 */

public class SubSetSum {
  public static void main(String[] args) {
//    printSubSet(new int[]{10, 1, 2, 7, 6, 1, 5}, new Stack<>(), 8, 0);
    int[] input = new int[]{10, 1, 2, 7, 6, 1, 5};
    Arrays.sort(input); // sort to avoid duplicates ex. [1,2,5], [2,1,5]
    printSubSet(input, new Stack<>(), 8, 0);
  }

  private static void printSubSet(int[] inputArr, Stack<Integer> partialArr, int remainingSum, int start) {
    if (remainingSum == 0) {
      System.out.println(partialArr);
      return;
    } else if (remainingSum < 0) {
      return;
    }

    for (int i = start; i < inputArr.length; i++) {
      if (i > start && inputArr[i] == inputArr[i - 1]) {
        continue;
      }
      partialArr.push(inputArr[i]);
      printSubSet(inputArr, partialArr, remainingSum - inputArr[i], i + 1);
      partialArr.pop();
    }
  }
}
