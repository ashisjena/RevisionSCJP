package scjp.com.java.algorithm.datastructures.numbers;

public class PerfectNumbers2 {

  // Utility function to compute
  // n'th palindrome number
  static String solve(int n, char x, char y) {
    // Calculate the length from above
    // formula as discussed above
    int length = (int) Math.ceil(Math.log(n + 2) /
        Math.log(2)) - 1;

    // Calculate rank for length L
    int rank = n - (1 << length) + 1;

    String left = "", right = "";

    for (int i = length - 1; i >= 0; i--) {

      // Mask to check if i't bit
      // is set or not
      int mask = (1 << i);

      // If bit is set append '5' else append '4'
      int bit = mask & rank;

      if (bit > 0) {
        left += y;
        right += y;
      } else {
        left += x;
        right += x;
      }
    }

    StringBuilder sb = new StringBuilder(right);
    sb.reverse();

    right = sb.toString();

    String res = left + right;
    return res;
  }

  // Driver Code
  public static void main(String[] args) {
    int n = 23;
    char x = '4', y = '5';
    String ans = solve(n, x, y);
    System.out.println(ans);
  }
}
