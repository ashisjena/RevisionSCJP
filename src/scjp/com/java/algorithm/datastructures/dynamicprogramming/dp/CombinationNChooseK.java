package scjp.com.java.algorithm.datastructures.dynamicprogramming.dp;

import scjp.com.java.algorithm.PrintMatrix;

// Choose k Numbers from n different numbers;
// Binomial Coefficient
/*
  Formula : C(n, k) = n!/(n-k)!k!

  Recursive : C(n, k) = C(n-1, k-1) + C(n-1, k) = (n-1)!/(k-1)! + (n-1)!/k!

  Base Case: C(n, n) = 1 , C(n, 0) = 1
 */
public class CombinationNChooseK {
  public static void main(String[] args) {
    System.out.println(binomialCoefficientRecur(4, 2));
    int[][] dp = new int[5 + 1][3 + 1];
    System.out.println(binomialCoefficient1(5, 3, dp));
    PrintMatrix.print(dp);
  }

  static int binomialCoefficient1(int n, int k, int[][] dpTable) {
    /*for (int i = 1; i <= n; i++) {
      for (int j = 0; j <= k; j++) {
        if (j == 0 || i == j) {
          dpTable[i][j] = 1;
        } else {
          dpTable[i][j] = dpTable[i - 1][j - 1] + dpTable[i - 1][j];
        }
      }
    }*/

    // Base condition
    for (int i = 0; i <= n; i++) {
      dpTable[i][0] = 1;
      if (i <= k) {
        dpTable[i][i] = 1;
      }
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= k; j++) {
        dpTable[i][j] = dpTable[i - 1][j - 1] + dpTable[i - 1][j];
      }
    }

    return dpTable[n][k];
  }

  static int binomialCoefficient2(int n, int k, int[][] dpTable) {
    if (n == k || k == 0) {
      dpTable[n][k] = 1;
      return 1;
    } else if (dpTable[n][k] != 0) {
      return dpTable[n][k];
    }

    int res = binomialCoefficient2(n - 1, k - 1, dpTable) + binomialCoefficient2(n - 1, k, dpTable);
    dpTable[n][k] = res;
    return res;
  }

  static int binomialCoefficientRecur(int n, int k) {
    if (n == k || k == 0) {
      return 1;
    }
    return binomialCoefficientRecur(n - 1, k - 1) + binomialCoefficientRecur(n - 1, k);
  }
}
