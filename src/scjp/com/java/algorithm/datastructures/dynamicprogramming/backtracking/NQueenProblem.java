package scjp.com.java.algorithm.datastructures.dynamicprogramming.backtracking;

public class NQueenProblem {
  public static void main(String[] args) {
    helper(new int[4], 0);
  }

  private static boolean helper(int[] board, int i) {
    if (i == board.length) {
      for (int row : board) {
        for (int col = 0; col < board.length; col++) {
          if (col == row) {
            System.out.print(" Q ");
          } else {
            System.out.print(" 1 ");
          }
        }
        System.out.println();
      }
      return true;
    }

    outerLoop:
    for (int col = 0; col < board.length; col++) {
      for (int row = 0; row < i; row++) {
        if (board[row] == col || Math.abs(board[row] - col) == (i - row)) {
          continue outerLoop;
        }
      }

      board[i] = col;
      if (helper(board, i + 1)) {
        return true;
      }
    }

    return false;
  }
}
