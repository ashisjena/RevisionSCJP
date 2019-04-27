package scjp.com.java.algorithm.sorting;

import java.util.Arrays;

public class MergeSort {

  public static void main(String[] args) {
    Integer arr[] = {3, 2, 101, 5, 1, 6, 1, 23, 4, 8};
    mergeSort(arr, 0, arr.length);
    System.out.println(Arrays.toString(arr));
  }

  private static void mergeSort(Integer[] arr, int low, int high) {

    if (high - low <= 1)
      return;

    int mid = (low + high) / 2;

    mergeSort(arr, low, mid);
    mergeSort(arr, mid, high);
    mergeParts(arr, low, mid, high);
  }

  private static void mergeParts(Integer[] arr, int low, int mid, int high) {
    int noOfElements = high - low;
    Integer[] tempArr = new Integer[noOfElements];

    for (int k = 0, i = low, j = mid; k < noOfElements; k++) {
      if (i == mid)
        tempArr[k] = arr[j++];
      else if (j == high)
        tempArr[k] = arr[i++];
      else if (arr[j] < arr[i])
        tempArr[k] = arr[j++];
      else
        tempArr[k] = arr[i++];
    }

    System.arraycopy(tempArr, 0, arr, low, tempArr.length);
  }
}
