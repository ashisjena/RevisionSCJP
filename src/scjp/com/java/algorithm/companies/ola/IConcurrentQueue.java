package scjp.com.java.algorithm.companies.ola;

public interface IConcurrentQueue<E> {
  public void push(E val);

  public E pop();

  public E peek();
}
