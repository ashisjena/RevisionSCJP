package scjp.com.java.algorithm.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;

// https://www.hackerrank.com/challenges/new-year-chaos/problem
public class NewYearChaos {

  public static void main(String[] args) {
//    minimumBribes(new int[]{2, 1, 5, 3, 4});
//    minimumBribes(new int[]{2, 5, 1, 3, 4});
    minimumBribes(new int[]{1, 2, 5, 3, 7, 8, 6, 4});
  }

  public static void minimumBribes(int[] q) {
    List<Integer> list = new ArrayList<>();
    for (int i = q.length; i >= 1; i--) {
      list.add(i);
    }

    int noOfBribes = 0;

    for (int curr : q) {
      int lastIndex = list.size() - 1;

      if (list.get(lastIndex) == curr) {
        list.remove(lastIndex);
      } else if (list.get(lastIndex - 1) == curr) {
        list.remove(lastIndex - 1);
        noOfBribes++;
      } else if (list.get(lastIndex - 2) == curr) {
        list.remove(lastIndex - 2);
        noOfBribes += 2;
      } else {
        System.out.println("Too chaotic");
      }
    }

    System.out.println(noOfBribes);
  }

  static void swap(int[] arr, int k, int l) {
    int temp = arr[k];
    arr[k] = arr[l];
    arr[l] = temp;
  }
}
