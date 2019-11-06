package scjp.com.java.algorithm.companies.groupon;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Solution {
  /*
   * Complete the 'minimumMoves' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY a
   *  2. INTEGER_ARRAY m
   */

  public static int minimumMoves(List<Integer> a, List<Integer> m) {
    int result = 0;
    for (int i = 0; i < a.size(); i++) {
      int movesForElement = 0;

      int numA = a.get(i);
      int numM = m.get(i);

      while (numA >= 1 || numM >= 1) {
        int remainderA = numA % 10;
        int remainderM = numM % 10;

        movesForElement += Math.abs(remainderA - remainderM);

        numA /= 10;
        numM /= 10;
      }
      result += movesForElement;
    }
    return result;

  }


  public static void main(String[] args) throws IOException {
    System.out.println(minimumMoves(Arrays.asList(new Integer[]{123, 543}), Arrays.asList(new Integer[]{321, 279})));

  }
    /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int aCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
      try {
        return bufferedReader.readLine().replaceAll("\\s+$", "");
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

    int mCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> m = IntStream.range(0, mCount).mapToObj(i -> {
      try {
        return bufferedReader.readLine().replaceAll("\\s+$", "");
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

    int result = Result.minimumMoves(a, m);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }*/
}
