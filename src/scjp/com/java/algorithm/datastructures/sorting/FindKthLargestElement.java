package scjp.com.java.algorithm.datastructures.sorting;

// Similar to Quicksort
// https://www.youtube.com/watch?v=hGK_5n81drs
public class FindKthLargestElement {

  public static void main(String[] args) {
    int[] arr = {3, 2, 4, 65, 32, 8, 9};
    int k = 3;
    int indexOfKthLargest = arr.length - k;
    int result = findKthLargestElement(arr, 0, arr.length - 1, indexOfKthLargest);
    System.out.println(result);
  }

  public static int findKthLargestElement(int[] arr, int left, int right, int indexOfKthLargest) {
    int restingPositionForPivot = partition(arr, left, right);

    if (restingPositionForPivot > indexOfKthLargest) {
      return findKthLargestElement(arr, left, restingPositionForPivot - 1, indexOfKthLargest);
    } else if (restingPositionForPivot < indexOfKthLargest) {
      return findKthLargestElement(arr, restingPositionForPivot + 1, right, indexOfKthLargest);
    } else {
      return arr[indexOfKthLargest];
    }
  }

  @SuppressWarnings("Duplicates")
  private static int partition(int[] arr, int left, int right) {
    int pivot = arr[right];

    int i = left - 1;

    for (int j = left; j < right; j++) {
      if (arr[j] <= pivot) {
        i++;
        if (i < j) {
          swap(arr, i, j);
        }
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
