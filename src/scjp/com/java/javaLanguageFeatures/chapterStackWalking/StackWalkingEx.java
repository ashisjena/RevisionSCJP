package scjp.com.java.javaLanguageFeatures.chapterStackWalking;

public class StackWalkingEx {
  public static void main(String[] args) {
    StackTraceElement[] frames = new Throwable().getStackTrace();
    StackTraceElement[] frames2 = Thread.currentThread().getStackTrace();
    for(StackTraceElement frame : frames) {
      System.out.println(frame.toString());
    }
  }
}
