package scjp.com.java.algorithm.datastructures.string;

import org.junit.Test;

import java.util.LinkedList;
import java.util.TreeSet;

import static junit.framework.TestCase.assertTrue;

/*
  Company: Amazon
  String s1 "This is the to very big string"
  String s2 "stit"

  find minimum substring from s1 that contains all the chars from s2.
  Note: order of s2 doesn't matter.

  Ex. the below substring contains all the chars from s2.
  1) "This is t"
  2) "is the t"
  3) "to very big stri"
  4) "the to very big stri" etc....
  So the answer will be the shortest. i.e the 2nd one.
 */
public class FindSmallestSubString {

  private TreeSet<String> sortedSet = new TreeSet<>();

  public void smallestSubString(String str, String s2, LinkedList<Integer> indexes, int indx) {
    if (indx == str.length()) {
      return;
    }
    if (indexes.size() == 4) {
      this.sortedSet.add(str.substring(indexes.peekFirst(), indexes.peekLast() + 1));
      return;
    }

    while (indx < str.length()) {
      String c = String.valueOf(str.charAt(indx));
      if (s2.contains(c)) {
        indexes.offer(indx);
        s2 = s2.replaceFirst(c, "");
      }
      smallestSubString(str, s2, indexes, indx + 1);
      if (indexes.size() == 4) {
        int i = indexes.poll();
        s2 = String.valueOf(str.charAt(i));
        int x = str.indexOf(s2, i + 1);
        indx = x != -1 ? x : indexes.peekLast() + 1;
      } else {
        break;
      }
    }
  }

  @Test
  public void smallestSubStringTest() {
    FindSmallestSubString obj = new FindSmallestSubString();
    obj.smallestSubString("this is the to", "stit", new LinkedList<>(), 0);
    assertTrue(true);
  }

}
