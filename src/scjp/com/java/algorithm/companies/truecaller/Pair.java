package scjp.com.java.algorithm.companies.truecaller;

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
  public String toString() {
    return String.format("{x=%s, y=%s}", x, y);
  }
}