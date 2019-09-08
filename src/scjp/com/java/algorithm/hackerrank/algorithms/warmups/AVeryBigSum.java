/*
 * 
 * Problem Statement
 * 
 * You are given an array of integers of size N. You need to print the sum of the elements of the
 * array.
 * 
 * Note: The range of the 32-bit integer is −231 to 231−1 or [−2147483648,2147483647]. When we add
 * several integer values, the resulting sum might exceed this range. You might need to use long
 * long int in C/C++ or long data type in Java to store such sums.
 * 
 * Input Format
 * 
 * The first line of the input consists of an integer N. The next line contains N space-separated
 * integers describing the array.
 * 
 * Constraints 1≤N≤10 0≤A[i]≤1010
 * 
 * Output Format
 * 
 * Output a single value equal to the sum of the elements of the array.
 * 
 * Sample Input
 * 
 * 5 1000000001 1000000002 1000000003 1000000004 1000000005
 * 
 * Sample Output
 * 
 * 5000000015
 * 
 * 
 */

package scjp.com.java.algorithm.hackerrank.algorithms.warmups;

import java.io.IOException;
import java.math.BigInteger;

import scjp.com.java.algorithm.hackerrank.ConsoleReader;

public class AVeryBigSum {

  public static void main(String[] args) throws NumberFormatException, IOException {
    int countOfNumbers = ConsoleReader.getInstance().readInteger();
    BigInteger sum = new BigInteger("0");
    for (Integer no : ConsoleReader.getInstance().readLineNSplitWithSpace(Integer.class))
      sum = sum.add(new BigInteger(no.toString()));

    System.out.println(sum.toString());
    ConsoleReader.getInstance().close();
  }

}
