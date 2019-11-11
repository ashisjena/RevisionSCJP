package scjp.com.java.algorithm.datastructures.dynamicprogramming.backtracking;

import java.util.Stack;

public class Permutation {

  /*
      Pseudo code
      function(input, partial, output...) {
        if(isValidSolution(partial) {
          processSolution(partial) {
            return;
          }
        }

        candidates = generateCandidates(input, partial);
        for(c in candidate) {
          addCandidate(c, input, partial);
          function(input, partial, output);
          removeCandidate(c, input, partial);
        }
      }
   */

  public static void main(String[] args) {
    permutation(new int[]{1, 2, 3, 4}, new Stack<>(), new boolean[4]);
  }

  private static void permutation(int[] input, Stack<Integer> partial, boolean[] isVisited) {
    if (partial.size() == input.length) {
      System.out.println(partial);
      return;
    }

    for (int i = 0; i < input.length; i++) {
      if (!isVisited[i]) {
        partial.push(input[i]);
        isVisited[i] = true;
        permutation(input, partial, isVisited);
        isVisited[i] = false;
        partial.pop();
      }
    }
  }
}
