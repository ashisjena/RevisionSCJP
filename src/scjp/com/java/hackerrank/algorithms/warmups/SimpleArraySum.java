/*
 * Problem Statement
 * 
 * You are given an array of integers of size N. You need to print the sum of the elements of the
 * array.
 * 
 * Input Format The first line of the input consists of an integer N. The next line contains N
 * space-separated integers describing the array.
 * 
 * Constraints 1≤N≤1000 0≤A[i]≤1000
 * 
 * Output Format Output a single value equal to the sum of the elements of the array.
 * 
 * Sample Input
 * 
 * 6 1 2 3 4 10 11
 * 
 * Sample Output
 * 
 * 31
 * 
 * Explanation 1+2+3+4+10+11=31
 */


package scjp.com.java.hackerrank.algorithms.warmups;

import java.io.IOException;

import scjp.com.java.hackerrank.ConsoleReader;

public class SimpleArraySum {
  public static void main(String[] args) throws IOException {
    ConsoleReader.getInstance().readInteger();
    Integer[] nos = ConsoleReader.getInstance().readLineNSplitWithSpace(Integer.class);
    int sum = 0;
    for (int no : nos)
      sum += no;
    System.out.println(sum);
  }
}
