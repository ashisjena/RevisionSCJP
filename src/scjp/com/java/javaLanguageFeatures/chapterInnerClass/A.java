package scjp.com.java.javaLanguageFeatures.chapterInnerClass;

public class A {
  private final int value = 2222;
  public static void main(String[] args) {
    A a = new A();
    A.B b = a.new B();
    b.print();
  }
  public class B {
    // Static variable/member/initializer in inner class are not allowed.
    // As the keyword static in Java makes a construct/class a top-level construct/class.
    // As the inner class are associated with objects of outer class, static variable doesn't work as it can't be associated with Class loader level of Inner class
    // public static int INNER_CLASS_STATIC_VAR;

    // This below code works. As it's a compile time constant and will be same for all.
    public final static int INNER_CLASS_STATIC_FINAL_VAR = 5;

    // Although it is final. But it's not a compile time constant.
    // public final static String str = new String("Hello");

    private final int value = 3333;
    private void print() {
      System.out.println("value = " + value);
      System.out.println("this.value = " + this.value);
      System.out.println("B.this.value = " + B.this.value);
      System.out.println("A.this.value = " + A.this.value);
    }
  }

  public class C extends B {

  }

  public class D extends A {

  }
}

class  E extends A {
  public class F extends B{

  }
}

/*
This below code won't compile, as you must have an instance of the outer class to create an instance of inner class.
class G extends A.B {
}
*/

// Here is a way to extend a inner class by supplying instance of outer class to inner class constructor
class G extends A.B {
  public G(A a){
    a.super();
  }
}
