package scjp.com.java.algorithm.old.recursion;

public class SumOfDigits {
  public static void main(String[] args) {
    System.out.println(sumOfDigits(123456));
  }

  private static int sumOfDigits(int num) {
    if (num % 10 == 0) {
      return num;
    }

    return num % 10 + sumOfDigits(num / 10);
  }
}
