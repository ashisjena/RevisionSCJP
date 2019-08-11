package scjp.com.java.javaLanguageFeatures.chapterThread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinFibonacci {
  public static void main(String[] args) {
    Fibonacci task = new Fibonacci(20L);
    long result = new ForkJoinPool().invoke(task);
    System.out.println(result);
  }
}

class Fibonacci extends RecursiveTask<Long> {
  private static final Long threshold = 10L;
  private final Long n;

  public Fibonacci(Long n) {
    this.n = n;
  }

  @Override
  protected Long compute() {
    if (n < threshold) {
      return this.fib(n);
    }
    Fibonacci f1 = new Fibonacci(n - 1);
    Fibonacci f2 = new Fibonacci(n - 2);
    ForkJoinTask.invokeAll(f1, f2);
    return f1.join() + f2.join();
  }

  public Long fib(Long n) {
    if (n <= 1) {
      return n;
    } else {
      return this.fib(n - 1) + this.fib(n - 2);
    }
  }
}

