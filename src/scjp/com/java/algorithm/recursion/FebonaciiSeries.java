package scjp.com.java.algorithm.recursion;

public class FebonaciiSeries {
  public static Integer n = 10;

  public static void main(String[] args) {
    for (int i = 0; i <= 10; i++)
      System.out.print(febonacii(i) + " ");
  }

  private static int febonacii(int num) {
    if (num == 0 || num == 1)
      return num;
    else
      return febonacii(num - 1) + febonacii(num - 2);
  }
}