package scjp.com.java.languageFundamentals.chapter3;

public class ConstructorAndStaticOrder {
  public static void main(String[] args) {
    B b = new B();
  }
}

class A {
  static {
    System.out.println("A.static_block()");
  }

  {
    System.out.println("A.init_block()");
  }

  public A() {
    System.out.println("A.A()");
  }
}

class B extends A {

  static {
    System.out.println("B.static_block()");
  }

  {
    System.out.println("B.init_block()");
  }

  C c = new C();  // Order of execution between init block and Instance variable initialization.

  public B() {
    System.out.println("B.B()");
  }
}

class C {
  public C() {
    System.out.println("C.C(), C Reference is getting initialized");
  }
}