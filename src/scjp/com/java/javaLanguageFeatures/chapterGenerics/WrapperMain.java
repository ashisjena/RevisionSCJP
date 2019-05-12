package scjp.com.java.javaLanguageFeatures.chapterGenerics;

public class WrapperMain {
  public static void main(String[] args) {
    Wrapper<Object> objectWrapper = new Wrapper<>(new Object());
    Wrapper<String> stringWrapper = new Wrapper<>("ram");
//    objectWrapper = stringWrapper; Can't happen;
//    Wrapper<?> unknownWrapper = new Wrapper<?>("");
    Wrapper<?> unknownWrapper = stringWrapper;
//    String str = unknownWrapper.get(); // Need to convince the compiler that it will not throw a ClassCastException
    Object obj = unknownWrapper.get();
//    unknownWrapper.set("hello");
//    unknownWrapper.set(new Object());
    unknownWrapper.set(null);
    WrapperUtil.printDetails(objectWrapper);
    WrapperUtil.printDetails(stringWrapper);

    Wrapper<Integer> integerWrapper = new Wrapper<>(10);
    Wrapper<Double> doubleWrapper = new Wrapper<>(10.5);
    System.out.println(WrapperUtil.sum(integerWrapper, doubleWrapper));

    integerWrapper.set(10);
    Wrapper<? extends Integer> numberWrapper = new Wrapper<>(10);
//    numberWrapper.set(10); // Error. The compiler doesn't know what is the exact type. So setting a double in-case of a integer wrapper can be problematic.

    WrapperUtil.copy(stringWrapper, objectWrapper);

    Test<String> t = new Test<>("Hello");
    t.m1(integerWrapper, integerWrapper, "hello");
  }
}

class Wrapper<T> {
  private T arg;
  public Wrapper(T arg){
    this.arg = arg;
  }
  public T get() {return arg;}
  public void set(T arg){this.arg = arg;}
  public <V> void method1(V value, T arg) {
    System.out.println(value.toString() + arg.toString());
  }
}

class Test<T> {
  public <U extends T> Test(U k){}
  public <V extends Number> void m1(Wrapper<V> w1, Wrapper<V> w2, T t){
  }
}

class WrapperUtil {
  public static void printDetails(Wrapper<?> wrapper){
   Object value = wrapper.get();
   String className = null;
   if(value != null){
     className = value.getClass().getName();
   }
   System.out.println("Class: " + className);
   System.out.println("Value: " + value);
  }

  public static double sum(Wrapper<? extends Number> n1, Wrapper<? extends Number> n2) {
    return n1.get().doubleValue() + n2.get().doubleValue();
  }

  public static <T> void copy(Wrapper<T> source, Wrapper<? super T> dest){
    T value = source.get();
    dest.set(value);
  }
}