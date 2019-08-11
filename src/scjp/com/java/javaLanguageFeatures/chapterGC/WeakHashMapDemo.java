package scjp.com.java.javaLanguageFeatures.chapterGC;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapDemo {
  public static void main(String[] args) {
    WeakHashMap<BigBigObject, BigBigObject> weakHashMap = new WeakHashMap<>();
    for (int i = 1; i <= 10; i++) {
      weakHashMap.put(new BigBigObject(10 * i), new BigBigObject(100 + 10 * i));
    }
    System.out.println("Before GC invocation");
    printMap(weakHashMap);
    System.gc();
    System.out.println("After GC invocation");
    printMap(weakHashMap);
  }

  private static void printMap(WeakHashMap<BigBigObject, BigBigObject> map) {
    System.out.println("Size: " + map.size());
    System.out.println("Keys: " + map.keySet());
    System.out.println("Values: " + map.values());
    System.out.println();
  }
}
