package scjp.com.java.languageFundamentals.chapter7;

public interface ILinkedList<E>
{
    public int size();

    public void addFirst( E value );

    public E removeFirst();

    public E getFirst();

    public void addLast( E value );

    public E removeLast();

    public boolean contains( E value );

    public E remove( E value );

    public void clear();

    public void add( int index, E value );

    public E remove( int index );
}
