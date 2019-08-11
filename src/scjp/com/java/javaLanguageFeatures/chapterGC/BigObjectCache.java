package scjp.com.java.javaLanguageFeatures.chapterGC;

import java.lang.ref.SoftReference;

public class BigObjectCache {
  private static final SoftReference<BigBigObject>[] cache = new SoftReference[10];

  public static BigBigObject getBigObjectById(int id) {
    if (id < 0 || id >= cache.length) {
      throw new IllegalArgumentException("Invalid id");
    }

    BigBigObject bigObject;

    if (cache[id] == null) {
      bigObject = createCacheForId(id);
      return bigObject;
    }

    bigObject = cache[id].get();

    if (bigObject == null) {
      // Garbage collector has claimed this object
      bigObject = createCacheForId(id);
    }
    return bigObject;
  }

  private static BigBigObject createCacheForId(int id) {
    BigBigObject obj = null;
    if (id >= 0 && id < cache.length) {
      obj = new BigBigObject(id);
      cache[id] = new SoftReference<BigBigObject>(obj);
    }
    return obj;
  }
}
