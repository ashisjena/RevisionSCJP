package scjp.com.java.algorithm.datastructures.cache;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public class LRUCacheFinal<K, V> {

  private final int maxCacheSize;
  private LinkedHashMap<K, V> cache;

  private static final Field HEAD;
  private static final Field TAIL;

  static {
    TAIL = AccessController.doPrivileged((PrivilegedAction<Field>) () -> {
      try {
        Field field = LinkedHashMap.class.getDeclaredField("tail");
        field.setAccessible(true);
        return field;
      } catch (NoSuchFieldException e) {
        throw new RuntimeException(e);
      }
    });
    HEAD = AccessController.doPrivileged((PrivilegedAction<Field>) () -> {
      try {
        Field field = LinkedHashMap.class.getDeclaredField("head");
        field.setAccessible(true);
        return field;
      } catch (NoSuchFieldException e) {
        throw new RuntimeException(e);
      }
    });
    /*
    // With Java security manager this will fail.
    TAIL = LinkedHashMap.class.getDeclaredField("tail");
    TAIL.setAccessible(true);
    HEAD = LinkedHashMap.class.getDeclaredField("head");
    HEAD.setAccessible(true);
    */
  }

  public LRUCacheFinal(int maxCacheSize) {
    this.maxCacheSize = maxCacheSize;
    this.cache = new LinkedHashMap<>();
  }

  public void put(K key, V value) {
    if (cache.size() == this.maxCacheSize) {
      this.poll();
    }
    this.cache.put(key, value);
  }

  public V get(K key) {
    V value = this.cache.remove(key);
    if (value != null) {
      this.cache.put(key, value);
    }
    return value;
  }

  // Remove from Head, as LinkedHashMap adds at the tail/end
  private V poll() {
    try {
      K key = ((Map.Entry<K, V>) HEAD.get(this.cache)).getKey();
      return this.cache.remove(key);
    } catch (IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }

  public Stream<Map.Entry<K, V>> stream() {
    return this.cache.entrySet().stream();
  }
}
