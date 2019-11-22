package scjp.com.java.algorithm.datastructures.sorting;

import java.util.Arrays;
import java.util.stream.Collectors;

//https://www.youtube.com/watch?v=uXBnyYuwPe8
public class QuickSort {

  public static void main(String[] args) {
    int[] arr = {3, 2, 4, 65, 32, 6, 8, 9};
//    int[] arr = {3, 7, 6, 9, 1, 8, 10, 4, 2, 5};
    quickSort(arr, 0, arr.length - 1);
    System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
  }

  public static void quickSort(int[] arr, int left, int right) {
    if (left < right) {
      int pivotFinalRestingPosition = partition(arr, left, right);
      quickSort(arr, left, pivotFinalRestingPosition - 1);
      quickSort(arr, pivotFinalRestingPosition + 1, right);
    }
  }

  @SuppressWarnings("Duplicates")
  private static int partition(int arr[], int left, int right) {
    int pivot = arr[right];
    int lastSmallerDigitIndex = left - 1; // left elements of left index are smaller than pivot.
    // i's job is to maintain the position left to which all the elements are less than pivot including i's position.

    for (int i = left; i < right; i++) {
      if (arr[i] <= pivot) {
        lastSmallerDigitIndex++; // move i to right
        if (lastSmallerDigitIndex < i) {
          swap(arr, lastSmallerDigitIndex, i);
        }
      }
    }
    swap(arr, lastSmallerDigitIndex + 1, right); // swap i + 1 with pivot index, as left to i + 1 are less than pivot.
    return lastSmallerDigitIndex + 1; // partition index. left are less than value in i + 1/pivot and right are greater values.
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
