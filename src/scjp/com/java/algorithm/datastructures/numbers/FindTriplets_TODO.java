package scjp.com.java.algorithm.datastructures.numbers;

import org.junit.Test;

import java.util.*;

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

  private void assertMaxUniqueTriplets(int maxUnique, int[] arr) {
    Arrays.sort(arr);
//    assertEquals(maxUnique, maxUniqueTriplets(findTriplets(arr, arr.length - 1)));
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

  @Test
  public void maxUniqueTripletsTest() {
//    assertMaxUniqueTriplets(2, new int[]{2, 3, 5, 6, 8, 9, 10});
    assertMaxUniqueTriplets(2, new int[]{1, 2, 6, 3, 5, 8, 4});
  }

  // Time Complexity O(n)^2
  public List<List<Integer>> findTriplets(int[] arr, int mid) {
    List<List<Integer>> result = new ArrayList<>();
    if (arr.length < 3 || mid < 1) {
      return result;
    }

    int i = 0, j = arr.length - 1;
    while (i < mid && j > mid) {
      if (arr[i] + arr[j] == arr[mid] * 2) {
        result.add(Arrays.asList(arr[i], arr[mid], arr[j]));
        i++;
        j--;
      } else if (arr[i] + arr[j] > arr[mid] * 2) {
        j--;
      } else {
        i++;
      }
    }

    result.addAll(findTriplets(arr, mid - 1));
    return result;
  }

  public int maxUniqueTriplets(List<List<Integer>> triplets, Set<Integer> set, int start) {
    /*if(start == triplets.size()) {
      return 0;
    } else if(start + 1 = triplets.size()
    )

    int result = 1;
    for(int i = start; i < triplets.size(); i++) {

    }*/
    return 0;
  }

  private boolean areUnique(List<Integer> triplet1, List<Integer> triplet2) {
    if (triplet1 == triplet2) {
      return false;
    }

    int i = 0, j = 0;
    while (i < 3 && j < 3) {
      if (triplet1.get(i) > triplet2.get(j)) {
        j++;
      } else if (triplet1.get(i) < triplet2.get(j)) {
        i++;
      } else {
        return false;
      }
    }
    return true;
  }
}
