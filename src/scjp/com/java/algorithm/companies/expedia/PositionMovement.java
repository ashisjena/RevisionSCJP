package scjp.com.java.algorithm.companies.expedia;

import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
LRLBRRLFLLRBBRLFRL
L : Turn left
R : Turn right
U : Turn back
F : move 1 step
Considering initial position is front facing, What is the new position?
Ex. 3 steps right and 2 steps straight.
 */
public class PositionMovement {

  public static final int TOTAL_DIRECTIONS = 4;

  String getFinalPosition(String str) {
    int x = 0, y = 0;
    int dir = 0;
    for (Character ch : str.toCharArray()) {
      switch (ch) {
        case 'L':
          dir = (dir - 1 + TOTAL_DIRECTIONS) % TOTAL_DIRECTIONS;
          break;
        case 'R':
          dir = (dir + 1) % TOTAL_DIRECTIONS;
          break;
        case 'B':
          dir = (dir + 2) % TOTAL_DIRECTIONS;
          break;
        case 'F':
          if (dir == 0) {
            // Forward Movement
            x++;
          } else if (dir == 1) {
            // Right Movement
            y--;
          } else if (dir == 2) {
            // Backward Movement
            x--;
          } else if (dir == 3) {
            // Left Movement
            y++;
          }
      }
    }

    return getResultString(x, y);
  }

  @NotNull
  private String getResultString(int x, int y) {
    if (x == 0 && y == 0) {
      return "Same Position";
    } else {
      String xAxisMovement = Math.abs(x) + " steps " + (x > 0 ? "Forward" : "Backward");
      String yAxisMovement = Math.abs(y) + " steps " + (y > 0 ? "Left" : "Right");

      if (x != 0 && y != 0) {
        return xAxisMovement + " and " + yAxisMovement;
      } else if (x == 0) {
        return yAxisMovement;
      } else {
        return xAxisMovement;
      }
    }
  }

  @Test
  public void testFinalPosition() {
    assertEquals("Same Position", getFinalPosition("LRFBFBFBF"));
    assertEquals("Same Position", getFinalPosition("LFFBFF"));
    assertEquals("3 steps Forward", getFinalPosition("LRFFF"));
    assertEquals("1 steps Backward", getFinalPosition("LRFBFF"));
    assertEquals("1 steps Left", getFinalPosition("LFFRRF"));
    assertEquals("1 steps Right", getFinalPosition("RFFBF"));
    assertEquals("2 steps Forward and 1 steps Right", getFinalPosition("LRRFLFF"));
    assertEquals("1 steps Backward and 1 steps Right", getFinalPosition("LRLBRRLFLLRBBRLFRL"));
  }
}
