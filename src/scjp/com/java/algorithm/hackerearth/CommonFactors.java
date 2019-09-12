package scjp.com.java.algorithm.hackerearth;

/*
Input:
First line of the input file contains two integers, a and b.

Output:
Print the number of common factors of a and b.

Constraints:
1 <= a, b <= 10^12

ex: 10, 15 --> 2
 */

public class CommonFactors {
    public static void main(String[] args) {
        ConsoleReader reader = new ConsoleReader();

        long a = reader.readLong();
        long b = reader.readLong();

        System.out.println(findCommonFactor(Math.min(a, b), Math.max(a, b)));
    }

    private static long gcd(long a, long b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

    private static long findCommonFactor(long a, long b) {
        long gcd = gcd(a, b);

        long count = 0;
        for (long i = 1; i * i <= gcd; i++) {
            if (gcd % i == 0) {
                if (i * i == gcd) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }
}


