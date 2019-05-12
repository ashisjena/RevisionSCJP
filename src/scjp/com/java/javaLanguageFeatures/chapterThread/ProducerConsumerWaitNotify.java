package scjp.com.java.javaLanguageFeatures.chapterThread;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerWaitNotify {
  public static void main(String[] args) throws InterruptedException {
    List<Integer> inventory = new ArrayList<>();
    Runnable producer = () -> {
      try {
        while (!stopExecution(inventory)) {
          synchronized (inventory) {
            if (inventory.size() == 10) {
              inventory.notifyAll();
              inventory.wait();
            } else {
              inventory.add(inventory.size() + 1);
              System.out.println("Producer: The stock is : " + inventory.size());
              inventory.notifyAll();
            }
          }
          Thread.sleep(1);
        }
        // This block of code is to notify if any waiting consumers.
        synchronized (inventory) {
          inventory.notifyAll();
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    };

    FuncInter consumer = () -> {
      try {
        while (!stopExecution(inventory)) {
          synchronized (inventory) {
            if (inventory.isEmpty()) {
              inventory.notify();
              inventory.wait();
            } else {
              System.out.println("Consumer " + Thread.currentThread().getName() + " the stock : " + inventory.remove(inventory.size() - 1));
              inventory.notify();
            }
          }
          Thread.sleep(10);
        }
        // This block of code is to notify if the producer is waiting
        synchronized (inventory) {
          inventory.notify();
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    };

    Thread p1 = new Thread(producer::run);
//    Thread p1 = new Thread(producer);
    p1.setPriority(Thread.MAX_PRIORITY);

    Thread c1 = new Thread(consumer::execute, "c1");
    Thread c2 = new Thread(consumer::execute, "c2");
    Thread c3 = new Thread(consumer::execute, "c3");
    Thread c4 = new Thread(consumer::execute, "c4");
    Thread c5 = new Thread(consumer::execute, "c5");

    p1.start();
    c1.start();
    c2.start();
    c3.start();
    c4.start();
    c5.start();

    Thread.sleep(70);
    inventory.add(-99);
    System.out.println("Un-Consumed items : " + inventory);
  }

  static boolean stopExecution(List<Integer> inventory) {
    synchronized (inventory) {
      return !inventory.isEmpty() && inventory.get(inventory.size() - 1) == -99;
    }
  }
}

@FunctionalInterface
interface FuncInter {
  void execute();
}
