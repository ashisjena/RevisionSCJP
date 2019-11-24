package scjp.com.java.algorithm.companies.truecaller;

import java.util.Objects;

public class Pair<K, V> {
  private final K x;
  private final V y;

  public Pair(K x, V y) {
    this.x = x;
    this.y = y;
  }

  public K getX() {
    return x;
  }

  public V getY() {
    return y;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Pair)) return false;
    Pair<?, ?> pair = (Pair<?, ?>) o;
    return Objects.equals(getX(), pair.getX()) &&
            Objects.equals(getY(), pair.getY());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getX(), getY());
  }

  @Override
  public String toString() {
    return "{" +
            "x=" + x +
            ", y=" + y +
            '}';
  }
}