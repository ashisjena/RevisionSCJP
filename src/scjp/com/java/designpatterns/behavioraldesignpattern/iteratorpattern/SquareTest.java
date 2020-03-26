package scjp.com.java.designpatterns.behavioraldesignpattern.iteratorpattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class SquareTest {
  public static void main(String[] args) {
    printAll(take(25, squaresOf(Integers.all())));

    Stream.iterate(1, n -> n + 1).map(n -> n * n).limit(25).forEach(System.out::println);
  }

  private static void printAll(List<Integer> list) {
    list.forEach(System.out::println);
  }

  private static Iterator<Integer> squaresOf(Iterator<Integer> xs) {
    return new Mapper<Integer>().map(x -> x * x, xs);
  }

  private static List<Integer> take(int n, Iterator<Integer> xs) {
    return new Taker<Integer>().take(n, xs);
  }


  static class Integers implements Iterable<Integer> {
    static Iterator<Integer> all() {
      return new Integers().iterator();
    }

    @Override
    public Iterator<Integer> iterator() {
      return new Iterator<Integer>() {
        private int i = 1;

        @Override
        public boolean hasNext() {
          return true;
        }

        @Override
        public Integer next() {
          return i++;
        }
      };
    }
  }

  static class Taker<T> {
    List<T> take(int n, Iterator<T> xs) {
      List<T> taken = new ArrayList<>();
      for (int i = 0; xs.hasNext() && i < n; i++) {
        taken.add(xs.next());
      }
      return taken;
    }
  }

  static class Mapper<T> {
    Iterator<T> map(Function<T, T> func, Iterator<T> xs) {
      return new Iterator<T>() {
        @Override
        public boolean hasNext() {
          return xs.hasNext();
        }

        @Override
        public T next() {
          return func.apply(xs.next());
        }
      };
    }
  }
}
