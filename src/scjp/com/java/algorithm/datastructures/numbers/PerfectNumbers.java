package scjp.com.java.algorithm.datastructures.numbers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PerfectNumbers {
  private PerfectNumbers obj;

  @Before
  public void setup() {
    obj = new PerfectNumbers();
  }

  @Test
  public void findNthPerfectNumTest() {
    assertEquals(44, obj.findNthPerfectNum(1));
    assertEquals(55, obj.findNthPerfectNum(2));
    assertEquals(4444, obj.findNthPerfectNum(3));
    assertEquals(4554, obj.findNthPerfectNum(4));
    assertEquals(5445, obj.findNthPerfectNum(5));
    assertEquals(5555, obj.findNthPerfectNum(6));
    assertEquals(444444, obj.findNthPerfectNum(7));
    assertEquals(445544, obj.findNthPerfectNum(8));
    assertEquals(454454, obj.findNthPerfectNum(9));
    assertEquals(455554, obj.findNthPerfectNum(10));
    assertEquals(544445, obj.findNthPerfectNum(11));
    assertEquals(545545, obj.findNthPerfectNum(12));
    assertEquals(554455, obj.findNthPerfectNum(13));
    assertEquals(555555, obj.findNthPerfectNum(14));
    assertEquals(44444444, obj.findNthPerfectNum(15));
    assertEquals(44455444, obj.findNthPerfectNum(16));
    assertEquals(54444445, obj.findNthPerfectNum(23));
  }

  private List<String> getAllKLengthString(String[] arr, String prefix, int k) {
    if (k == 0) {
      return Collections.singletonList(prefix);
    }

    final List<String> combinations = new ArrayList<>();
    for (String ch : arr) {
      combinations.addAll(getAllKLengthString(arr, prefix + ch, k - 1));
    }
    return combinations;
  }

  public int findNthPerfectNum(int k) {
    String[] arr = {"4", "5"};

    int level = 1;
    int startOfLevel = 1;
    while (startOfLevel + Math.pow(2, level) <= k) {
      startOfLevel += Math.pow(2, level);
      level++;
    }

    List<String> combinations = getAllKLengthString(arr, "", level);

    int stepsFromNextLevel = k - startOfLevel;
    String half = combinations.get(stepsFromNextLevel);

    return Integer.parseInt(half + new StringBuilder(half).reverse().toString());
  }
}
