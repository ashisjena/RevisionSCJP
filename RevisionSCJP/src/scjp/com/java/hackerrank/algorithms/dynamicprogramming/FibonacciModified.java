/*
 
Problem Statement

A series is defined in the following manner:

Given the nth and (n+1)th terms, the (n+2)th can be computed by the following relation
Tn+2 = (Tn+1)2 + Tn

So, if the first two terms of the series are 0 and 1:
the third term = 12 + 0 = 1
fourth term = 12 + 1 = 2
fifth term = 22 + 1 = 5
... And so on.

Given three integers A, B and N, such that the first two terms of the series (1st and 2nd terms) are A and B respectively, compute the Nth term of the series.

Input Format

You are given three space separated integers A, B and N on one line.

Input Constraints
0 <= A,B <= 2
3 <= N <= 20

Output Format

One integer.
This integer is the Nth term of the given series when the first two terms are A and B respectively.

Note

    Some output may even exceed the range of 64 bit integer.

Sample Input

0 1 5  

Sample Output

5

Explanation

The first two terms of the series are 0 and 1. The fifth term is 5. How we arrive at the fifth term, is explained step by step in the introductory sections.

 */

package scjp.com.java.hackerrank.algorithms.dynamicprogramming;

import java.io.IOException;
import java.math.BigInteger;

import scjp.com.java.hackerrank.ConsoleReader;

public class FibonacciModified {

  public static void main(String[] args) throws IOException {
   ConsoleReader reader = ConsoleReader.getInstance();
   Integer[] arr = reader.readLineNSplitWithSpace(Integer.class);
   Integer first = arr[0];
   Integer second = arr[1];
   int nthelement = arr[2];
   
   BigInteger nth_2_no = new BigInteger(first.toString());
   BigInteger nth_1_no = new BigInteger(second.toString());
   
   BigInteger nth = new BigInteger("0");
   for(int i = 2; i < nthelement; i++)
   {
     nth = nth_1_no.pow(2).add(nth_2_no);
     nth_2_no = nth_1_no;
     nth_1_no = nth;
   }
   
   System.out.println(nth.toString());
   reader.close();
  }

}
