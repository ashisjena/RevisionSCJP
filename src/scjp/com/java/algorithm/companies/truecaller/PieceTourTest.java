package scjp.com.java.algorithm.companies.truecaller;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PieceTourTest {
  private List<Pair<Integer, Integer>> getTourRoute(int x, int y, int matrixLength) {
    return new PieceTour(matrixLength).getTourRoute(new Pair<>(x, y));
  }

  @Test
  public void tourRouteTest() {
    assertEquals(100, getTourRoute(7, 1, 10).size());
    assertEquals(100, getTourRoute(0, 0, 10).size());
    assertEquals(100, getTourRoute(4, 5, 10).size());
    assertEquals(100, getTourRoute(5, 9, 10).size());
  }
}
