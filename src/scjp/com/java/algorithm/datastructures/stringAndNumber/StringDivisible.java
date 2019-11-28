package scjp.com.java.algorithm.datastructures.stringAndNumber;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/*
    abcabcabcabcabcabc, abcabcabc
    Find the minimum divisible string. ex: abc
    Condition 2nd String must be divisible by 1st string. Otherwise return "NOT_FOUND"
  */
public class StringDivisible {
  private StringDivisible obj;

  @Before
  public void setup() {
    obj = new StringDivisible();
  }

  @Test
  public void findMinimumDivisibleTest() {
    assertEquals("a", obj.findMinimumDivisible("a", "a"));
    assertEquals("a", obj.findMinimumDivisible("aa", "a"));
    assertEquals("NOT_FOUND", obj.findMinimumDivisible("ab", "a"));
    assertEquals("abc", obj.findMinimumDivisible("abcabc", "abc"));
    assertEquals("abc", obj.findMinimumDivisible("abcabcabc", "abc"));
    assertEquals("abc", obj.findMinimumDivisible("abcabcabcabcabcabc", "abcabcabc"));
    assertEquals("ab", obj.findMinimumDivisible("abababababababab", "abababab"));
  }

  private String minDivisible(String s, int end) {
    String k = s.substring(0, end);

    if (k.length() * 2 > s.length()) {
      return s;
    } else if (s.replaceAll(k, "").length() == 0) {
      return k;
    } else {
      return minDivisible(s, end + 1);
    }
  }

  private String findMinimumDivisible(String s, String t) {
    if (s.replaceAll(t, "").length() == 0) {
      return minDivisible(t, 1);
    } else {
      return "NOT_FOUND";
    }
  }
}
