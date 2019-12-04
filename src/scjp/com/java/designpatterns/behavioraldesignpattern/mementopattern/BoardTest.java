package scjp.com.java.designpatterns.behavioraldesignpattern.mementopattern;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static scjp.com.java.designpatterns.behavioraldesignpattern.mementopattern.Board.*;

public class BoardTest {

  private Board board;
  private String standardLayout;

  @Before
  public void setUp() {
    board = new Board();
    standardLayout = "" +
            "WR,WN,WB,WK,WQ,WB,WN,WR," +
            "WP,WP,WP,WP,WP,WP,WP,WP," +
            "--,--,--,--,--,--,--,--," +
            "--,--,--,--,--,--,--,--," +
            "--,--,--,--,--,--,--,--," +
            "--,--,--,--,--,--,--,--," +
            "BP,BP,BP,BP,BP,BP,BP,BP," +
            "BR,BN,BB,BK,BQ,BB,BN,BR";
  }

  private void assertPieceAt(int expectedPiece, int file, int rank) {
    assertEquals(expectedPiece, board.getPiece(file, rank));
  }

  @Test
  public void canAddPiece() {
    board.setPiece(0, 0, ROOK);
    assertPieceAt(ROOK, 0, 0);

    board.setPiece(7, 7, PAWN);
    assertPieceAt(PAWN, 7, 7);
  }

  @Test
  public void setupBoard() {
    board.setup(standardLayout);

    assertPieceAt(ROOK, 0, 0);
    assertPieceAt(KNIGHT, 1, 0);
    assertPieceAt(BISHOP, 2, 0);
    assertPieceAt(KING, 3, 0);
    assertPieceAt(QUEEN, 4, 0);
    assertPieceAt(BISHOP, 5, 0);
    assertPieceAt(KNIGHT, 6, 0);
    assertPieceAt(ROOK, 7, 0);
    for (int file = 0; file < 8; file++) {
      assertPieceAt(PAWN, file, 1);
    }
    for (int rank = 2; rank < 6; rank++) {
      for (int file = 0; file < 8; file++) {
        assertPieceAt(EMPTY, file, rank);
      }
    }
    for (int file = 0; file < 8; file++) {
      assertPieceAt(-PAWN, file, 6);
    }
    assertPieceAt(-ROOK, 0, 7);
    assertPieceAt(-KNIGHT, 1, 7);
    assertPieceAt(-BISHOP, 2, 7);
    assertPieceAt(-KING, 3, 7);
    assertPieceAt(-QUEEN, 4, 7);
    assertPieceAt(-BISHOP, 5, 7);
    assertPieceAt(-KNIGHT, 6, 7);
    assertPieceAt(-ROOK, 7, 7);
  }

  @Test
  public void equals() {
    Board b2 = new Board();
    board.setup(standardLayout);
    b2.setup(standardLayout);
    assertEquals(board, b2);
  }

  @Test
  public void notEquals() {
    Board b2 = new Board();
    b2.setPiece(ROOK, 5, 5);
    board.setPiece(PAWN, 5, 5);
    assertFalse(board.equals(b2));
  }

  @Test
  public void simpleMemento() {
    Board b2 = new Board();
    board.setPiece(5, 5, PAWN);
    b2.setMemento(board.getMemento());
    assertEquals(PAWN, b2.getPiece(5, 5));
  }

  @Test
  public void blackMemento() {
    Board b2 = new Board();
    board.setPiece(5, 5, -PAWN);
    b2.setMemento(board.getMemento());
    assertEquals(-PAWN, b2.getPiece(5, 5));
  }

  @Test
  public void mementoStandardLayout() {
    board.setup(standardLayout);
    BoardMemento m = board.getMemento();
    Board b2 = new Board();
    b2.setMemento(m);
    assertTrue(board.equals(b2));
  }
}
