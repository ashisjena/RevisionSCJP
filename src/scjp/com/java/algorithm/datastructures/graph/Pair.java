package scjp.com.java.algorithm.datastructures.graph;

import java.util.Objects;

public class Pair {
  int x, y;

  public static Pair of(int x, int y) {
    return new Pair(x, y);
  }

  public Pair(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  @Override
  public String toString() {
    return "Pair{" +
            "x=" + x +
            ", y=" + y +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Pair)) return false;
    Pair pair = (Pair) o;
    return x == pair.x &&
            y == pair.y;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }
}