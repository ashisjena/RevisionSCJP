package scjp.com.java.algorithm.companies.groupon;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result2 {

  /*
   * Complete the 'minNum' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER threshold
   *  2. INTEGER_ARRAY points
   */

  public static int minNum(int threshold, List<Integer> points) {
    if (points.get(points.size() - 1) - points.get(0) < threshold) {
      return points.size();
    }

    int result = 1;
    int startValue = points.get(0);
    boolean include = true;
    for (int i = 1; i < points.size(); i++) {
      if (points.get(i) - startValue >= threshold) {
        return ++result;
      }

      if (include) {
        include = false;
      } else {
        result++;
        include = true;
      }
    }
    return result;
  }


  public static void main(String[] args) throws IOException {
    System.out.println(minNum(4, Arrays.asList(new Integer[]{1, 3, 4, 7})));
  }
}
