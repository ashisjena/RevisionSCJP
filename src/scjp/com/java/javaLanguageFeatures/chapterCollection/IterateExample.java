package scjp.com.java.javaLanguageFeatures.chapterCollection;

import java.util.ArrayList;
import java.util.List;

public class IterateExample {

  public static void main(String[] args) {
    List<String> names = new ArrayList<>();

    names.add("Ram");
    names.add("Shyam");
    names.add("Hari");

    names.iterator().forEachRemaining(System.out::println);
    names.forEach(System.out::println);
  }
}
