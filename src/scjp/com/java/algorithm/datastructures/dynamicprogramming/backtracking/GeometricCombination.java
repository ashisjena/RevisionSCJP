package scjp.com.java.algorithm.datastructures.dynamicprogramming.backtracking;

import java.util.Stack;

public class GeometricCombination {

  public static void main(String[] args) {
    printCombination(new int[]{1, 2, 3, 3, 6, 9, 27, 6, 5, 18}, new Stack<>(), 3, 3, 0);
  }

  private static void printCombination(int[] input, Stack<Integer> stack, int r, int k, int start) {
    if (stack.size() == k) {
      System.out.println(stack);
      return;
    }

    for (int i = start; i < input.length; i++) {
      if (stack.isEmpty() || (stack.peek() * r == input[i])) {
        stack.push(input[i]);
        printCombination(input, stack, r, k, i + 1);
        stack.pop();
      }
    }
  }
}
