package scjp.com.java.algorithm.old.companies.makemytrip;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import scjp.com.java.algorithm.hackerrank.ConsoleReader;

public class WitchProblem {
  public static void main(String[] args) throws NumberFormatException, IOException {
    ConsoleReader reader = ConsoleReader.getInstance();

    int noOfLines = reader.readInteger();
    List<Long[]> inputList = new ArrayList<>();

    for (int i = 0; i < noOfLines; i++)
      inputList.add(reader.readLineNSplitWithSpace(Long.class));

    for (Long[] heights : inputList)
      System.out.println(Math.max(heights[2] - heights[1], heights[1] - heights[0]) - 1);

    reader.close();
  }
}
