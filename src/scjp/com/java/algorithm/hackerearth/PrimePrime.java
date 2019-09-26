package scjp.com.java.algorithm.hackerearth;

/*
Micro just learned about prime numbers. But he quickly got bored of them, so he defined a new kind of numbers and called them Prime Prime Numbers. A number X is Prime Prime if number of prime numbers from 1 to X (inclusive) are prime. Now he wants to find out the number of Prime Prime numbers from L to R (inclusive). Help Micro with it.

Input:
First line consists of a single integer T denoting number of test cases
Following T lines consists of two space separated integers denoting L and R

Output:
Print the number of Prime Prime Numbers for each between L and R for each test case in a new line.

SAMPLE INPUT
2
3 10
4 12
SAMPLE OUTPUT
4
5
*/

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PrimePrime {

  public static void main(String[] args) throws IOException {
    try (ConsoleReader cr = new ConsoleReader()) {
      int n = cr.readInt();

      int maximum = 0;
      List<Integer[]> list = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        int min = cr.readInt();
        int max = cr.readInt();
        Integer[] minMax = {min, max};
        list.add(minMax);

        if (maximum < max) {
          maximum = max;
        }
      }

      printNoOfPrimePrime(list, maximum);
    }
  }

  private static void printNoOfPrimePrime(List<Integer[]> list, int maximum) {

    boolean isCompositeNumber[] = new boolean[maximum + 1];

    // Compute all the prime numbers.
    // https://www.geeksforgeeks.org/sieve-of-eratosthenes/
    for (int p = 2; p * p <= maximum; p++) {
      if (isCompositeNumber[p] == false) {
        for (int i = p * p; i <= maximum; i += p) // 4, 6, 8 or // 25, 30, 35 i.e (p * p + 1)
          isCompositeNumber[i] = true;
      }
    }

    for (Integer[] arr : list) {
      int result = 0;
      int min = arr[0];
      int max = arr[1];

      int primeNumCount = 0;
      for (int i = 0; i <= max; i++) {
        if (!isCompositeNumber[i]) {
          primeNumCount++;
        }

        if (i >= min && !isCompositeNumber[primeNumCount]) {
          result++;
        }
      }

      System.out.println(result);
    }
  }
}
