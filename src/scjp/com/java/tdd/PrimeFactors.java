package scjp.com.java.tdd;

import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PrimeFactors {

  private void assertPrimeFactors(List<Integer> expected, int n) {
    assertEquals(expected, getPrimeFactors(n));
  }

  @NotNull
  private List<Integer> listOf(Integer... primes) {
    return Arrays.asList(primes);
  }

  @Test
  public void getPrimeFactorsTest() {
    assertPrimeFactors(listOf(), 1);
    assertPrimeFactors(listOf(2), 2);
    assertPrimeFactors(listOf(3), 3);
    assertPrimeFactors(listOf(2, 2), 4);
    assertPrimeFactors(listOf(5), 5);
    assertPrimeFactors(listOf(2, 3), 6);
    assertPrimeFactors(listOf(7), 7);
    assertPrimeFactors(listOf(2, 2, 2), 8);
    assertPrimeFactors(listOf(3, 3), 9);
    assertPrimeFactors(listOf(2, 2, 3, 3, 3, 5, 7, 17), 2 * 2 * 3 * 3 * 3 * 5 * 7 * 17);
  }

  private List<Integer> getPrimeFactors(int n) {
    List<Integer> primeFactors = new ArrayList<>();
    for (int divisor = 2; n >= divisor; divisor++) {
      for (; n % divisor == 0; n /= divisor) {
        primeFactors.add(divisor);
      }
    }
    return primeFactors;
  }
}
