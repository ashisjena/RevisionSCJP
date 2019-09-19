package scjp.com.java.algorithm.dynamicProgramming;

public class LargestSubArraySum {
  public static void main(String[] args) {
    int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
    int maxSum = maxSubArraySum1(a);
    System.out.println("Maximum contiguous sum is " + maxSum);
  }

  public static int maxSubArraySum1(int[] arr) {
    int maxSoFar = 0, maxEndingHere = 0;
    for (int i = 0; i < arr.length; i++) {
      maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);

      maxSoFar = Math.max(maxEndingHere, maxSoFar);
    }

    return maxSoFar;
  }

  public static int maxSubArraySum2(int[] arr) {
    int maxSoFar = 0;
    int maxEndingHere = 0;

    for (int i = 0; i < arr.length; i++) {
      maxEndingHere += arr[i];

      if (maxEndingHere < 0) {
        maxEndingHere = 0;
      } else if (maxSoFar < maxEndingHere) {
        maxSoFar = maxEndingHere;
      }
    }

    return maxSoFar;
  }
}
