package scjp.com.java.algorithm.dynamicProgramming;

import scjp.com.java.algorithm.PrintMatrix;

import java.util.ArrayList;

/*
Input : arr[] = {2, 3, 5, 6, 8, 10}
        sum = 10
Output : 5 2 3
         2 8
         10

Input : arr[] = {1, 2, 3, 4, 5}
        sum = 10
Output : 4 3 2 1
         5 3 2
         5 4 1

https://www.youtube.com/watch?v=K20Tx8cdwYY
 */

public class PerfectSum {
  public static void main(String[] args) {

    int arr[] = {1, 2, 3, 4, 5};
    boolean[][] dp = perfectSum(arr, 10);
    System.out.println();
    dp = perfectSum2(arr, 10);
    printSubsetsRec(arr, arr.length - 1, 10, new ArrayList<>(), dp);
  }

  static void printSubsetsRec(int arr[], int i, int remainingSum, ArrayList<Integer> list, boolean[][] dp) {
    // If we reached end and sum is non-zero. We print
    // list[] only if arr[0] is equal to sum OR dp[0][sum]
    // is true.
    if (i == 0 && remainingSum != 0 && dp[0][remainingSum]) {
      list.add(arr[i]);
      System.out.println(list);
      list.clear();
      return;
    }

    // If sum becomes 0
    if (i == 0 && remainingSum == 0) {
      System.out.println(list);
      list.clear();
      return;
    }

    // If given sum can be achieved after ignoring
    // current element.
    if (dp[i - 1][remainingSum]) {
      // Create a new list to store path
      ArrayList<Integer> b = new ArrayList<>();
      b.addAll(list);
      printSubsetsRec(arr, i - 1, remainingSum, b, dp);
    }

    // If given sum can be achieved after considering
    // current element.
    if (remainingSum >= arr[i] && dp[i - 1][remainingSum - arr[i]]) {
      list.add(arr[i]);
      printSubsetsRec(arr, i - 1, remainingSum - arr[i], list, dp);
    }
  }

  public static boolean[][] perfectSum2(int[] arr, int totalSum) {
    int n = arr.length;
    if (n == 0 || totalSum < 0) {
      return new boolean[0][0];
    }

    boolean dp[][] = new boolean[n][totalSum + 1];
    // Set the first column as true.
    for (int i = 0; i < n; i++) {
      dp[i][0] = true;
    }

    // Sum with value arr[0] can be achieved with single element i.e arr[0].
    if (arr[0] <= totalSum) {
      dp[0][arr[0]] = true;
    }

    for (int i = 1; i < n; i++) {
      for (int sum = 0; sum <= totalSum; sum++) {
        dp[i][sum] = (arr[i] <= sum) ?
                (dp[i - 1][sum] || dp[i - 1][sum - arr[i]]) // If sum - arr[i] is true them adding the current value arr[i] will be the sum.
                : dp[i - 1][sum];
      }
    }

    PrintMatrix.print(dp);
    return dp;
  }

  public static boolean[][] perfectSum(int[] arr, int totalSum) {
    boolean[][] dp = new boolean[arr.length][totalSum + 1]; // Memoization table

    // Set the first column as true. As by excluding all we can form a sum with value 0.
    for (int i = 0; i < arr.length; i++) {
      dp[i][0] = true;
    }

    // Sum with value arr[0]/1st element can be achieved with single element i.e arr[0]/1st Element.
    if (arr[0] <= totalSum) {
      dp[0][arr[0]] = true;
    }

    for (int i = 1; i < arr.length; i++) {
      for (int sum = 0; sum <= totalSum; sum++) {

        if (arr[i] > sum) {
          dp[i][sum] = dp[i - 1][sum];
        } else if (arr[i] == sum) {
          dp[i][sum] = true;
        } else {
          int remainingSum = sum - arr[i];
          dp[i][sum] = dp[i - 1][remainingSum]; // Check if we can form the remaining Sum with previous values.
        }
      }
    }
    PrintMatrix.print(dp);
    return dp;
  }

/*  public static void printSubset(boolean[][] dp, int[] arr, int totalSum) {
    for (int i = 0; i < dp.length; i++) {
      List<Integer> list = new ArrayList<>();
      if (dp[i][totalSum] == true) {
        if (arr[i] == totalSum) { // If sum can be formed using only one element then add that element.
          list.add(arr[i]);
        } else {
          int j = i;
          int remainingSum = totalSum;
          while (remainingSum > 0) {
            while (j >= 0 && dp[j][remainingSum] == true) {
              j--;
            }
            list.add(arr[j + 1]);
            remainingSum = remainingSum - arr[j + 1];
          }
        }

        System.out.println(list);
      }
    }
  }*/

}
