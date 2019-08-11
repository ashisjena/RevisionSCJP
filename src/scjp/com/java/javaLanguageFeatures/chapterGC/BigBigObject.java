package scjp.com.java.javaLanguageFeatures.chapterGC;

public class BigBigObject {
  private final long longArray[] = new long[20480];
  private final long id;

  public BigBigObject(long id) {
    this.id = id;
  }

  @Override
  public void finalize() {
    System.out.format("finalize called for id: %s%n", this.id);
  }

  @Override
  public String toString() {
    return "BigObject->id:" + this.id;
  }
}
