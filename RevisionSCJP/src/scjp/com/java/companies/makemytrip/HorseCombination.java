package scjp.com.java.companies.makemytrip;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import scjp.com.java.hackerrank.ConsoleReader;
// The answer is wrong will correct it later 
public class HorseCombination {
  public static void main(String[] args) throws NumberFormatException, IOException {

    ConsoleReader reader = ConsoleReader.getInstance();
    int noOfCases = reader.readInteger();

    List<TestCaseBean> inputList = new ArrayList<>();
    for (int i = 0; i < noOfCases; i++) {
      Integer[] firstRowValues = reader.readLineNSplitWithSpace(Integer.class);
      TestCaseBean bean = new TestCaseBean(firstRowValues[2], firstRowValues[0], firstRowValues[1]);
      inputList.add(bean);
      for (int j = 0; j < bean.noOfHorse; j++) {
        Integer[] pos = reader.readLineNSplitWithSpace(Integer.class);
        int x = pos[0] - 1;
        int y = pos[1] - 1;
        bean.board[x][y][0] = true;
        bean.points.add(new Point(x, y));
      }
    }

    for (TestCaseBean bean : inputList) {
      long count = 0;
      for (Point point : bean.points) {
        bean.board[point.x][point.y][1] = true;
        List<Point> neighboringPoints = findNeighbouringPoints(point.x, point.y, bean.rowMax, bean.colMax);
        for (Point neghPoint : neighboringPoints) {
          if (bean.board[neghPoint.x][neghPoint.y][0] && !bean.board[neghPoint.x][neghPoint.y][1]) {
            count++;
            bean.board[neghPoint.x][neghPoint.y][1] = true;
          }
        }
      }
      System.out.println(count);
      System.out.println((long)Math.pow(2, count));
    }
  }

  static List<Point> findNeighbouringPoints(int row, int col, int rowMax, int colMax) {
    List<Point> list = new ArrayList<>();

    /*int startRow = Math.max(row - 1, 0);
    int endRow = Math.min(row + 1, rowMax - 1);
    int startCol = Math.max(col - 1, 0);
    int endCol = Math.min(col + 1, colMax - 1);

    for (int curRow = startRow; curRow <= endRow; curRow++)
      for (int curCol = startCol; curCol <= endCol; curCol++) {
        if (curRow == row && curCol == col)
          continue;

        list.add(new Point(curRow, curCol));
      }*/
    
    add(row + 2, col + 1, rowMax, colMax, list);
    add(row + 2, col - 1, rowMax, colMax, list);
    add(row - 2, col + 1, rowMax, colMax, list);
    add(row - 2, col - 1, rowMax, colMax, list);
    add(row + 1, col + 2, rowMax, colMax, list);
    add(row + 1, col - 2, rowMax, colMax, list);
    add(row - 1, col + 2, rowMax, colMax, list);
    add(row - 1, col - 2, rowMax, colMax, list);

    return list;
  }
  
  static void add(int row, int col, int rowMax, int colMax, List<Point> list)
  {
    if(!(row < 0 || col < 0 || row > rowMax - 1 || col > colMax - 1))
      list.add(new Point(row, col));
  }
  
  static class TestCaseBean {
    int noOfHorse;
    int rowMax;
    int colMax;
    boolean[][][] board;
    List<Point> points = new ArrayList<>();

    TestCaseBean(int noOfHorse, int rowMax, int colMax) {
      this.noOfHorse = noOfHorse;
      this.rowMax = rowMax;
      this.colMax = colMax;
      board = new boolean[rowMax][colMax][2];
    }
  }

  static class Point {
    int x;
    int y;

    private Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == null)
        return false;   
      else if (obj instanceof Point)
        return this.x == ((Point) obj).x && this.y == ((Point) obj).y;
      else
        return false;
    }

    @Override
    public String toString() {
      return x + "^" + y;
    }
  }
}
