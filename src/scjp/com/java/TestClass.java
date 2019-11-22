package scjp.com.java;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestClass {
  private Math math;

  @Before
  public void setUp() {
    this.math = new Math(4, 7);
  }

  @Test
  public void addTest() {
    Assert.assertEquals(11, this.math.add());
  }

  @Test(expected = ArithmeticException.class)
  public void divideTest() {
    Math math = new Math(10, 0);
    math.divide();
  }

  @Test
  public void multiTest() {
    Assert.assertEquals(28, this.math.multi());
  }

  @Test
  public void multiTestZero() {
    Math math = new Math(0, 1);
    Assert.assertEquals(0, math.multi());
  }
}


class Math {
  int x, y;

  public Math(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int add() {
    return x  +  y;
  }

  public int divide() {
    return x / y;
  }

  public int multi() {
    return x * y;
  }
}