package scjp.com.java.algorithm.old.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
  public static void main(String[] args) {
    printPermutation(new Integer[]{1, 2, 3, 4}, 2);
  }

  // allElements is the original array
  // r is the number of elements in each permutation
  public static void printPermutation(Integer[] allElements, int r) {
    List<List<Integer>> allPermutations = new ArrayList<>();
    permutation1(allElements, allElements.length, r, allPermutations);
    allPermutations.stream()
                   .forEach(System.out::println);
  }

  // allElements is the original array
  // n is the array size
  // r is the number of elements in each permutation
  // allPermutations is all different permutations
  private static void permutation1(Integer[] allElements, int n, int r, List<List<Integer>> allPermutations) {
    if (r == 0) {
      Integer[] singlePermutation = new Integer[allElements.length - n];
      System.arraycopy(allElements, n, singlePermutation, 0, allElements.length - n);
      allPermutations.add(Arrays.asList(singlePermutation));
      return;
    }

    for (int i = 0; i < n; i++) {
      swap(allElements, i, n - 1);
      permutation1(allElements, n - 1, r - 1, allPermutations);
      swap(allElements, i, n - 1);
    }
  }

  // helper function that swaps allElements.get(i) and allElements.get(j)
  public static void swap(Integer[] allElements, int i, int j) {
    Integer temp = allElements[i];
    allElements[i] = allElements[j];
    allElements[j] = temp;
  }
}