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

  public int getPiece(int file, int rank) {
    return board[rank * 8 + file];
  }

  public void setPiece(int file, int rank, int piece) {
    board[rank * 8 + file] = piece;
  }

  public BoardMemento getMemento() {
    BoardMementoImpl mi = new BoardMementoImpl();
    mi.pack(board);
    return mi;
  }

  public void setMemento(BoardMemento m) {
    BoardMementoImpl mi = (BoardMementoImpl) m;
    board = mi.unpack();
  }

  private static class BoardMementoImpl implements BoardMemento {
    private byte[] memo = new byte[32];

    private void pack(int[] board) {
      for (int i = 0; i < 32; i++) {
        int nibble1 = board[i * 2] & 0xf;
        int nibble2 = board[i * 2 + 1] & 0xf;
        memo[i] = (byte) (nibble1 << 4 | nibble2);
      }
    }

    private int[] unpack() {
      int[] board = new int[64];
      for (int i = 0; i < 32; i++) {
        int nibble1 = memo[i] >> 4 & 0xf;
        int nibble2 = memo[i] & 0xf;
        nibble1 = extendSign(nibble1);
        nibble2 = extendSign(nibble2);
        board[i * 2] = nibble1;
        board[i * 2 + 1] = nibble2;
      }
      return board;
    }

    private int extendSign(int nibble) {
      if ((nibble & 0x8) == 0x8) {
        return nibble | (-1 & (~0xf));
      } else {
        return nibble;
      }
    }
  }
}




