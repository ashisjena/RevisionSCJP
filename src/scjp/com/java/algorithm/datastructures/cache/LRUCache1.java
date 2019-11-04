package scjp.com.java.algorithm.datastructures.cache;

import java.util.*;
import java.util.stream.Stream;

public class LRUCache1<K extends Comparable, V> {
  private Map<K, V> cache = new HashMap<>();
  private Deque<K> queue = new LinkedList<>();
  private int maxCacheSize;

  public LRUCache1(int maxCacheSize) {
    this.maxCacheSize = maxCacheSize;
  }

  public void put(K key, V value) {
    if (cache.size() == maxCacheSize) {
      K leastRecentlyUsedKey = queue.poll();
      cache.remove(leastRecentlyUsedKey);
    }
    cache.put(key, value);
    queue.offer(key);

    ArrayList a = new ArrayList();

    a.stream();
  }

  public V get(K key) {
    V value = cache.get(key);
    if (value == null) {
      return null;
    } else {
      // Check is the last element is not the recently accessed element?
      if (!queue.getLast().equals(key)) {
        queue.remove(key);
        queue.offer(key);
      }
      return value;
    }
  }

  public Stream<Map.Entry<K, V>> stream() {
    return this.cache.entrySet().stream();
  }
}
