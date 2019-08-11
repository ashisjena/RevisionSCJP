package scjp.com.java.javaLanguageFeatures.chapterThread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinEx {
  public static void main(String[] args) {
    ForkJoinPool pool = new ForkJoinPool();
    RandomIntSum task = new RandomIntSum(3);

    long sum = pool.invoke(task);
    System.out.println("Sum is " + sum);
  }
}

class RandomIntSum extends RecursiveTask<Long> {
  private static final Random randGenerator = new Random();
  private final int count;

  public RandomIntSum(int count) {
    this.count = count;
  }

  @Override
  protected Long compute() {
    long result = 0;
    if (this.count <= 0) {
      return 0L;
    }
    if (this.count == 1) {
      return (long) this.getRandomInteger();
    }

    List<RecursiveTask<Long>> forks = new ArrayList<>();
    for (int i = 0; i < this.count; i++) {
      RandomIntSum subTask = new RandomIntSum(1);
      subTask.fork();
      forks.add(subTask);
    }

    for (RecursiveTask<Long> subTask : forks) {
      result = result + subTask.join();
    }
    return result;
  }

  public int getRandomInteger() {
    int n = randGenerator.nextInt(100) + 1;
    System.out.println("Generated a random Integer: " + n);
    return n;
  }
}
