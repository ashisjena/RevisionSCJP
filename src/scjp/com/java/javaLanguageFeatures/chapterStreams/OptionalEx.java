package scjp.com.java.javaLanguageFeatures.chapterStreams;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class OptionalEx {
  public static void main(String[] args) {
    Optional<String> empty = Optional.empty();
    System.out.println(empty.orElse("DefaultString"));
    System.out.println(empty.orElseGet(() -> "DefaultString"));

    Optional<String> str = Optional.of("Hello");
    if (str.isPresent()) {
      String value = str.get();
      System.out.println("Optional contains " + value);
    } else {
      System.out.println("Optional is empty");
    }

    str.ifPresent(System.out::println);

    String nullableString = "";
    Optional<String> str2 = Optional.of(nullableString);

    OptionalInt maxOdd = IntStream.of(10, 20, 30).filter(n -> n % 2 == 1).max();
    System.out.println(maxOdd.orElse(0));

    OptionalInt maxOdd2 = IntStream.of(1, 10, 27, 31, 9).filter(n -> n % 2 == 1).max();
    maxOdd2.ifPresent(System.out::println);
  }
}
