package scjp.com.java.algorithm.datastructures.arrays;

/*
arr[] = {0, 1, 1, 0, 2, 0, 2, 1, 0}
sort the array with O(n)
 */
public class Sort3NumberArray_TODO {
  public static void main(String[] args) {
    int arr[] = {0, 0, 2, 0, 0, 0, 2, 1, 2, 0, 2, 0, 0};

    int zeroPointer = 0;
    int twoPointer = arr.length - 1;
    for (int i = 0; i < twoPointer; i++) {
      if (arr[i] == 0) {
        if (arr[zeroPointer] != 0) {
          swap(arr, zeroPointer, i);
        }
        while (i < twoPointer && arr[zeroPointer] == 0) {
          zeroPointer++;
        }
        if(i < zeroPointer) {
          i = zeroPointer;
        }
        if (arr[i] == 2) { // If the swapped position was two, then move to the right.
          swap(arr, twoPointer, i);
          twoPointer--;
        }
      } else if (arr[i] == 2) {
        if (arr[twoPointer] != 2) {
          swap(arr, twoPointer, i);
        }
        while (twoPointer > i && arr[twoPointer] == 2) {
          twoPointer--;
        }
        if (arr[i] == 0) { // If the previous position was zero. Then move the zero to the left
          swap(arr, zeroPointer, i);
          zeroPointer++;
        }
      }
    }

    for (int num : arr) {
      System.out.println(num);
    }
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
