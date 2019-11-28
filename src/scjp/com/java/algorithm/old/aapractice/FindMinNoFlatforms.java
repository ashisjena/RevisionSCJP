package scjp.com.java.algorithm.old.aapractice;

/*
Given arrival and departure times of all trains that reach a railway station, find the minimum number of platforms required for the railway station so that no train waits.
We are given two arrays which represent arrival and departure times of trains that stop

Examples:

Input:  arr[]  = {9:00,  9:40, 9:50,  11:00, 15:00, 18:00}
        dep[]  = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
Output: 3
There are at-most three trains at a time (time between 11:00 to 11:20)
 */

import java.util.Arrays;

public class FindMinNoFlatforms {

  public static void main(String[] args) {

    int arr[] = {900, 940, 950, 1100, 1500, 1800};
    int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
    Arrays.sort(arr);
    Arrays.sort(dep);
    System.out.println(findMin(arr, dep));

  }

  static int findMin(int[] arr, int[] dep) {
    int result = 1, platNeeded = 1;

    for (int i = 1, j = 0; i < arr.length && j < arr.length;) {
      if (arr[i] < dep[j]) {
        platNeeded++;
        i++;
        result = platNeeded > result ? platNeeded : result;
      } else {
        platNeeded--;
        j++;
      }
    }
    return result;
  }
}