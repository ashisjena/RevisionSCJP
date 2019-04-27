package scjp.com.java.chapter7;

public interface IStack<E> extends ILinear<E>
{
    public void push(E item);
    public E pop();
    public E peek();
}
