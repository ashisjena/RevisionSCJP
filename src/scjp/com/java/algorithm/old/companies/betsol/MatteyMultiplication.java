package scjp.com.java.algorithm.old.companies.betsol;import java.io.IOException;

/*
 
Mattey Multiplication
Max. Marks 100

Mattey has an assignment that he should submit tomorrow. The assignment has one question which asks to write a program to multiply two numbers without using '*' operator. As Mattey finds no interest in this subject, he never listens to classes and so do not know about shift operators.

He comes to you to learn about this topic. You can explain in any manner you wish. But for this question, given N and M, write an equation using left shift operators whose result will be equal to the product N*M.

Input :
First line has T denoting number of test cases.
Next T lines has two integers N,M.

Output :
For each test case print an equation resembling "(N<<p1) + (N<<p2) + ... + (N<<pk)" (without quotes) where p1 ≥ p2 ≥ ... ≥ pk and k is minimum.

Constraints :
1 ≤ T ≤ 5*104
1 ≤ N,M ≤ 1016
Sample Input
(Plaintext Link)

2
2 1
2 3

Sample Output
(Plaintext Link)

(2<<0)
(2<<1) + (2<<0)

 */
public class MatteyMultiplication {
  public static void main(String[] args) throws IOException {
    StringBuilder result = new StringBuilder();
    try (ConsoleReader reader = ConsoleReader.getInstance()) {
      for (int i = reader.readInteger(); i > 0; i--) {
        Long[] input = reader.readLineNSplitWithSpace(Long.class);
        long a = input[0], b = input[1], x = a;
        StringBuilder sb = new StringBuilder(100);
        int count = (int) Math.floor(log(b,2));
        boolean bool = false;
        while (b != 0) // Iterate the loop till b==0
        {
          if ((b & 1) != 0) // Bitwise & of the value of b with 01
          {
            bool = true;
            sb.append("(" + x + "<<" + (int) Math.floor(log(a,2)) + ") + ");
            // result=result + a; // Add a to result if b is odd .
          }

          a <<= 1; // Left shifting the value contained in 'a' by 1
                   // multiplies a by 2 for each loop
          b >>= 1; // Right shifting the value contained in 'b' by 1.

        }
        result.append(sb.substring(0, sb.length() - 3) + System.lineSeparator());
      }
    } catch (IOException e) {
      throw e;
    }
    System.out.println(result.toString());
  }
  
  public static double log(long x, int base)
  {
      return Math.log(x) / Math.log(base);
  }
}
