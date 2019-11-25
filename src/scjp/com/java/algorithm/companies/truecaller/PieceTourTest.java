package scjp.com.java.algorithm.companies.truecaller;

import org.junit.Before;
import org.junit.Test;
import scjp.com.java.algorithm.dynamicProgramming.PrintMatrix;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class PieceTourTest {
  private PieceTour pieceTour;

  @Before
  public void setUp() {
    this.pieceTour = new PieceTour(5);
  }

  private List<Pair<Integer, Integer>> getPairs(String... pairs) {
    List<Pair<Integer, Integer>> list = new ArrayList<>();
    for (String pair : pairs) {
      String[] xy = pair.trim().split("\\s+");
      list.add(new Pair<>(Integer.valueOf(xy[0]), Integer.valueOf(xy[1])));
    }
    return list;
  }

  @Test
  public void pieceTourTest() {
    boolean[][] isVisited = new boolean[5][5];
    List<Pair<Integer, Integer>> tour = this.pieceTour.pieceTour(new Pair<>(0, 0), isVisited);
    assertEquals(25, tour.size());
    PrintMatrix.print(isVisited);
    System.out.println(tour);
  }
}
