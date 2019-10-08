package scjp.com.java.algorithm.hackerrank.InterviewPreparationKit.Arrays;

// https://www.hackerrank.com/challenges/crush/problem
// https://youtu.be/hDhf04AJIRs?t=1442
public class ArrayManipulation {

  public static void main(String[] args) {
    /*int[][] queries = {
            {1, 2, 100},
            {2, 5, 100},
            {3, 4, 100}
          };*/
    int[][] queries = {
            {2, 6, 8},
            {3, 5, 7},
            {1, 8, 1},
            {5, 9, 15}
    };

    long result = arrayManipulation(10, queries);
    System.out.println(result);
  }

  static long arrayManipulation(int n, int[][] queries) {
    long[] arr = new long[n + 2];

    for (int[] query : queries) {
      int start = query[0];
      int end = query[1];
      int weight = query[2];

      arr[start] += weight;
      arr[end + 1] -= weight;
    }

    long max = 0l;
    for (int i = 1; i < arr.length; i++) {
      arr[i] = arr[i] + arr[i - 1];
      if (max < arr[i]) {
        max = arr[i];
      }
    }
    return max;
  }
}
