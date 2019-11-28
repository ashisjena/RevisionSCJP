package scjp.com.java.algorithm.old.aapractice;

public class FindMaximumDiffBetweenTwoElementsInArray {
  public static void main(String[] args) {
    int arr[] = {2, 3, -5, 5, 1, 50, -15, 20};

    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    for (int i = arr.length - 1; i >= 0; --i) {
      if (arr[i] > max)
        max = arr[i];

      if (arr[i] < min) {
        min = arr[i];
      }
    }

    System.out.println(max - min);
  }
}
