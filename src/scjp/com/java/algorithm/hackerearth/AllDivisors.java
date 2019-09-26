package scjp.com.java.algorithm.hackerearth;

import java.io.IOException;
import java.util.Stack;


/*
input: 1st one is the no of cases.
3
4
6
8

output: Divisors
2
2 3
2 4


Last two testcases of the below are failing due to timeout. :( // Correct them.
 */
public class AllDivisors {

  public static void main(String[] args) {
    try (ConsoleReader cr = new ConsoleReader()) {
      int testCases = cr.readInt();

      long arr[] = new long[testCases];

      for (int i = 0; i < testCases; i++) {
        arr[i] = cr.readLong();
      }

      printDivisors(arr);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void printDivisors(long[] arr) {

    for (long num : arr) {
      long max = (long) Math.sqrt(num);

      Stack<Long> stack = new Stack<>();
      long i = 2;
      while (i <= max) {
        if (num % i == 0) {
          System.out.print(i + " ");
          if (num / i != i) {
            stack.push(num / i);
          }
        }
        i++;
      }

      while (!stack.isEmpty()) {
        System.out.print(stack.pop() + " ");
      }

      System.out.println();
    }
  }
}