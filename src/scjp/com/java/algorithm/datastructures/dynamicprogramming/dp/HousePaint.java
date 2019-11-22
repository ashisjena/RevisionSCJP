package scjp.com.java.algorithm.datastructures.dynamicprogramming.dp;

import org.junit.Test;
import scjp.com.java.algorithm.dynamicProgramming.PrintMatrix;

import static org.junit.Assert.assertEquals;

public class HousePaint {
  int paintHouseUniqueColors(int[][] cost, int start, int color) {
    int length = cost.length;
    if (start == length) {
      return 0;
    }

    int minCost = Integer.MAX_VALUE;
    for (int i = start; i < length; i++) {

      int indexForColor = (color + i) % length;
      int currCost = cost[start][indexForColor] + paintHouseUniqueColors(cost, start + 1, color + (i + 1));

      if (currCost < minCost) {
        minCost = currCost;
      }
    }

    return minCost;
  }

  int paintHouseAdjacentUniqueColors(int[][] cost, int start, int color) {
    if (start == cost.length) {
      return 0;
    }

    int x = cost[start][color % 3] + paintHouseAdjacentUniqueColors(cost, start + 1, color + 1);
    int y = cost[start][(color + 1) % 3] + paintHouseAdjacentUniqueColors(cost, start + 1, color + 2);
    int z = cost[start][(color + 2) % 3] + paintHouseAdjacentUniqueColors(cost, start + 1, color);
    return Math.min(Math.min(x, y), z);
  }

  int paintHouseAdjacentUniqueColorsBottomUp(int[][] cost) {
    int dpRows = cost.length + 1;
    int dpCols = cost[0].length + 1;
    int dp[][] = new int[dpRows][dpCols];

    for (int i = 1; i < dpRows; i++) {
      for (int j = 1; j < dpCols; j++) {
        dp[i][j] = cost[i - 1][j - 1] + Math.min(dp[i - 1][otherColorIndex(dpCols, j, 1)], dp[i - 1][otherColorIndex(dpCols, j, 2)]);
      }
    }

    int min = Integer.MAX_VALUE;
    for (int j = 1; j < dpCols; j++) {
      if (dp[dpRows - 1][j] < min) {
        min = dp[dpRows - 1][j];
      }
    }
    PrintMatrix.print(dp);
    return min;
  }

  private int otherColorIndex(int dpCols, int j, int i) {
    return ((j + i) >= dpCols ? (j + i + 1) : (j + i)) % dpCols;
  }

  int[][] cost = {
          {17, 2, 17},
          {16, 16, 5},
          {14, 3, 9}};

  @Test
  public void testAlternateUniqueColors() {
    assertEquals(10, paintHouseAdjacentUniqueColors(cost, 0, 0));
    assertEquals(10, paintHouseAdjacentUniqueColorsBottomUp(cost));
  }

  @Test
  public void testUniqueColors() {

    assertEquals(21, paintHouseUniqueColors(cost, 0, 0));
  }
}
