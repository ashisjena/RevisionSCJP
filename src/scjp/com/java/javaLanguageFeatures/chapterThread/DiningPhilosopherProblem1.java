package scjp.com.java.javaLanguageFeatures.chapterThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosopherProblem1 implements Runnable {
  final Lock leftFork;
  final Lock rightFork;
  final String name;
  volatile boolean isTummyFull = false;
  int eatCount = 0;

  public DiningPhilosopherProblem1(Lock leftFork, Lock rightFork, String name) {
    this.leftFork = leftFork;
    this.rightFork = rightFork;
    this.name = name;
  }

  public void think() {
    System.out.println(name + " is thinking!");
  }

  public void eat() {
    if (leftFork.tryLock()) {
      try {
        if (rightFork.tryLock()) {
          try {
            System.out.println(name + " is eating!");
            eatCount++;
          } finally {
            rightFork.unlock();
          }
        }
      } finally {
        leftFork.unlock();
      }
    }
  }

  @Override
  public void run() {
    while (!this.isTummyFull) {
      this.think();
      this.eat();
    }
  }

  public static void main(String[] args) throws InterruptedException {
    Lock fork1 = new ReentrantLock();
    Lock fork2 = new ReentrantLock();
    Lock fork3 = new ReentrantLock();
    Lock fork4 = new ReentrantLock();
    Lock fork5 = new ReentrantLock();

    DiningPhilosopherProblem1 p1 = new DiningPhilosopherProblem1(fork1, fork2, "Ram");
    DiningPhilosopherProblem1 p2 = new DiningPhilosopherProblem1(fork2, fork3, "Shyam");
    DiningPhilosopherProblem1 p3 = new DiningPhilosopherProblem1(fork3, fork4, "Hari");
    DiningPhilosopherProblem1 p4 = new DiningPhilosopherProblem1(fork4, fork5, "Govind");
    DiningPhilosopherProblem1 p5 = new DiningPhilosopherProblem1(fork5, fork1, "Sita");

    Thread t1 = new Thread(p1);
    Thread t2 = new Thread(p2);
    Thread t3 = new Thread(p3);
    Thread t4 = new Thread(p4);
    Thread t5 = new Thread(p5);

    t1.start();
    t2.start();
    t3.start();
    t4.start();
    t5.start();

    Thread.sleep(50);
    p1.isTummyFull = true;
    p2.isTummyFull = true;
    p3.isTummyFull = true;
    p4.isTummyFull = true;
    p5.isTummyFull = true;

    t1.join();
    t2.join();
    t3.join();
    t4.join();
    t5.join();
    System.out.println(p1.name + " ate " + p1.eatCount + " number of times");
    System.out.println(p2.name + " ate " + p2.eatCount + " number of times");
    System.out.println(p3.name + " ate " + p3.eatCount + " number of times");
    System.out.println(p4.name + " ate " + p4.eatCount + " number of times");
    System.out.println(p5.name + " ate " + p5.eatCount + " number of times");
  }
}