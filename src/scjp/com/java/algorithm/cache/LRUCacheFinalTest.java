package scjp.com.java.algorithm.cache;

import org.junit.Test;

import static org.junit.Assert.*;

public class LRUCacheFinalTest {

  @Test
  public void put() {
    LRUCacheFinal<String, String> cache = new LRUCacheFinal<>(5);
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
    LRUCacheFinal<String, String> cache = new LRUCacheFinal<>(5);
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