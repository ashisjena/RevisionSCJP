package scjp.com.java.algorithm.old.recursion;

/*
 * Find an sorted array is subset of other sorted Array with O(n) complexity
 */

public class ArraySubSetOtherArray {
  public static void main(String[] args) {
    int arr1[] = {1, 2, 3, 4, 5};
    int arr2[] = {2, 4};

//    if (isSubSetRec(arr1, 0, arr2, 0))
    if (isSubSet(arr1, arr2))
      System.out.println("Sub Set");
    else
      System.out.println("Not Sub Set");
  }

  public static boolean isSubSetRec(int[] arr1, int index1, int[] arr2, int index2) {
    if (index1 == arr1.length)
      return false;
    else if (arr1[index1++] == arr2[index2] && ++index2 == arr2.length)
      return true;

    return isSubSetRec(arr1, index1, arr2, index2);
  }

  public static boolean isSubSet(int[] arr, int[] subArray) {
    int i = 0, j = 0;

    while (i < subArray.length && j < arr.length) {
      if (arr[j++] == subArray[i] && ++i == subArray.length) {
        return true;
      }
    }
    return false;
  }
}