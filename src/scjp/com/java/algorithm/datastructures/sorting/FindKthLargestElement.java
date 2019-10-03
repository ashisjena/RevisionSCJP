package scjp.com.java.algorithm.datastructures.sorting;

// Similar to Quicksort
// https://www.youtube.com/watch?v=hGK_5n81drs
public class FindKthLargestElement {

  public static void main(String[] args) {
    int[] arr = {3, 2, 4, 65, 32, 8, 9};
    int result = findKthLargestElement(arr, 0, arr.length - 1, 3);
    System.out.println(result);
  }

  public static int findKthLargestElement(int[] arr, int left, int right, int k) {
    int indexOfKthLargest = arr.length - k;

    int restingPositionForPivot = partition(arr, left, right);

    if (restingPositionForPivot > indexOfKthLargest) {
      return findKthLargestElement(arr, left, restingPositionForPivot - 1, k);
    } else if (restingPositionForPivot < indexOfKthLargest) {
      return findKthLargestElement(arr, restingPositionForPivot + 1, right, k);
    } else {
      return arr[indexOfKthLargest];
    }
  }

  private static int partition(int[] arr, int left, int right) {
    int pivot = arr[right];

    int i = left - 1;

    for (int j = left; j < right; j++) {
      if (arr[j] <= pivot) {
        i++;
        swap(arr, i, j);
      }
    }

    swap(arr, i + 1, right);
    return i + 1;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
