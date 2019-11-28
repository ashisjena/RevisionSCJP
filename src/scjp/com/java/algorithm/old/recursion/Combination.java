package scjp.com.java.algorithm.old.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Combination {
  public static void main(String[] args) {
    printCombination(new int[]{1, 2, 3, 4, 5}, 3);
  }

  public static void printCombination(int arr[], int r) {
    Integer data[] = new Integer[r];
    List<List<Integer>> results = new ArrayList<>();
    combination1(arr, data, 0, 0, r, results);
//    combination2(arr, data, 0, 0, r, results);
    results.stream()
           .forEach(System.out::println);
  }

  /*
  Method 1 (Fix Elements and Recur)
  We create a temporary array ‘data[]’ which stores all outputs one by one. The idea is to start from first index (index = 0) in data[],
  one by one fix elements at this index and recur for remaining indexes. Let the input array be {1, 2, 3, 4, 5} and r be 3.
  We first fix 1 at index 0 in data[], then recur for remaining indexes, then we fix 2 at index 0 and recur.
  Finally, we fix 3 and recur for remaining indexes. When number of elements in data[] becomes equal to r (size of a combination),
  we print data[].
  */
  private static void combination1(int allElements[], Integer data[], int start, int index, int r, List<List<Integer>> results) {
    if (index == r) {
      results.add(Arrays.stream(data)
                        .collect(Collectors.toList())); // Cloning as we manipulate the same data array.
      return;
    }

    for (int i = start; i < allElements.length; i++) {
      data[index] = allElements[i];
      combination1(allElements, data, i + 1, index + 1, r, results);
    }
  }

  /*
  Method 2 (Include and Exclude every element)
  Like the above method, We create a temporary array data[]. The idea here is similar to Subset Sum Problem.
  We one by one consider every element of input array, and recur for two cases:
  1) The element is included in current combination (We put the element in data[] and increment next available index in data[])
  2) The element is excluded in current combination (We do not put the element and do not change index)

  When number of elements in data[] become equal to r (size of a combination), we print it.

  This method is mainly based on Pascal’s Identity, i.e. nCr = n-1Cr + n-1Cr-1
  */
  private static void combination2(int allElements[], Integer[] data, int start, int index, int r, List<List<Integer>> results) {
    if (index == r) {
      results.add(Arrays.stream(data)
                        .collect(Collectors.toList())); // Cloning as we manipulate the same data array.
      return;
    }

    // When no more element is there to put in data[]
    if (start == allElements.length) {
      return;
    }

    // current is included, put next at next location
    data[index] = allElements[start];
    combination2(allElements, data, start + 1, index + 1, r, results);
    // current is excluded, replace it with next (Note that i+1 is passed, but index is not changed)
    combination2(allElements, data, start + 1, index, r, results);
  }
}
