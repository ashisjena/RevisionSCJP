package scjp.com.java.designpatterns.behavioraldesignpattern.mementopattern;

import java.util.Arrays;

public class Board {
  public static final int PAWN = 1;
  public static final int ROOK = 2;
  public static final int KNIGHT = 3;
  public static final int BISHOP = 4;
  public static final int QUEEN = 5;
  public static final int KING = 6;
  public static final int EMPTY = 0;

  private int[] board = new int[64];

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Board)) return false;
    Board board1 = (Board) o;
    return Arrays.equals(board, board1.board);
  }

  public void setup(String layout) {
    String[] squares = layout.split(",");
    for (int i = 0; i < 64; i++) {
      int piece = EMPTY;
      switch (squares[i].charAt(1)) {
        case 'P':
          piece = PAWN;
          break;
        case 'R':
          piece = ROOK;
          break;
        case 'N':
          piece = KNIGHT;
          break;
        case 'B':
          piece = BISHOP;
          break;
        case 'Q':
          piece = QUEEN;
          break;
        case 'K':
          piece = KING;
          break;
      }

      if (squares[i].charAt(0) == 'B') {
        piece = -piece;
      }
      board[i] = piece;
    }
  }
}
