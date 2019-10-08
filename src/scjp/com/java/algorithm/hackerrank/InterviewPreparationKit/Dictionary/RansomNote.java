package scjp.com.java.algorithm.hackerrank.InterviewPreparationKit.Dictionary;

import java.util.HashMap;
import java.util.Map;

// https://www.hackerrank.com/challenges/ctci-ransom-note/problem
public class RansomNote {
  public static void main(String[] args) {
    checkMagazine("two times three is not four".split("\\s"), "two times two is four".split("\\s"));
    checkMagazine("give me one grand today night".split("\\s"), "give one grand today".split("\\s"));
  }

  static void checkMagazine(String[] magazine, String[] note) {
    Map<String, Integer> map = new HashMap<>();
    for (String word : magazine) {
      Integer count = map.get(word);
      if (count == null) {
        count = 0;
      }
      map.put(word, count + 1);
    }

    for (String word : note) {
      Integer count = map.get(word);
      if (count == null) {
        System.out.println("No");
        return;
      } else if (count == 1) {
        map.remove(word);
      } else {
        map.put(word, count - 1);
      }
    }

    System.out.println("Yes");
  }
}
