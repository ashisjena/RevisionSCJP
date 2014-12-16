package scjp.com.java.chapter7;

import java.util.AbstractList;

public class Vector<E> extends AbstractList< E >
{
    private Object[] elementData;
    private int capacityInr;
    private int elementCount = 0;

    public Vector()
    {
        this( 10 );
    }

    public Vector( int initialCapacity )
    {
        assert ( initialCapacity >= 0 ) : "Integer Capacity can't be negative.";
        this.elementData = new Object[initialCapacity];
    }

    public Vector( int initialCapacity, int capacityInr )
    {
        this( initialCapacity );
        this.capacityInr = capacityInr;
    }

    public void ensureCapacity( int minCapacity )
    {
        int newLength = this.elementData.length;
        if ( newLength < minCapacity )
        {
            if ( this.capacityInr == 0 )
            {
                if ( newLength == 0 )
                    newLength = 1;

                while ( newLength < minCapacity )
                    newLength *= 2;
            }
            else
                while ( newLength < minCapacity )
                    newLength += this.capacityInr;

            assert newLength >= minCapacity : "Length is less than the minCapacity passed";

            Object[] newElementData = new Object[newLength];

            for ( int i = 0; i < this.elementData.length - 1; i++ )
                newElementData[ i ] = this.elementData[ i ];

            this.elementData = newElementData; // the old object array will be garbage collected.
        }
    }

    public boolean add( E object )
    {
        ensureCapacity( this.elementCount + 1 );
        this.elementData[ this.elementCount ] = object;
        this.elementCount++;
        return true;
    }

    public void add( int index, E object )
    {
        assert index >= 0 && index < this.elementCount : "Index should not be negative and should be less than elementCount of the Vector";
        ensureCapacity( index + 1 );

        // must copy the array elements from right to left
        for ( int i = this.elementCount; i > index; i-- )
            this.elementData[ i ] = this.elementData[ i - 1 ];

        this.elementData[ index ] = object;
        this.elementCount++;
    }

    public E set( int index, E object )
    {
        assert index >= 0 && index < this.elementCount : "Index should not be negative and should be less than elementCount of the Vector";
        Object replacedObj = this.elementData[ index ];
        this.elementData[ index ] = object;
        return (E)replacedObj;
    }

    @Override public E get( int index )
    {
        assert index >= 0 && index < this.elementCount : "Index should not be negative and should be less than elementCount of the Vector";
        return (E)this.elementData[ index ];
    }

    @Override public int size()
    {
        return this.elementCount;
    }
}