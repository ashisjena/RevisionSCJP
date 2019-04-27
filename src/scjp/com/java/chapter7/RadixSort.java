package scjp.com.java.chapter7;

import java.util.LinkedList;

public class RadixSort
{
    // one bucket for each of the 10 digits
    // sort array with radix sort algorithm
    // numDigits is the maximum number of digits
    void sort( int array[], int numDigits )
    {
        LinkedList< LinkedList< Integer >> buckets = new LinkedList< LinkedList< Integer >>();
        for ( int j = 0; j < 10; j++ )
            buckets.add( new LinkedList< Integer >() );

        for ( int n = 1; n <= numDigits; n++ )
        {
            // Add values to buckets according to n-th digit
            for ( int i = 0; i < array.length; i++ )
                buckets.get( getRadix( array[ i ], n ) ).add( array[ i ] );

            // Collect elements of the buckets and put them back into the array
            int arrayPos = 0;
            for ( int i = 0; i < buckets.size(); i++ )
            {
                while ( !buckets.get( i ).isEmpty() )
                {
                    array[ arrayPos ] = (Integer)buckets.get( i ).removeFirst();
                    arrayPos++;
                }
            }
        }
    }

    // returns the n-th digit of the given number:
    // 3rd radix of 79981 is 9,  2nd radix of 79981 is 8
    // 1st radix of 79981 is 1
    public static int getRadix( int number, int radix )
    {
        return (int)( number / Math.pow( 10, radix - 1 ) ) % 10;
    }

}
