package scjp.com.java.javaLanguageFeatures.chapterInnerClass;

import java.util.ArrayList;

public class CallbackTest {
  private final ArrayList<Callable> callableList = new ArrayList<>();

  private void callback() {
    for(Callable c: callableList){
      c.call();
    }
  }

  public void register(Callable c){
    this.callableList.add(c);
  }

  public static void main(String[] args) {
    CallbackTest cbt = new CallbackTest();

    cbt.register(new Callable() {
      @Override
      public void call() {
        System.out.println("Called #1");
      }
    });

    cbt.register(new Callable() {
      @Override
      public void call() {
        System.out.println("Called #2");
      }
    });

    cbt.register(new Callable() {
      @Override
      public void call() {
        System.out.println("Called #3");
      }
    });

    cbt.callback();
  }

}
