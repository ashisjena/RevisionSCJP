package scjp.com.java.algorithm.datastructures.arrays;

/*
 * ex : {1, 2, 3, 4, 5, 6, 7, 8, 9} and {10, 11, 12, 13, 14}
 * 
 * int[] resultArr = {10, 11, 12, 13, 14, 1, 2, 3, 4, 5, 6, 7, 8, 9}; ^
 * 
 * Algorithm to find the index of the starting point. If we treat it as cyclic array, it will be in
 * sorted order while iterating from the starting point.
 * 
 * In the above example the starting index will be "4"
 */

public class FindStartingPoint {

  public static void main(String[] args) {
    int[] arr = {4, 5, 9, 10, 11, 12, 13, 14, 1, 2, 3};
    System.out.println(findStart(arr));
    System.out.println(findStartRecurr(arr, 0, arr.length));
  }

  public static int findStart(int[] arr) {
    int low = 0;
    int high = arr.length;
    while (low < high) {
      int middle = (low + high) / 2;
      boolean fitsLow = arr[low] <= arr[middle];
      if (fitsLow) {
        low = middle + 1;
      } else {
        high = middle;
      }
    }
    return low;
  }

  public static int findStartRecurr(int[] arr, int low, int high) {
    int mid = (low + high) / 2;
    if (low < high)
      if (arr[low] <= arr[mid])
        return findStartRecurr(arr, mid + 1, high);
      else
        return findStartRecurr(arr, low, mid);

    return low;
  }
}