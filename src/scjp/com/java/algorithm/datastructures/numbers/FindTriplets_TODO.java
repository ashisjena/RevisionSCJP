package scjp.com.java.algorithm.datastructures.numbers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/*
  Array:- {1, 2, 3, 4, 6, 8}
  Find the triplets where (a + c)/2 = b
  Ans: {2, 4, 3} and {4, 6, 8}
  // The numbers in the triplets should be unique.
  Find the max no of triplets that can be formed.
 */
public class FindTriplets_TODO {
  private void assertTriplets(List<List<Integer>> expected, int[] arr) {
    Arrays.sort(arr);
    assertEquals(expected, findTriplets(arr, arr.length - 1));
  }

  @Test
  public void findTripletsTest() {
    assertTriplets(new ArrayList<>(), new int[0]);
    assertTriplets(new ArrayList<>(), new int[]{1, 2});
    assertTriplets(Collections.singletonList(Arrays.asList(1, 2, 3)), new int[]{1, 2, 3});
    assertTriplets(Collections.singletonList(Arrays.asList(2, 5, 8)), new int[]{2, 3, 5, 6, 8});
    assertTriplets(Arrays.asList(Arrays.asList(3, 6, 9), Arrays.asList(2, 5, 8)), new int[]{2, 3, 5, 6, 8, 9});
    assertTriplets(Arrays.asList(
            Arrays.asList(8, 9, 10),
            Arrays.asList(6, 8, 10),
            Arrays.asList(2, 6, 10),
            Arrays.asList(3, 6, 9),
            Arrays.asList(2, 5, 8)), new int[]{2, 3, 5, 6, 8, 9, 10});
  }

  public List<List<Integer>> findTriplets(int[] arr, int end) {
    List<List<Integer>> result = new ArrayList<>();
    if (arr.length < 3 || end < 2) {
      return result;
    }

    int l = 0, m = end - 1;
    while (l < m) {
      if (arr[l] + arr[end] == arr[m] * 2) {
        result.add(Arrays.asList(arr[l], arr[m], arr[end]));
        break;
      }

      if (arr[l] + arr[end] < arr[m] * 2) {
        m--;
      } else {
        l++;
      }
    }

    /*for (int m = end - 1; 0 < m; m--) {
      for (int i = 0; i < m; i++) {
        if (arr[i] + arr[end] == arr[m] * 2) {
          result.add(Arrays.asList(arr[i], arr[m], arr[end]));
          break;
        }
      }
    }*/
    result.addAll(findTriplets(arr, end - 1));
    return result;
  }
}
