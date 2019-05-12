package scjp.com.java.javaLanguageFeatures.chapterThread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class LatchEx {
  public static void main(String[] args) {
    Random random = new Random();
    CountDownLatch latch = new CountDownLatch(2);

    Runnable helperService = () -> {
      String name = Thread.currentThread().getName();
      int startupTime = random.nextInt(500) + 1;
      System.out.println("Service #" + name + " starting in " + startupTime + "ms");
      try {
        Thread.sleep(startupTime);
        System.out.println("Service #" + name + " has started!");
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        latch.countDown();
      }
    };

    Runnable mainService = () -> {
      try {
        System.out.println("Main service is waiting for helper services to start..");
        latch.await();
        System.out.println("Main service has started!");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    };

    new Thread(mainService).start();

    new Thread(helperService, "H1").start();
    new Thread(helperService, "H2").start();
  }
}
