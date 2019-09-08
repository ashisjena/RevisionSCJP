package scjp.com.java.algorithm.dynamicProgramming;

public class ArrayHopping
{

    /**
     * @param args
     */
    public static void main( String[] args )
    {
        int[] arr = { 1, 3, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1};
        System.out.println( minJumps( arr, 0 ) );

        int numOfHops = 0;
        for ( int i = 0; i < arr.length - 1; )
        {
            int value = arr[ i ];
            i = i + value;
            numOfHops++;
        }

        System.out.println( numOfHops );

    }

    public static int minJumps( int[] a, int i )
    {
        if ( i == a.length - 1 )
            return 0;

        int min = a.length;
        for ( int k = i + 1; k <= a.length && k <= i + a[ i ]; k++ )
            min = Math.min( min, minJumps( a, k ) );

        return min + 1;
    }

}
