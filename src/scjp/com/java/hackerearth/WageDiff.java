package scjp.com.java.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class WageDiff {
  public static void main(String args[]) throws Exception {
    ConsoleReader reader = new ConsoleReader();
    List<String> results = new ArrayList<>();
    int noOfTestCases = reader.readInt();
    for(int i = 0; i < noOfTestCases; i++)
    {
      int noOfDays = reader.readInt();
      int[] wagesOfA = reader.readLineIntArr();
      int[] wagesOfB = reader.readLineIntArr();
      for(int j = 0; j < noOfDays; j++)
        if(wagesOfA[j] != wagesOfB[j])
          results.add(wagesOfA[j] + " " + wagesOfB[j]);
    }
    
    for(String result : results)
      System.out.println(result);
  }
}