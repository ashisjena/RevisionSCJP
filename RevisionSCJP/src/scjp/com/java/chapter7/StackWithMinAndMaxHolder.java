package scjp.com.java.chapter7;

import java.util.Stack;

public class StackWithMinAndMaxHolder
{
    static Stack< StackObject > stack = new Stack< StackObject >();

    public static void main( String[] args )
    {
        int arr[] = { 32, 34, 12, 3, 6, 8, 123, 1 };

        stack.push( new StackObject( arr[ 0 ], arr[ 0 ], arr[ 0 ] ) );
        int value;
        for ( int index = 1; index < arr.length; index++ )
        {
            value = arr[ index ];
            StackObject stackObject = stack.peek();
            stack.push( new StackObject( value, stackObject.getMin() < value ? stackObject.getMin() : value, stackObject.getMax() > value ? stackObject.getMax() : value ) );
        }

        for ( int index = 0; index < arr.length; index++ )
        {
            StackObject object = stack.pop();
            System.out.println( object.value + ",   " + object.getMin() + ",   " + object.getMax() );
        }
    }
}

class StackObject
{
    int value;
    int min;
    int max;

    StackObject( int value, int min, int max )
    {
        this.value = value;
        this.min = min;
        this.max = max;
    }

    public int getValue()
    {
        return value;
    }

    public int getMin()
    {
        return min;
    }

    public int getMax()
    {
        return max;
    }
}