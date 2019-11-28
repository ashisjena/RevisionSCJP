package scjp.com.java.algorithm.datastructures.maze.truecaller;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PieceTourTest {
  class Prev<K, V> {
    Pair<K, V> value;

    Prev(Pair<K, V> next) {
      this.value = next;
    }
  }

  private List<Pair<Integer, Integer>> getTourRoute(int x, int y, int matrixLength) {
    return new PieceTour(matrixLength).getTourRoute(new Pair<>(x, y));
  }

  private boolean arePositionsSequential(List<Pair<Integer, Integer>> tourRoute) {
    if (tourRoute.size() > 0) {
      Prev<Integer, Integer> prev = new Prev<>(tourRoute.get(0));
      return tourRoute.stream().skip(1).noneMatch(curr -> {
        int xDiff = Math.abs(prev.value.getX() - curr.getX()),
                yDiff = Math.abs(prev.value.getY() - curr.getY());
        prev.value = curr;
        return !((xDiff == 3 && yDiff == 0) || (xDiff == 0 && yDiff == 3) || (xDiff == 2 && yDiff == 2));
      });
    } else {
      return false;
    }
  }

  private void assertTourRoute(int x, int y, int matrixLength) {
    List<Pair<Integer, Integer>> tourRoute = getTourRoute(x, y, matrixLength);
    assertTrue(arePositionsSequential(tourRoute));
    assertEquals(matrixLength * matrixLength, tourRoute.size());
  }

  @Test
  public void tourRouteTest() {
    int matrixLength = 10;
    for (int x = 0; x < matrixLength; x++) {
      for (int y = 0; y < matrixLength; y++) {
        assertTourRoute(x, y, matrixLength);
      }
    }
  }
}
