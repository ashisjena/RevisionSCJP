package scjp.com.java.algorithm.datastructures.cache;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class LRUCache1Test {

  @Test
  public void put() {
    LRUCache1<String, String> cache = new LRUCache1<>(5);
    cache.put("ram", "");
    cache.put("sita", "");
    cache.put("ravan", "");
    cache.put("laxman", "");
    cache.put("hanuman", "");
    cache.put("dasharath", "");

    Object[] result = cache.stream().map(entry -> entry.getKey()).toArray();
    String[] expected = {"sita", "ravan", "laxman", "hanuman", "dasharath"};

    assertArrayEquals("LRU cache put not working", result, expected);
  }

  @Test
  public void get() {
    LRUCache1<String, String> cache = new LRUCache1<>(5);
    cache.put("ram", "");
    cache.put("sita", "");
    cache.put("ravan", "");
    cache.put("laxman", "");
    cache.put("hanuman", "");
    cache.get("ravan");

    Object[] result = cache.stream().map(entry -> entry.getKey()).toArray();
    String[] expected = {"ram", "sita", "laxman", "hanuman", "ravan"};

    assertArrayEquals("LRU cache get not working", result, expected);
  }
}