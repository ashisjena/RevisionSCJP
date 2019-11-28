package scjp.com.java.algorithm.old.recursion;

public class ArrayIsSequence {
  public static void main(String[] args) {
    System.out.println(isSequence(new int[]{2, 3, 4, 5, 7, 8}, 1));
  }

  private static boolean isSequence(int[] arr, int index) {
    if (index == arr.length - 1) {
      return true;
    }

    if (arr[index] == arr[index + 1] - 1) {
      return isSequence(arr, index + 1);
    } else {
      return false;
    }
  }
}
