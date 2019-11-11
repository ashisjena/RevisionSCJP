package scjp.com.java.algorithm.datastructures.dynamicprogramming.backtracking;

import java.util.HashSet;

public class Combination {
  public static void main(String[] args) {
    combination(new int[]{1, 2, 3, 4}, 3, new HashSet<>(), 0);
  }

  private static void combination(int[] input, int k, HashSet<Integer> set, int start) {
    if (set.size() == k) {
      System.out.println(set);
      return;
    }

    for (int i = start; i < input.length; i++) {
      set.add(input[i]);
      combination(input, k, set, i + 1);
      set.remove(input[i]);
    }
  }
}
