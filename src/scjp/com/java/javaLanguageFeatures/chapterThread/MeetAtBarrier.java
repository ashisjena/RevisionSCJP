package scjp.com.java.javaLanguageFeatures.chapterThread;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.*;

public class MeetAtBarrier {
  public static void main(String[] args) {
    Random random = new Random();

    Runnable barrierAction = () -> System.out.println("We are all together. It's party time!!");
    CyclicBarrier barrier = new CyclicBarrier(3, barrierAction);

    Runnable thread = () -> {
      LocalDateTime startTime = LocalDateTime.now();
      int workTime = random.nextInt(500) + 1;
      System.out.println(Thread.currentThread().getName() + " thread will work for " + workTime + "ms");
      try {
        Thread.sleep(workTime);
        System.out.println(Thread.currentThread().getName() + " thread is waiting at the barrier!");
        barrier.await(500, TimeUnit.MILLISECONDS);
        System.out.println(Thread.currentThread().getName() + " thread passed the barrier! " + Duration.between(startTime, LocalDateTime.now()));
      } catch (InterruptedException | BrokenBarrierException | TimeoutException e) {
        e.printStackTrace();
      }
    };

    ExecutorService es = Executors.newFixedThreadPool(3);
    for (int i = 1; i <= 3; i++) {
      es.execute(new Thread(thread, "T" + i));
    }
    es.shutdown();
  }
}
