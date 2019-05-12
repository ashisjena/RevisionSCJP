package scjp.com.java.javaLanguageFeatures.chapterThread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreEx {
  public static void main(String[] args) {
    Restaurant restaurant = new Restaurant(2);
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    for(int i = 0; i < 5; i++){
      executorService.execute(new Customer(restaurant, i + 1));
    }
    executorService.shutdown();
  }
}

class Customer implements Runnable {
  private final Restaurant r;
  private final int custId;
  public static final Random random = new Random();

  Customer(Restaurant r, int custId){
    this.r = r;
    this.custId = custId;
  }

  @Override
  public void run(){
    try {
      r.getTable(this.custId);
      int eatingTime = random.nextInt(30) + 1;
      System.out.println("Customer #" + this.custId + " will eat for " + eatingTime * 10 + "ms");
      Thread.sleep(eatingTime * 10);
      System.out.println("Customer #" + this.custId + " is done eating!");
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      r.returnTable(this.custId);
    }
  }
}

class Restaurant {
  private final Semaphore tables;

  Restaurant(int tablesCount) {
    this.tables = new Semaphore(tablesCount);
  }

  public void getTable(int custId) {
    try {
      System.out.println("Customer #" + custId + " is trying to get the table");
      this.tables.acquire();
      System.out.println("Customer #" + custId + " got a table");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void returnTable(int custId) {
    System.out.println("Customer #" + custId + " returned a table");
    tables.release();
  }
}
