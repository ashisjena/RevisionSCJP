package scjp.com.java.algorithm.datastructures.numbers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
  consecutive numbers present in an array "K" times.
  only one number is present "K - 1" times.
  Search for that number and return it.
 */
public class MissingNumber {
  private MissingNumber obj;

  @Before
  public void setup() {
    obj = new MissingNumber();
  }

  @Test
  public void missingNumberTest() {
    assertEquals(4, obj.missingNumber(new int[]{1, 1, 2, 2, 4, 5, 5}, 2, 0, 7));
    assertEquals(1, obj.missingNumber(new int[]{1, 1, 2, 2, 2, 4, 4, 4, 5, 5, 5}, 3, 0, 11));
    assertEquals(2, obj.missingNumber(new int[]{1, 1, 1, 2, 2, 4, 4, 4, 5, 5, 5, 8, 8, 8}, 3, 0, 14));
    assertEquals(2, obj.missingNumber(new int[]{1, 1, 1, 1, 2, 2, 2, 4, 4, 4, 4, 5, 5, 5, 5}, 4, 0, 15));
    assertEquals(2, obj.missingNumber(new int[]{1, 1, 1, 1, 2, 2, 2, 4, 4, 4, 4}, 4, 0, 15));
    assertEquals(4, obj.missingNumber(new int[]{1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5}, 4, 0, 19));
  }

  private int missingNumber(int[] arr, int k, int start, int end) {
    int l = end - start;
    if (l < k) {
      return arr[start];
    }

    int m = (int) Math.ceil((double) ((l + 1) / k) / 2);
    int mid = start + m * k;

    if (arr[mid - 1] != arr[mid]) {
      return missingNumber(arr, k, mid, end);
    } else {
      return missingNumber(arr, k, start, mid - 2);
    }
  }
}
