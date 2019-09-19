package scjp.com.java.algorithm.cache;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache<K extends Comparable, V> {
  private Map<K, V> cache = new HashMap<>();
  private Deque<K> queue = new LinkedList<>();
  private int maxCacheSize;

  public LRUCache(int maxCacheSize) {
    this.maxCacheSize = maxCacheSize;
  }

  public void put(K key, V value) {
    if (cache.size() == maxCacheSize) {
      K leastRecentlyUsedKey = queue.poll();
      cache.remove(leastRecentlyUsedKey);
    }
    cache.put(key, value);
    queue.offer(key);
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

  public static void main(String[] args) {
    LRUCache<String, String> cache = new LRUCache<>(5);

    cache.put("ram", "raja");
    cache.put("sita", "maiya");
    cache.put("ravan", "king");
    cache.put("laxman", "bro");
    cache.put("hanuman", "powerful");
    cache.get("sita");
    cache.get("hanuman");
    cache.get("ram");
    cache.get("sita");
    cache.get("laxman");
    cache.get("ram");
    cache.get("hanuman");
    cache.get("ram");
    cache.get("ravan");
    cache.put("dasharath", "king");
  }
}
