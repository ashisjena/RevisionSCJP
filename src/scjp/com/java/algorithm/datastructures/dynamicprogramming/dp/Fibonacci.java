package scjp.com.java.algorithm.datastructures.dynamicprogramming.dp;

import java.util.HashMap;

public class Fibonacci {
  public static void main(String[] args) {
    System.out.println(topDownApproach(5, new HashMap<>()));
    System.out.println(bottomUpApproach(5));
  }

  static int bottomUpApproach(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;

    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }

    return dp[n];
  }

  static int topDownApproach(int n, HashMap<Integer, Integer> cache) {
    if (n == 0) {
      return 0;
    } else if (n == 1) {
      return 1;
    } else if (cache.containsKey(n)) {
      return cache.get(n);
    }

    return topDownApproach(n - 1, cache) + topDownApproach(n - 2, cache);
  }
}
