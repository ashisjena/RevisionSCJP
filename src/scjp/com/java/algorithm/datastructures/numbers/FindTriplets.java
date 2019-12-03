package scjp.com.java.algorithm.datastructures.numbers;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/*
  Array:- {1, 2, 3, 4, 6, 8}. the arrangement can be random order
  Find the triplets where (a + c)/2 = b
  Ans: {2, 4, 3} and {4, 6, 8}
  The numbers in the triplets should be unique.
  Find the max no of triplets that can be formed.
 */
public class FindTriplets {
  private void assertTriplets(List<List<Integer>> expected, int[] arr) {
    Arrays.sort(arr);
    assertEquals(expected, findTriplets(arr, arr.length - 2));
  }

  private void assertMaxUniqueTripletsCount(int maxUnique, int[] arr) {
    Arrays.sort(arr);
    assertEquals(maxUnique, maxUniqueTripletsCount(findTriplets(arr, arr.length - 2), 0));
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
    assertTriplets(Arrays.asList(
        Arrays.asList(4, 6, 8),
        Arrays.asList(1, 5, 9),
        Arrays.asList(2, 5, 8),
        Arrays.asList(4, 5, 6),
        Arrays.asList(2, 4, 6)), new int[]{1, 2, 4, 5, 6, 8, 9});
  }

  @Test
  public void maxUniqueTripletsCountTest() {
    assertMaxUniqueTripletsCount(2, new int[]{2, 3, 5, 6, 8, 9, 10});
    assertMaxUniqueTripletsCount(2, new int[]{1, 2, 6, 3, 5, 8, 4});
    assertMaxUniqueTripletsCount(3, new int[]{1, 4, 5, 6, 7, 8, 9, 10, 12, 13});
    assertMaxUniqueTripletsCount(2, new int[]{1, 2, 4, 5, 6, 8, 9, 11, 12});
  }

  // Time Complexity O(n)^2
  public List<List<Integer>> findTriplets(int[] arr, int mid) {
    List<List<Integer>> result = new ArrayList<>();
    if (arr.length < 3 || mid < 1) {
      return result;
    }

    int start = 0, end = arr.length - 1;
    while (start < mid && end > mid) {
      if (arr[start] + arr[end] == arr[mid] * 2) {
        result.add(Arrays.asList(arr[start], arr[mid], arr[end]));
        start++;
        end--;
      } else if (arr[start] + arr[end] > arr[mid] * 2) {
        end--;
      } else {
        start++;
      }
    }

    result.addAll(findTriplets(arr, mid - 1));
    return result;
  }

  public int maxUniqueTripletsCount(List<List<Integer>> triplets, int pos) {
    if (pos == triplets.size()) {
      return 0;
    }

    final Set<Integer> set = new HashSet<>(triplets.get(pos));
    int result1 = 1;
    for (List<Integer> triplet : triplets) {
      if (triplet == triplets.get(pos)) {
        continue;
      }
      if (!set.contains(triplet.get(0)) &&
          !set.contains(triplet.get(1)) &&
          !set.contains(triplet.get(2))) {
        set.addAll(triplet);
        result1++;
      }
    }

    int result2 = maxUniqueTripletsCount(triplets, pos + 1);
    return Math.max(result1, result2);
  }
}
