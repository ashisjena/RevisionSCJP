package scjp.com.java.algorithm.companies.intralinks;

import java.util.*;
import java.util.stream.Collectors;

/*
arr = {1, 2, 3, 1, 2, 5}
maxNumberOfOddNumbers in a subarray = 2;

Subarray should not repeat.

No of subArrays
[[1], [2], [3], [5], [1, 2], [2, 3], [3, 1], [2, 5], [1, 2, 3], [2, 3, 1], [3, 1, 2], [1, 2, 5], [2, 3, 1, 2]]

Total numbers 13
 */
public class SubArrayWithOddNumbers {

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 1, 2, 3, 5,7};
    List<Integer> numbers = Arrays.stream(arr).boxed().collect(Collectors.toList());

    int k = 2;

    int result = numberOfSubArray(numbers, 2);
    System.out.println(result);
    System.out.println(numberOfSubArray2(numbers, k));
  }

  private static int numberOfSubArray2(List<Integer> numbers, int k) {
    int count = 0;
    int odd = 0;
    int prefix[] = new int[numbers.size()];

    for(int i = 0; i < numbers.size(); i++) {
      prefix[odd]++;

      if(numbers.get(i) % 2 == 1) {
        odd++;
      }

      if(odd >= k) {
        count += prefix[odd - k];
      }
    }

    return count;
  }

  private static int numberOfSubArray(List<Integer> numbers, int k) {

    Set<ArrayWrapper> uniqueSubArray = new HashSet<>();

    for (int i = 0; i < numbers.size(); i++) {
      List<List<Integer>> subArray = new ArrayList<>();

      int oddNumberCount = 0;
      for (int j = i; j < numbers.size(); j++) {
        if (numbers.get(j) % 2 == 1) {
          oddNumberCount++;
        }

        List<Integer> arr;
        if (oddNumberCount <= k) {
          if (subArray.size() == 0) {
            arr = new ArrayList<>();
            arr.add(numbers.get(j));
          } else {
            arr = new ArrayList<>(subArray.get(subArray.size() - 1));
            arr.add(numbers.get(j));
          }
          subArray.add(arr);
        } else {
          break;
        }
      }

      for (List<Integer> subArr : subArray) {
        uniqueSubArray.add(new ArrayWrapper(subArr));
      }
    }
    System.out.println(uniqueSubArray);
    return uniqueSubArray.size();
  }

  static class ArrayWrapper {
    private final List<Integer> list;

    public ArrayWrapper(List<Integer> list) {
      this.list = list;
    }

    @Override
    public boolean equals(Object obj) {
      return Arrays.equals(this.list.toArray(), ((ArrayWrapper) obj).list.toArray());
    }

    @Override
    public int hashCode() {
      return this.list.size();
    }

    @Override
    public String toString() {
      return list.toString();
    }
  }
}
