package scjp.com.java.javaLanguageFeatures.chapterReflection;

// Bootstrap class loader <--> Extension class loader <--> Application class loader
public class TestClass {
  public static void main(String[] args) {
    System.out.println(int.class);
    System.out.println(Integer.TYPE); // The TYPE of a wrapper class is same as the class of primitive. Here it's "int"
    System.out.println(Integer.class);

    System.out.println(byte.class);
    System.out.println(boolean.class);
    System.out.println(char.class);
    System.out.println(short.class);
    System.out.println(long.class);

    System.out.println(void.class);
  }
}
