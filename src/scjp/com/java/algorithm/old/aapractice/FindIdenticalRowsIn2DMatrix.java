package scjp.com.java.algorithm.old.aapractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindIdenticalRowsIn2DMatrix {
  public static void main(String[] args) {
    int inputArray[][] = 
       {{0, 1, 0, 1, 0}, 
        {1, 0, 1, 0, 1}, 
        {0, 1, 0, 1, 0}, 
        {0, 0, 0, 1, 0}, 
        {1, 0, 1, 0, 1}};
    
    Map<Long, StringBuilder> result = findSolution(inputArray, inputArray.length);

    for (StringBuilder builder : result.values()) {
      String[] arr = builder.toString().split("\\s+"); //(?!^)
      if (arr.length > 1)
        System.out.println(Arrays.toString(arr));
    }
  }

  private static Map<Long, StringBuilder> findSolution(int[][] inputArray, int height) {
    Map<Long, StringBuilder> map = new HashMap<>();
    for (int i = 0; i < height; i++) {
      long decimalValue = findDecimalValue(inputArray[i]);
      
      StringBuilder value = map.get(decimalValue);
      if (value == null) {
        value = new StringBuilder();
        value.append(i + " ");
        map.put(decimalValue, value);
      } else
        value.append(i + " ");
    }
    return map;
  }

  private static long findDecimalValue(int[] arr) {
    long result = 0;
    for (int i = arr.length - 1, j = 0; i >= 0; i--, j++)
      result += arr[i] * Math.pow(2, j);
    return result;
  }
}
