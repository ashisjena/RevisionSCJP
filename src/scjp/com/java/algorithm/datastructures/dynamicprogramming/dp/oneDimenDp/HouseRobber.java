package scjp.com.java.algorithm.datastructures.dynamicprogramming.dp.oneDimenDp;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class HouseRobber {
  int robHouseRecur(int[] arr, int start) {
    if (start < 0) {
      return 0;
    }

    return Math.max(arr[start] + robHouseRecur(arr, start - 2), robHouseRecur(arr, start - 1));
  }

  int robHouseBottomUp(int[] arr) {
    int[] dp = new int[arr.length + 1];
    Boolean[] rob = new Boolean[arr.length];

    rob[0] = true;
    dp[1] = arr[0];
    for (int idx = 2; idx < dp.length; idx++) {
      int include = arr[idx - 1] + dp[idx - 2];
      int exclude = dp[idx - 1];

      if (include > exclude) {
        rob[idx - 1] = true;
        dp[idx] = include;
      } else {
        rob[idx - 1] = false;
        dp[idx] = exclude;
      }
    }

    for (int idx = rob.length - 1; idx >= 0; ) {
      if (rob[idx]) {
        System.out.println(idx + " " + arr[idx]);
        idx -= 2;
      } else {
        idx--;
      }
    }

    System.out.println(Arrays.stream(rob).collect(Collectors.toList())); // Based on the last value we can reconstruct the positions.
    return dp[dp.length - 1];
  }

  @Test
  public void robHouseRecurTest() {
    assertEquals(60, robHouseRecur(new int[]{20, 25, 30, 15, 10}, 5 - 1));
    assertEquals(65, robHouseRecur(new int[]{20, 50, 30, 15, 10}, 5 - 1));
  }

  @Test
  public void robHouseBottomUpTest() {
    assertEquals(60, robHouseBottomUp(new int[]{20, 25, 30, 15, 10}));
    assertEquals(65, robHouseBottomUp(new int[]{20, 50, 30, 15, 10}));
  }
}
