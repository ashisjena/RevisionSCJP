package scjp.com.java.algorithm.companies.truecaller;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PieceTourTest {
  private PieceTour pieceTour;

  @Before
  public void setUp() {
    this.pieceTour = new PieceTour(10);
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
    assertThat(getPairs(
            "0 0", "3 0", "6 0", "9 0",
            "9 3", "9 6", "9 9", "6 9",
            "3 9", "0 9", "0 6", "3 6",
            "6 6", "6 3", "3 3", "0 3",
            "2 5", "5 5", "8 5", "8 8",
            "5 8", "2 8", "4 6", "7 6",
            "7 9", "4 9", "1 9", "1 6",
            "1 3", "4 3", "7 3", "7 0",
            "4 0", "1 0", "3 2", "6 2",
            "9 2", "9 5", "9 8", "6 8",
            "3 8", "0 8", "0 5", "3 5",
            "6 5", "8 7", "5 7", "2 7",
            "2 4", "5 4", "8 4", "8 1",
            "5 1", "2 1"), is(this.pieceTour.pieceTour(new Pair<>(0, 0))));
  }
}
