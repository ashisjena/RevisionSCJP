package scjp.com.java.algorithm.datastructures.arrays;

import org.junit.Test;
import scjp.com.java.algorithm.datastructures.graph.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TwoNumSumClosestTo0 {

  @Test
  public void listOfPairsWithMinSumTest() {
    assertEquals(Arrays.asList(Pair.of(-3, 3), Pair.of(-2, 2)), listOfPairsWithMinSum(new int[]{-3, 5, 4, 3, -2, 1, 2}));
    assertEquals(Collections.singletonList(Pair.of(1, 2)), listOfPairsWithMinSum(new int[]{3, 4, 1, 2}));
    assertEquals(Collections.singletonList(Pair.of(-2, -1)), listOfPairsWithMinSum(new int[]{-3, -4, -1, -2}));
  }

  public List<Pair> listOfPairsWithMinSum(int[] arr) {
    Arrays.sort(arr);

    SumAndPairs sumAndPairs = new SumAndPairs();
    int i = 0, j = arr.length - 1;
    while (i < j) {
      int sum = Math.abs(arr[i] + arr[j]);
      if (sum <= sumAndPairs.sum) {
        if (sum != sumAndPairs.sum) {
          sumAndPairs.setSum(sum);
          sumAndPairs.clear();
        }
        sumAndPairs.add(Pair.of(arr[i], arr[j]));
      }

      if (arr[i] + arr[j] > 0) {
        j--;
      } else {
        i++;
      }
    }
    return sumAndPairs.pairs;
  }

  class SumAndPairs {
    int sum;
    List<Pair> pairs;

    SumAndPairs() {
      this.sum = Integer.MAX_VALUE;
      this.pairs = new ArrayList<>();
    }

    void add(Pair pair) {
      pairs.add(pair);
    }

    void setSum(int sum) {
      this.sum = sum;
    }

    void clear() {
      this.pairs = new ArrayList<>();
    }
  }
}
