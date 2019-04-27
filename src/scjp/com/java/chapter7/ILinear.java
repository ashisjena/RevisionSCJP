package scjp.com.java.chapter7;

public interface ILinear<E>
{
    public void add( E value );

    public E get();

    public E remove();

    public int size();

    public boolean isEmpty();
}