package scjp.com.java.languageFundamentals.chapter7;

import java.util.LinkedList;

public class Sorting
{
    public static void main( String[] args )
    {
        int data[] = { 132, 5, 31, 324, 122, 343, 12, 3, 153, 2 };
        //bubbleSort( data );
        //selectionSort( data );
        //insertionSort( data );
        //quickSortRecursive( data, 0, arr.length - 1 );
        radixSort( data, 3 ); // 3 is here the maximum digits contained in a number.

        for ( int num : data )
            System.out.print( num + ", " );
    }

    private static int partition( int data[], int left, int right )
    {
        while ( true )
        {
            while ( left < right && data[ left ] < data[ right ] )
                right--;

            if ( left < right )
                swap( data, left++, right );
            else
                return left;

            while ( left < right && data[ left ] < data[ right ] )
                left++;

            if ( left < right )
                swap( data, left, right-- );
            else
                return right;
        }
    }

    public static void quickSortRecursive( int data[], int left, int right )
    {
        if ( left >= right )
            return;
        int pivot = partition( data, left, right ); // Place pivot
        quickSortRecursive( data, left, pivot - 1 ); // Sort small
        quickSortRecursive( data, pivot + 1, right ); // Sort large
    }

    public static void swap( int data[], int i, int j )
    {
        data[ i ] += data[ j ];
        data[ j ] = data[ i ] - data[ j ];
        data[ i ] -= data[ j ];
    }

    public static void bubbleSort( int data[] )
    {
        int numOfSorted = 1;
        while ( numOfSorted < data.length )
        {
            for ( int index = 1; index < data.length; index++ )
                if ( data[ index - 1 ] > data[ index ] )
                    swap( data, index, index - 1 );
            numOfSorted++;
        }
    }

    public static void selectionSort( int data[] )
    {
        int numOfSorted = 1;
        int indexOfMaxValue = 0;
        while ( numOfSorted < data.length )
        {
            int index;
            for ( index = 1; index <= data.length - numOfSorted; index++ )
                if ( data[ indexOfMaxValue ] < data[ index ] )
                    indexOfMaxValue = index;
            swap( data, --index, indexOfMaxValue );
            numOfSorted++;
        }
    }

    public static void insertionSort( int data[] )
    {
        int numOfSorted = 1;
        while ( numOfSorted < data.length )
        {
            int temp = data[ numOfSorted ];
            int index;
            for ( index = numOfSorted; index > 0; index-- )
                if ( temp < data[ index - 1 ] )
                    data[ index ] = data[ index - 1 ];
                else
                    break;

            data[ index ] = temp;
            numOfSorted++;
        }
    }

    public static int digit( int n, int d )
    {
        if ( d == 0 )
            return n % 10;
        else
            return digit( n / 10, d - 1 );
    }

    public static void bucketPass( int data[], int radix, LinkedList< LinkedList< Integer > > buckets )
    {
        for ( int index = 0; index < data.length; index++ )
        {
            int value = data[ index ];
            int digit = digit( value, radix );
            buckets.get( digit ).add( value );
        }

        for ( int index = 0, arrayPos = 0; index < buckets.size(); index++ )
        {
            while ( !buckets.get( index ).isEmpty() )
            {
                data[ arrayPos ] = (Integer)buckets.get( index ).removeFirst();
                arrayPos++;
            }
        }
    }

    public static void radixSort( int data[], int radix )
    {
        // form the buckets
        LinkedList< LinkedList< Integer >> buckets = new LinkedList< LinkedList< Integer >>();
        for ( int index = 0; index < 10; index++ )
            buckets.add( new LinkedList< Integer >() );
        
        for ( int index = 0; index < radix; index++ )
            bucketPass( data, index, buckets );
    }
}