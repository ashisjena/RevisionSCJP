package scjp.com.java.algorithm.aapractice;

import java.io.IOException;
/*
 5
 9 6
 4 6 8
 0 7 1 6
 
 5 + 9 + 8 + 7 = 29
 */
public class FindMaximumSumOfTriangle {
  public static void main(String[] args) throws IOException, InterruptedException {

    String input = "5#9#6#4#6#8#0#7#1#6";
    System.out.println(getMaximunSum(input));

  }

  private static String getMaximunSum(String input) {

    if (!isValidSequence(input.length()/2 + 1))
      return "Invalid";
    
    int lineNo = 1;
    int count = 1;
    int max = Integer.MIN_VALUE;
    Long sum = 0l;
    
    for (String str : input.split("#")) {
      
      int val = Integer.parseInt(str);
      if (val > max)
        max = val;
      
      if (count == lineNo) {
        count = 1;
        lineNo++;
        sum += max;
        max = Integer.MIN_VALUE;
      } else
        count++;
    }
    return sum.toString();
  }

  private static boolean isValidSequence(long noOfValues) {

    int noOfLines = (int) Math.floor(Math.sqrt(noOfValues * 2));

    if ((noOfLines++ * noOfLines) / 2 == noOfValues)
      return true;
    else
      return false;
  }
}