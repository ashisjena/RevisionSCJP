package scjp.com.java.javaLanguageFeatures.chapterLambdaExpressions;

import java.util.function.*;

public class MapperTest {
  public static void main(String[] args) {
    String[] names = {"Ram", "Laxman", "Sita"};
    int[] lengthMapping = Mapper.mapToInt(names, String::length);
    printMapping(names, lengthMapping);

    Integer[] nums = {2, 5, 21};
    int[] squareNums = Mapper.mapToInt(nums, n -> n * n);
    printMapping(nums, squareNums);

    Function<Integer, Integer> square1 = x -> x * x;
    IntFunction<Integer> square2 = x -> x * x;
    ToIntFunction<Integer> square3 = x -> x * x;
    UnaryOperator<Integer> square4 = x -> x * x;
    System.out.println(square1.apply(5));
    System.out.println(square2.apply(5));
    System.out.println(square3.applyAsInt(5));
    System.out.println(square4.apply(5));

    Function<Long, Long> square = x -> x * x;
    Function<Long, Long> addOne = x -> x + 1;

    Function<Long, Long> squareAddOne = square.andThen(addOne);
    Function<Long, Long> addOneSquare = square.compose(addOne);
    Function<Long, Long> identify = Function.identity();

    long num = 5L;
    System.out.println("Square and then add one: " + squareAddOne.apply(num));
    System.out.println("Add one and then square: " + addOneSquare.apply(num));
    System.out.println("Identify: " + identify.apply(num));

//    Function<Long, Long> chainedFunction = ((Function<Long, Long>)(x -> x * x)).andThen(x -> x + 1).andThen(x -> x + 10);
    Function<Long, Long> chainedFunction = square.andThen(x -> x + 1).andThen(x -> x + 10);
    System.out.println("Chained Function: " + chainedFunction.apply(5L));

    BinaryOperator<Integer> func1 = Integer::sum;
    System.out.println(func1.apply(5, 10));
  }

  public static void printMapping(Object[] from, int[] to) {
    for (int i = 0; i < from.length; i++) {
      System.out.println(from[i] + " mapped to " + to[i]);
    }
  }
}

@FunctionalInterface
interface Mapper<T> {
  int map(T source);

  static <U> int[] mapToInt(U[] list, Mapper<? super U> mapper) {
    int[] mappedValues = new int[list.length];
    for (int i = 0; i < list.length; i++) {
      mappedValues[i] = mapper.map(list[i]);
    }
    return mappedValues;
  }
}
