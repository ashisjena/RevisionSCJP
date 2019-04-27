/*
 * Input Format
 * 
 * The first line contains T (number of test cases) followed by T lines. Each line contains A and B,
 * separated by a space.
 * 
 * Output Format
 * 
 * An integer representing the sum in a new line for every testcase.
 * 
 * Constraints 1≤T,A,B≤1000
 * 
 * Sample Input
 * 
 * 2 2 3 3 7
 * 
 * Sample Output
 * 
 * 5 10
 * 
 * Explanation
 * 
 * 2 in the first line describes how many lines will follow, and your test cases are 2, 3 and 3, 7
 * in two separate lines. Your output should be 5 and 10 printed on two separate lines. If you print
 * extra lines or any extra characters in your output your answer will not get accepted, as the
 * judging is done using a diff checker.
 * 
 */
package scjp.com.java.hackerrank.algorithms.warmups;

import java.io.IOException;

import scjp.com.java.hackerrank.ConsoleReader;

public class SolveMeSecond {

  public static void main(String[] args) throws NumberFormatException, IOException {
    int noOfLines = ConsoleReader.getInstance().readInteger();
    for (int i = 0; i < noOfLines; i++) {
      int sum = 0;
      for (Integer no : ConsoleReader.getInstance().readLineNSplitWithSpace(Integer.class)) {
        sum += no;
      }
      System.out.println(sum);
    }
    ConsoleReader.getInstance().close();
  }
}

