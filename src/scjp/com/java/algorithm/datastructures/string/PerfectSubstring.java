package scjp.com.java.algorithm.datastructures.string;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class PerfectSubstring {
  PerfectSubstring obj;

  @Before
  public void setup() {
    obj = new PerfectSubstring();
  }

  @Test
  public void noOfValidSubStringTest() {
    assertEquals(0, obj.noOfValidSubString(null, 2, 0));
    assertEquals(0, obj.noOfValidSubString("", 2, 0));
    assertEquals(0, obj.noOfValidSubString("1", 2, 0));
    assertEquals(0, obj.noOfValidSubString("123", 2, 0));
    assertEquals(1, obj.noOfValidSubString("1", 1, 0));
    assertEquals(1, obj.noOfValidSubString("11", 2, 0));
    assertEquals(1, obj.noOfValidSubString("111", 3, 0));
    assertEquals(3, obj.noOfValidSubString("1122", 2, 0));
    assertEquals(6, obj.noOfValidSubString("1102021222", 2, 0));
  }

  private int noOfValidSubString(String s, int k, int start) {
    if (s == null || s.length() < k || start == s.length()) {
      return 0;
    } else if (k == 1) {
      return s.length();
    }

    int result = 0;
    Map<Character, Integer> map = new HashMap<>();
    for (int i = start; i < s.length(); i++) {
      Integer value = map.get(s.charAt(i));
      if (value == null) {
        value = 0;
      }
      map.put(s.charAt(i), value + 1);
      if (map.values().stream().noneMatch(count -> count != k)) {
        result++;
      }
    }
    result += noOfValidSubString(s, k, start + 1);

    return result;
  }
}
