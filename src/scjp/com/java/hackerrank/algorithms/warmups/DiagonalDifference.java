/*
 * 
 * Problem Statement
 * 
 * You are given a square matrix of size N×N. Calculate the absolute difference of the sums across
 * the two main diagonals.
 * 
 * Input Format
 * 
 * The first line contains a single integer N. The next N lines contain N integers (each) describing
 * the matrix.
 * 
 * Constraints 1≤N≤100 −100≤A[i]≤100
 * 
 * Output Format
 * 
 * Output a single integer equal to the absolute difference in the sums across the diagonals.
 * 
 * Sample Input
 * 
 * 3 
 * 11 2 4 
 * 4  5 6 
 * 10 8 -12
 * 
 * Sample Output
 * 
 * 15
 * 
 * Explanation
 * 
 * The first diagonal of the matrix is:
 * 
 * 11 5 -12
 * 
 * Sum across the first diagonal = 11+5-12= 4
 * 
 * The second diagonal of the matrix is:
 * 
 * 4 5 10
 * 
 * Sum across the second diagonal = 4+5+10 = 19 Difference: |4-19| =15
 * 
 */

package scjp.com.java.hackerrank.algorithms.warmups;

import java.io.IOException;

import scjp.com.java.hackerrank.ConsoleReader;

public class DiagonalDifference {
  public static void main(String[] args) throws IOException {
    ConsoleReader reader = ConsoleReader.getInstance();
    int noOfLines = reader.readInteger();
    int sum1 = 0, sum2 = 0;
    for (int i = 0; i < noOfLines; i++) {
      Integer[] arr = reader.readLineNSplitWithSpace(Integer.class);
      sum1 += arr[i];
      sum2 += arr[arr.length - 1 - i];
    }
    System.out.println(Math.abs(sum1 - sum2));
  }
}
