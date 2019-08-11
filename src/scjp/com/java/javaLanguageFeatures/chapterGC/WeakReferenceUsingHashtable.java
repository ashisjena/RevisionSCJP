package scjp.com.java.javaLanguageFeatures.chapterGC;

import scjp.com.java.chapter6.Employee;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class WeakReferenceUsingHashtable {
  public static void main(String[] args) throws InterruptedException {
    Hashtable<WeakReference<Employee>, WeakReference<BigBigObject>> ht = new Hashtable<>();
    ReferenceQueue<Employee> eq = new ReferenceQueue();
    ReferenceQueue<BigBigObject> vq = new ReferenceQueue();

    long m1, m2, m3;
    // Get a runtime instance
    Runtime rt = Runtime.getRuntime();
    m1 = rt.freeMemory();

    List<WeakReference<Employee>> wrList = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      Employee key = new Employee(10 + i, "Ram");
      BigBigObject value = new BigBigObject(10 + i);
      WeakReference<Employee> wKey = new WeakReference<>(key, eq);
      WeakReference<BigBigObject> wValue = new WeakReference<>(value, vq);
      ht.put(wKey, wValue);
      wrList.add(wKey);
    }

    m2 = rt.freeMemory();
    System.gc();
    m3 = rt.freeMemory();


    for (WeakReference<Employee> wKey : wrList) {
      System.out.println(wKey.get());
      System.out.println(ht.remove(wKey).get());
      /*if (wKey.isEnqueued()) {
        System.out.println("isEnqueued true");
        System.out.println(ht.remove(wKey));
      }*/
    }

    Thread.sleep(100);
    System.out.format("m1:%s, m2:%s, m3:%s%n", m1, m2, m3);

  }
}
