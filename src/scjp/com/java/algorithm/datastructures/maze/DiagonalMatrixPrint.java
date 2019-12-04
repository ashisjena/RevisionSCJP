package scjp.com.java.algorithm.datastructures.maze;

import org.jetbrains.annotations.NotNull;
import org.junit.Test;
import scjp.com.java.algorithm.datastructures.graph.Pair;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class DiagonalMatrixPrint {
  @Test
  public void diagonalReverseMatrixTest() {
    int[][] arr = {{1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}};
    String expected = "3" + System.lineSeparator() +
            "2, 6" + System.lineSeparator() +
            "1, 5, 9" + System.lineSeparator() +
            "4, 8" + System.lineSeparator() +
            "7" + System.lineSeparator();

    assertEquals(expected, diagonalReverseMatrix1(arr));
    assertEquals(expected, diagonalReverseMatrix2(arr));
  }

  public String diagonalReverseMatrix1(int[][] arr) {
    boolean[][] isVisited = new boolean[arr.length][arr.length];

    Queue<Pair> queue = new LinkedList<>();
    queue.offer(new Pair(0, arr.length - 1));

    String result = "";

    while (!queue.isEmpty()) {
      Queue<Pair> innerQueue = new LinkedList<>();
      while (!queue.isEmpty()) {
        Pair pair = queue.poll();
        result += arr[pair.getX()][pair.getY()] + ", ";

        Stream.of(new Pair(pair.getX(), pair.getY() - 1), new Pair(pair.getX() + 1, pair.getY())).
                filter(isValidPair(arr.length, isVisited)).
                forEach(p -> {
                  isVisited[p.getX()][p.getY()] = true;
                  innerQueue.offer(p);
                });
      }
      result = getFormattedStr(result) + System.lineSeparator();
      queue = innerQueue;
    }

    return result;
  }

  @NotNull
  private String getFormattedStr(String result) {
    return result.trim().replaceAll(",$", "");
  }

  @NotNull
  private Predicate<Pair> isValidPair(int l, boolean[][] isVisited) {
    return p -> p.getX() < l && p.getX() >= 0 && p.getY() < l && p.getY() >= 0 &&
            !isVisited[p.getX()][p.getY()];
  }


  public String diagonalReverseMatrix2(int[][] arr) {
    int row, col;

    String result = "";
    for (int k = arr.length - 1; k >= 0; k--) {
      for (row = 0, col = k; row < arr.length && col < arr.length; row++, col++) {
        result += arr[row][col] + ", ";
      }
      result = getFormattedStr(result) + System.lineSeparator();
    }

    for (int k = 1; k < arr.length; k++) {
      for (row = k, col = 0; row < arr.length && col < arr.length; row++, col++) {
        result += arr[row][col] + ", ";
      }
      result = getFormattedStr(result) + System.lineSeparator();
    }

    return result;
  }
}