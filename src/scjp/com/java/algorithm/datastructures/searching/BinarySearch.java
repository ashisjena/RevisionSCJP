package scjp.com.java.algorithm.datastructures.searching;

public class BinarySearch {

  public static void main(String[] args) {
    int arr[] = {2, 3, 4, 10, 40};

    int result = binarySearch(arr, 0, arr.length - 1, 10);
    System.out.println(result);
  }

  public static int binarySearch(int arr[], int left, int right, int k) {
    if (left >= right) {
      return -1;
    } else {
      int mid = (left + right) / 2;

      if (arr[mid] > k) {
        return binarySearch(arr, left, mid - 1, k);
      } else if (arr[mid] < k) {
        return binarySearch(arr, mid + 1, right, k);
      } else {
        return mid;
      }
    }
  }
}
