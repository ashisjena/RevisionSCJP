package scjp.com.java.algorithm.datastructures.Arrays;

import java.util.Arrays;

// https://www.geeksforgeeks.org/merge-two-sorted-arrays-o1-extra-space/
public class MergeTwoSorterArrayWithoutExtraSpace {
  public static void main(String[] args) {
    int[] arr1 = {1, 5, 9, 10, 15, 20};
    int[] arr2 = {2, 3, 8, 13, 25};

    merge(arr1, arr2);

    System.out.println(Arrays.toString(arr1));
    System.out.println(Arrays.toString(arr2));
  }

  static void merge(int[] arr1, int[] arr2) {
    for (int i = arr2.length - 1; i >= 0; i--) {
      int j;
      int last = arr1[arr1.length - 1];
      for (j = arr1.length - 2; j > 0 && arr1[j] > arr2[i]; j--) {
        arr1[j + 1] = arr1[j];
      }

      if (last > arr2[i]) {
        arr1[j + 1] = arr2[i];
        arr2[i] = last;
      }
    }
  }
}
