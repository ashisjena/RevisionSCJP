package scjp.com.java.languageFundamentals.chapter7;

import java.util.Arrays;

public class MyStack<E> implements IStack< E >
{
    private Object elements[] = new Object[10];
    private int elementCount = 0;

    @Override
    public void push( E item )
    {
        ensureCapacity( this.elementCount + 1 );
        this.elements[ elementCount++ ] = item;
    }

    private void ensureCapacity( int capacity )
    {
        int lengthOfArray = elements.length;
        if ( lengthOfArray < capacity )
            increaseCapacityAndCopyValues( ( lengthOfArray * ( 3 / 2 ) ) + 1 );
    }

    private void increaseCapacityAndCopyValues( int newSize )
    {
        /*Object[] newElements = new Object[newSize];
        for ( int index = 0; index < this.elementCount; index++ )
            newElements[ index ] = this.elements[ index ];
        this.elements = newElements;*/
        
        this.elements = Arrays.copyOf( this.elements, newSize );
    }

    @Override
    public E pop()
    {
        E value = peek();
        this.elementCount--;
        return value;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E peek()
    {
        return (E)this.elements[ this.elementCount - 1 ];
    }

    @Override
    public int size()
    {
        return this.elementCount;
    }

    @Override
    public boolean isEmpty()
    {
        return this.elementCount == 0 ? true : false;
    }

    @Override
    public void add( E value )
    {
        push( value );
    }

    @Override
    public E get()
    {
        return peek();
    }

    @Override
    public E remove()
    {
        return pop();
    }
}
