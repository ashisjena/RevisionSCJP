package scjp.com.java.algorithm.aapractice;

public class FindMaximumDiffBetweenTwoElementsInArray {
  public static void main(String[] args) {
    int arr[] = {2, 3, -5, 5, 1, 50, 20};

    int max = 0;
    int result = 0;

    for (int i = arr.length - 1; i >= 0; --i) {
      if (arr[i] > max)
        max = arr[i];

      int tmpResult = Math.abs(max - arr[i]);
      if (tmpResult > result)
        result = tmpResult;
    }
    
    System.out.println(result);
  }
}
