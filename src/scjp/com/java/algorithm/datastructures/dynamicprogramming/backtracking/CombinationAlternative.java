package scjp.com.java.algorithm.datastructures.dynamicprogramming.backtracking;

import java.util.HashSet;

public class CombinationAlternative {
  public static void main(String[] args) {
    combinationAlternative(new int[]{1, 2, 3, 4}, new HashSet<>(), 0, 3);
  }

  private static void combinationAlternative(int[] input, HashSet<Integer> partial, int i, int k) {
    if (partial.size() == k) {
      System.out.println(partial);
      return;
    } else if (i == input.length) {
      return;
    }

    partial.add(input[i]);
    combinationAlternative(input, partial, i + 1, k);

    partial.remove(input[i]);
    combinationAlternative(input, partial, i + 1, k);
  }
}
