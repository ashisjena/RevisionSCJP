package scjp.com.java.algorithm.datastructures.Arrays;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// https://www.hackerrank.com/challenges/minimum-swaps-2/problem
// https://www.geeksforgeeks.org/minimum-number-swaps-required-sort-array/
public class MinimumSwaps {

  public static void main(String[] args) {
//    int swapCount = minimumSwaps(new int[]{1, 3, 7, 2, 4, 5, 6});
//    int swapCount = minimumSwaps(new int[]{3, 7, 6, 9, 1, 8, 10, 4, 2, 5});
    int swapCount = minimumSwaps(new int[]{2, 4, 5, 1, 3});
    System.out.println(swapCount);
  }

  static int minimumSwaps(int[] arr) {
    List<Pair<Integer, Integer>> arrPos = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      arrPos.add(new Pair<>(arr[i], i));
    }

    arrPos.sort(Comparator.comparing(Pair::getKey));

    boolean[] visited = new boolean[arr.length];
    int swapCount = 0;

    for (int i = 0; i < arr.length; i++) {
      if (visited[i] || arrPos.get(i).getValue() == i) {
        continue;
      }

      int cycleSize = 0;
      int j = i;
      while (!visited[j]) {
        visited[j] = true;
        // move to next node
        j = arrPos.get(j).getValue();
        cycleSize++;
      }
      if (cycleSize > 0) {
        swapCount += cycleSize - 1;
      }
    }
    return swapCount;
  }
}
