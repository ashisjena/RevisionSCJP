package scjp.com.java.javaLanguageFeatures.chapterThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExchangerEx {
  public static void main(String[] args) throws InterruptedException, ExecutionException {
    Exchanger<List<Integer>> exchanger = new Exchanger<>();

    Callable<List<Integer>> producer = () -> {
      System.out.println("Producer is filling Buffer");
      List<Integer> buffer = new ArrayList<>();
      for (int i = 1; i <= 5; i++) {
        buffer.add(i);
      }
      System.out.println("Producer has produced: " + buffer);
      System.out.println("Producer is waiting to exchange the data!");
      try {
        buffer = exchanger.exchange(buffer);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      return buffer;
    };

    Callable<List<Integer>> consumer = () -> {
      System.out.println("Consumer is waiting to exchange the data");
      List<Integer> buffer = new ArrayList<>();
      try {
        buffer = exchanger.exchange(buffer);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      return buffer;
    };

    ExecutorService es = Executors.newCachedThreadPool();
    Future<List<Integer>> pFuture = es.submit(producer);
    Future<List<Integer>> cFuture = es.submit(consumer);
    System.out.println("Producer received an empty buffer from consumer: " + pFuture.get());
    System.out.println("Consumer has received filled buffer: " + cFuture.get());
    es.shutdown();
  }
}
