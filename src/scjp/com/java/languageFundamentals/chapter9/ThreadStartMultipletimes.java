package scjp.com.java.languageFundamentals.chapter9;

public class ThreadStartMultipletimes {
  public static void main(String[] args) throws InterruptedException {
    Thread t1 = new MyThread();
    t1.start();
    t1.start();
    System.out.println("main");
  }

  static class MyThread extends Thread {
    public void run() {
      System.out.println("CleanAfterTest.MyThread.run() " + Thread.currentThread().getName());
      System.out.println();
    }
  }
}
