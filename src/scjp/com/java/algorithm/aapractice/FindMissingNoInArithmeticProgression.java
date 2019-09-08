package scjp.com.java.algorithm.aapractice;

public class FindMissingNoInArithmeticProgression {

  // An = A1 + (n-1)d  Arithmetic progression formula
  // An = A1 * r^(n-1) Geometric progression formula
  public static void main(String[] args) {
    int arr[] = {2, 4, 6, 8, 10, 12, 14, 16, 20, 22};

    int diff = (arr[arr.length - 1] - arr[0]) / arr.length;  // not deducting one, as already missing

    System.out.println(findMissingNo(arr, 0, arr.length, diff));
  }

  private static int findMissingNo(int[] arr, int start, int end, int diff) {

    if (start + 1 == end)
      return arr[start] + diff;

    int mid = (start + end) / 2;
    int toBeMidValue = arr[0] + mid * diff;  // Index is zero based so not deducting one, as per formula

    if (toBeMidValue < arr[mid])
      return findMissingNo(arr, start, mid, diff);
    else if (toBeMidValue == arr[mid])
      return findMissingNo(arr, mid, end, diff);
    else
      throw new AssertionError("Wrong data provided");
  }
}
