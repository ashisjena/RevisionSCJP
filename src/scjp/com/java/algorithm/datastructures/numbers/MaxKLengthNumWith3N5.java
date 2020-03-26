package scjp.com.java.algorithm.datastructures.numbers;

import org.jetbrains.annotations.NotNull;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

/*
Find the maximum number that can be formed of k digits.
Rules
1) number can be formed using 5 or 3 or both
2) number of 5 in that particular number should be divisible of 3
3) number of 3 in that particular number should be divisible of 5
I.e.
If k = 8
Number would be 55533333
Here number of 3s are 5
And number of 5s are 3

k = 5x + 3y, where x & y >= 0
 */
public class MaxKLengthNumWith3N5 {
  private MaxKLengthNumWith3N5 obj;

  @Before
  public void setup() {
    this.obj = new MaxKLengthNumWith3N5();
  }

  private void assertMaxNum(String result, int k) {
    assertEquals(new BigInteger(result), obj.maxNum(k));
  }

  @Test
  public void maxNumTest() {
    assertMaxNum("0", 2);
    assertMaxNum("555", 3);
    assertMaxNum("0", 4);
    assertMaxNum("33333", 5);
    assertMaxNum("55533333", 8);
    assertMaxNum("555555555", 9);
    assertMaxNum("3333333333", 10);
    assertMaxNum("55555533333", 11);
    assertMaxNum("555555555555", 12);
    assertMaxNum("5553333333333", 13);
    assertMaxNum("55555555533333", 14);
    assertMaxNum("555555555555555", 15);
    assertMaxNum("5555553333333333", 16);
    assertMaxNum("55555555555533333", 17);
    assertMaxNum("555555555555555555", 18);
    assertMaxNum("5555555553333333333", 19);
    assertMaxNum("55555555555555533333", 20);
  }

  public BigInteger maxNum(int k) {
    int fiveSetCounts = 0;
    while (k >= 0) {
      k -= 3;
      fiveSetCounts++;
    }

    while (k % 5 != 0 && fiveSetCounts >= 0) {
      fiveSetCounts--;
      k += 3;
    }

    if (fiveSetCounts >= 0) {
      return getMaxNum(fiveSetCounts, k / 5);
    } else {
      return new BigInteger("0");
    }
  }

  @NotNull
  private BigInteger getMaxNum(int fiveSetCounts, int threeSetCounts) {
    String result = "";
    for (int i = 0; i < fiveSetCounts; i++) {
      result += "555";
    }

    for (int i = 0; i < threeSetCounts; i++) {
      result += "33333";
    }

    return new BigInteger(result);
  }
}
