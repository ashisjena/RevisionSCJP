package scjp.com.java.javaLanguageFeatures.chapterThread;

public class ThreadTest {
  public static void main(String[] args) {
    Runnable runnable = () -> System.out.println("Hello Java Threads! Runnable");
    Thread myThread = new Thread(runnable);
    myThread.start();
    // A Method reference of a method(static or instance) that takes no parameters and returns void can be executed by a Thread.
    myThread = new Thread(ThreadTest::execute);
    myThread.start();
  }

  public static void execute() {
    System.out.println("Hello Java Threads! execute()");
  }
}
