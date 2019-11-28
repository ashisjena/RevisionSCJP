package scjp.com.java.algorithm.old.companies.makemytrip.objectpool;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class ObjectPool<T> {
  private final long expirationTime;
  private final Map<T, Long> locked, unlocked;

  public ObjectPool() {
    expirationTime = 30000; // 30 seconds
    locked = new ConcurrentHashMap<>();
    unlocked = new ConcurrentHashMap<>();
  }

  protected abstract T create();

  public abstract boolean validate(T t);

  public abstract void expire(T t);

  public T checkOut() {
    long now = System.currentTimeMillis();
    for ( T t : this.unlocked.keySet()) {
      if ((now - unlocked.get(t)) > expirationTime) {
        // object has expired
        unlocked.remove(t);
        expire(t);
        t = null;
      } 
      else {
        if (validate(t)) {
          unlocked.remove(t);
          locked.put(t, now);
          return (t);
        } 
        else {
          // object failed validation
          unlocked.remove(t);
          expire(t);
          t = null;
        }
      }
    }
    // no objects available, create a new one
    T t = create();
    locked.put(t, now);
    return (t);
  }

  public synchronized void checkIn(T t) {
    locked.remove(t);
    unlocked.put(t, System.currentTimeMillis());
  }
}
