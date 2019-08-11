package scjp.com.java.javaLanguageFeatures.chapterStreams;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream1stEx {
  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1, 3, 4, 5, 6, 7, 12, 8, 10);
//    list.parallelStream()
    int sum = list.stream().filter(ele -> ele % 2 == 0).map(ele -> ele * 2).reduce(0, Integer::sum);
    // filter and map are intermediate operations and are lazy. These will only be performed when a terminal operation(reduce in this case) is called on the stream.
    System.out.println(sum);

    // Collections support IMPERATIVE programming(What you want and how to get it) whereas streams support DECLARATIVE programming(What you want)

    sum = Stream.of(1, 3, 4, 5, 6, 7).filter(ele -> ele % 2 == 1).map(ele -> ele + 1).reduce(0, Integer::sum);
    System.out.println(sum);

    Stream<String> stream = Stream.<String>builder().add("Ram").add("Hari").add("Shyam").build();

    IntStream numbers = Arrays.stream(new int[]{1, 2, 3, 5, 6});

    Set<String> set = new HashSet<>();
    set.addAll(Arrays.asList("Ram", "Hari", "Govinda"));
    Stream<String> sequentialStream = set.stream();
    Stream<String> parallelStream = set.parallelStream();

    String str = "5 apples and 25 oranges";
    str.chars().filter(n -> !Character.isDigit((char) n) && !Character.isWhitespace((char) n)).forEach(n -> System.out.print((char) n));
    System.out.println();

    str = "Ken,Jeff,Lee";
    Pattern.compile(",").splitAsStream(str).forEach(System.out::println);

    // Stream of numbers from 1 to 10
//    Stream<Integer> nums = Stream.<Integer>iterate(1, n -> n <= 10, n -> n + 1); // Supported in Java 9
    // Infinite Stream of natural numbers;
    Stream<Integer> nums = Stream.iterate(1, n -> n + 1);

    // limit a infinite stream and can mention the max size
    Stream<Integer> limitStream = Stream.iterate(1, n -> n + 1).limit(10);

    System.out.println(Stream.iterate(2L, PrimeUtil::next).limit(15).collect(Collectors.toList()));

    Stream.iterate(2L, n -> n + 1).filter(PrimeUtil::isPrime).limit(7);

    Stream.iterate(2L, PrimeUtil::next).skip(100).limit(5).forEach(System.out::println);

    Stream.generate(Math::random).limit(5).forEach(System.out::println);

    Stream.generate(new PrimeUtil()::next).skip(100).limit(5);
  }
}

class PrimeUtil {
  private long lastPrime = 0L;

  public long next() {
    lastPrime = next(lastPrime);
    return lastPrime;
  }

  public static long next(long after) {
    long counter = after;
    while (!isPrime(++counter)) ;
    return counter;
  }

  public static boolean isPrime(long num) {
    if (num <= 1) {
      return false;
    }
    if (num == 2) {
      return false;
    }
    if (num % 2 == 0) {
      return false;
    }

    long maxDivisor = (long) Math.floor(Math.sqrt(num));
    for (int counter = 3; counter <= maxDivisor; counter += 2) {
      if (num % counter == 0) {
        return false;
      }
    }
    return true;
  }
}
