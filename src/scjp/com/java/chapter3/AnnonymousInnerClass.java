package scjp.com.java.chapter3;

public class AnnonymousInnerClass {
  public static void main(String[] args) {
    Outer o = new Outer();
    o.method();
  }
}


class Outer {
  
  String name = "Rama";
  
  public void method() {
    
    // Anonymous Inner
    Runnable run = new Runnable() {
      
      {
        val = 51 + 12;
        str = name;
      }
      
      private int val;
      private String str = "str";

      @Override
      public void run() {
        System.out.println(val);
        System.out.println(name);
      }
    };
    
    new Thread(run).start();
  }
}
