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
    if (high - low <= 1) {
      return;
    }

    int mid = (high + low) / 2;
    mergeSortRec(arr, low, mid);
    mergeSortRec(arr, mid, high);
    sortPartial(arr, low, mid, high);
  }

  private static void sortPartial(int[] arr, int low, int mid, int high) {
    int[] partialArr = new int[high - low];

    for (int i = 0, j = low, k = mid; i < partialArr.length; i++) {
      if (j == mid) {
        partialArr[i] = arr[k];
        k++;
      } else if (k == high) {
        partialArr[i] = arr[j];
        j++;
      } else if (arr[j] > arr[k]) {
        partialArr[i] = arr[k];
        k++;
      } else {
        partialArr[i] = arr[j];
        j++;
      }
    }
    System.arraycopy(partialArr, 0, arr, low, partialArr.length);
  }
}
