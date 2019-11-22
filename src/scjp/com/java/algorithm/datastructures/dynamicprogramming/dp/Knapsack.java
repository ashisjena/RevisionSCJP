package scjp.com.java.algorithm.datastructures.dynamicprogramming.dp;

import scjp.com.java.algorithm.dynamicProgramming.PrintMatrix;

/*
  States:
    1. W - Available capacity of the bag
    2. i - Index of the item being considered

    Cost function:
      knapsack(W, i)

  Define the state transitions and optimal choice
    Identify the base cases.
    Identify the transitions

    Base cases:
      W = 0, the knapsack is full. No space is available.
      i = -1, no more items are available to consider.
 */
public class Knapsack {
  public static void main(String[] args) {
    int weightArr[] = {1, 2, 3, 4};
    int priceArr[] = {2, 8, 5, 6};

    int knapsackSize = 5;
    int n = priceArr.length - 1;
    System.out.println(knapsack(weightArr, priceArr, knapsackSize, n));
    int[][] dp = new int[knapsackSize + 1][priceArr.length];
    for (int i = 0; i < knapsackSize + 1; i++) {
      for (int j = 0; j < priceArr.length; j++) {
        dp[i][j] = -1;
      }
    }
    System.out.println(knapsackMemo(weightArr, priceArr, knapsackSize, n, dp));
    PrintMatrix.print(dp);

    System.out.println(knapsackBottomUp(weightArr, priceArr, 5));
  }

  private static int knapsack(int[] weights, int[] values, int W, int i) {
    if (W == 0 || i == -1) {
      return 0;
    }

    if (weights[i] <= W) {
      int include = values[i] + knapsack(weights, values, W - weights[i], i - 1);
      int exclude = knapsack(weights, values, W, i - 1);
      return Math.max(include, exclude);
    } else {
      return knapsack(weights, values, W, i - 1);
    }
  }

  private static int knapsackMemo(int[] weights, int[] values, int W, int i, int[][] dp) {
    if (W == 0 || i == 0) {
      return 0;
    } else if (dp[W][i] != -1) {
      return dp[W][i];
    }

    if (weights[i] <= W) {
      int include = values[i] + knapsackMemo(weights, values, W - weights[i], i - 1, dp);
      int exclude = knapsackMemo(weights, values, W, i - 1, dp);
      return dp[W][i] = Math.max(include, exclude);
    } else {
      return dp[W][i] = knapsackMemo(weights, values, W, i - 1, dp);
    }
  }

  private static int knapsackBottomUp(int[] weights, int[] values, int W) {
    int N = values.length;
    int[][] dp = new int[W + 1][N + 1];

    for (int i = 1; i <= N; i++) {
      for (int w = 1; w <= W; w++) {
        int currentWeight = weights[i - 1];
        int currentValue = values[i - 1];
        if (currentWeight <= w) {
          dp[w][i] = Math.max(
                              currentValue + dp[w - currentWeight][i - 1], // Including
                              dp[w][i - 1] // excluding
                            );
        } else {
          dp[w][i] = dp[w][i - 1]; // Copy the previous
        }
      }
    }
    PrintMatrix.print(dp);
    return dp[W][N];
  }
}
