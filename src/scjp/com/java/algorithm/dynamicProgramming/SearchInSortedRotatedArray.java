package scjp.com.java.algorithm.dynamicProgramming;

public class SearchInSortedRotatedArray {
  public static void main(String[] args) {
    int arr[] = {4, 5, 6, 7, 8, 9, 1, 2, 3};
    int index = search(arr, 0, arr.length - 1, 8);
    if (index != -1)
      System.out.println("Index: " + index);
    else
      System.out.println("Key not found");
  }

  public static int search(int arr[], int low, int high, int key) {
    if (low > high) {
      return -1;
    }

    int mid = (low + high) / 2;
    if (arr[mid] == key) {
      return mid; // Return the index
    }

    // If arr[low --- mid] first subArray is Sorted
    if (arr[low] <= arr[mid]) {
      // As this subarray is sorted, we can quickly check if key lies in the half or other half
      if (key >= arr[low] && key <= arr[mid]) {
        return search(arr, low, mid - 1, key);
      } else {
        return search(arr, mid + 1, high, key); // If key doesn't lie in the first half subarray.
      }
    } else if (key >= arr[mid] && key <= arr[high]) { // 1st half is not sorted then 2nd half must be sorted.
      return search(arr, mid + 1, high, key);
    } else {
      return search(arr, low, mid - 1, key);
    }
  }
}
