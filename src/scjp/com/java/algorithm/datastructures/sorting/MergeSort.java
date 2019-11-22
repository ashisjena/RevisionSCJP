package scjp.com.java.algorithm.datastructures.sorting;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MergeSort {
  public static void main(String[] args) {
    int[] arr = {1, 12, 3, 13, 6, 9, 2};
    mergeSortRec(arr, 0, arr.length);
    System.out.println(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(", ")));
  }

  private static void mergeSortRec(int[] arr, int low, int high) {
    if (low + 1 == high) {
      return;
    }

    int mid = (high + low) / 2;
    mergeSortRec(arr, low, mid);
    mergeSortRec(arr, mid, high);
    sortPartial(arr, low, mid, high);
  }

  private static void sortPartial(int[] arr, int low, int mid, int high) {
    int[] partialArr = new int[high - low];

    for (int i = 0, lowIndex = low, midIndex = mid; i < partialArr.length; i++) {
      if (lowIndex == mid) {
        partialArr[i] = arr[midIndex];
        midIndex++;
      } else if (midIndex == high) {
        partialArr[i] = arr[lowIndex];
        lowIndex++;
      } else if (arr[lowIndex] > arr[midIndex]) {
        partialArr[i] = arr[midIndex];
        midIndex++;
      } else {
        partialArr[i] = arr[lowIndex];
        lowIndex++;
      }
    }
    System.arraycopy(partialArr, 0, arr, low, partialArr.length);
  }
}
