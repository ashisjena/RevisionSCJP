package scjp.com.java.chapter5;

public class Assertion {
  public static void main(String[] args) {
    assert false;
    assert(5 > 7) : "Assertion Error message";
  }
}
