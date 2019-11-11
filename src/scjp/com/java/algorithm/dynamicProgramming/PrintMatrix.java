package scjp.com.java.algorithm.dynamicProgramming;

public class PrintMatrix {

  public static void print(boolean[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        System.out.print(String.format("%8s", arr[i][j] + ""));
      }
      System.out.println();
    }
  }

  public static void print(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        System.out.print(String.format("%6d", arr[i][j]));
      }
      System.out.println();
    }
  }

  public static void print(long[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        System.out.print(arr[i][j] + "  ");
      }
      System.out.println();
    }
  }

  public static void print(double[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; i < arr[0].length; j++) {
        System.out.print(arr[i][j] + "  ");
      }
      System.out.println();
    }
  }
}
