package scjp.com.java.algorithm.aapractice;

/*
 * I have been asked to give a dynamic algorithm that would take a sequence of an even amount of
 * numbers (both positive and negative) and do the following:
 * 
 * Each "turn" two numbers are chosen to be multiplied together. The algorithm can only access
 * either end of the sequence. However, if the first number chosen is the leftmost number, the
 * second number can be either the rightmost number, or the new leftmost number (since the old
 * leftmost number has already been "removed/chosen") and vice-versa. The objective of the program
 * is to find the maximum total sum of the products of the two numbers chosen each round.
 * 
 * Example:
 * 
 * Sequence: { 10, 4, 20, -5, 0, 7 }
 * 
 * Optimal result: 7*10 + 0*-5 + 4*20 = 150
 */


public class FindMaximumSumOfProducts {

  public static void main(String[] args) {
    int[] arr = {3,9,7,1,8,2};
    System.out.println(findMaximumSum(arr, 0, arr.length - 1));
  }

  private static int findMaximumSum(int[] arr, int start, int end) {
    if (end - start == 1)
      return arr[start] * arr[end];
    
    return findMaximum(
        findMaximumSum(arr, start + 2, end) + (arr[start] * arr[start + 1]), 
        findMaximumSum(arr, start + 1, end - 1) + (arr[start] * arr[end]),
        findMaximumSum(arr, start, end - 2)+ (arr[end] * arr[end - 1])
        );
  }

  private static int findMaximum(int x, int y, int z) {
    System.out.println(x + " " + y + " " + z);
    return Math.max(Math.max(x, y), z);
  }
}