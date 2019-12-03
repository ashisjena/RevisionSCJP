package scjp.com.java.algorithm.datastructures.arrays;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

// sort-array-containing-0s-1s-2s-dutch-national-flag-problem
// — Dutch National Flag Algorithm, or 3-way Partitioning —
public class SortArrayWith012 {

  private void assertSortedArray(int[] sortedArr, int[] arr) {
    sortArray(arr);
    assertArrayEquals(sortedArr, arr);
  }

  @Test
  public void sortArrayTest() {
    assertSortedArray(new int[0], new int[0]);
    assertSortedArray(new int[]{0, 1, 2}, new int[]{0, 1, 2});
    assertSortedArray(new int[]{0, 1, 2}, new int[]{1, 0, 2});
    assertSortedArray(new int[]{0, 0, 0, 1, 1, 1, 1, 2, 2, 2}, new int[]{1, 1, 2, 0, 2, 1, 0, 1, 2, 0});
  }

  private void sortArray(int[] arr) {
    int low = 0, mid = 0, high = arr.length - 1;

    while (mid <= high) {
      switch (arr[mid]) {
        case 0:
          swap(arr, low, mid);
          low++;
          mid++;
          break;
        case 1:
          mid++;
          break;
        case 2:
          swap(arr, mid, high);
          high--;
          break;
      }
    }
  }

  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
