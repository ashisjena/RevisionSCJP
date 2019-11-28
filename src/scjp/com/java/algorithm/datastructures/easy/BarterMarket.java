package scjp.com.java.algorithm.datastructures.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BarterMarket {
  public static int barterMarket(int comicBooks, int coins, int coinsNeeded, int coinsOffered) {
    int result = 0;
    int remainingComicBooks = comicBooks;

    while (remainingComicBooks > 0) {
      if (coins < coinsNeeded) {
        remainingComicBooks--;
        coins += coinsOffered;
      } else {
        remainingComicBooks--;
        coins -= coinsNeeded;
        result++;
      }
    }
    return result;
  }

  @Test
  public void barterMarketTest() {
    assertEquals(10, barterMarket(10, 10, 1, 1));
    assertEquals(2, barterMarket(4, 8, 4, 3));
    assertEquals(2, barterMarket(3, 6, 4, 5));
    assertEquals(212, barterMarket(393, 896, 787, 920));
  }

}
