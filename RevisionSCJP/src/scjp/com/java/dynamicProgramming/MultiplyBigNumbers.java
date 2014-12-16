package scjp.com.java.dynamicProgramming;

import java.util.Stack;

public class MultiplyBigNumbers
{
    public static Stack< Integer > stack = new Stack< Integer >();

    public static void main( String[] args )
    {
        int arr1[] = { 9, 9, 9 }; //{ 1, 2, 5, 8, 8, 5, 6, 9, 9, 6 };//new int[10];
        int arr2[] = { 9, 9 };//{ 9, 8, 8, 5, 5, 4, 9, 9, 8, 8, 5, 5, 4, 9 };//new int[14];

        int result[][][] = new int[arr1.length][arr2.length][2];

        for ( int index1 = 0; index1 < arr1.length; index1++ )
            for ( int index2 = 0; index2 < arr2.length; index2++ )
            {
                int prod = arr1[ index1 ] * arr2[ index2 ];
                int carry = prod / 10;
                int unitDigit = prod % 10;
                int[] number = result[ index1 ][ index2 ];
                number[ 0 ] = carry;
                number[ 1 ] = unitDigit;
            }

        int x = arr1.length - 1, y = arr2.length - 1;
        Position position = new Position( x, y );
        Position basePosition = new Position( x, y );
        calculateResult( position, result, 0, 0, basePosition );

        while ( !stack.isEmpty() )
            System.out.print( stack.pop() );
    }

    private static void calculateResult( Position newPosition, int[][][] result, int carry, int unit, Position basePosition )
    {
        int value[] = result[ newPosition.x ][ newPosition.y ];
        carry += value[ 0 ];
        unit += value[ 1 ];
        carry += unit / 10;
        unit %= 10;

        if ( newPosition.x == 0 && newPosition.y == 0 )
        {
            stack.push( unit );
            if ( carry != 0 )
                stack.push( carry );
            return;
        }
        else if ( newPosition.x == result.length - 1 || newPosition.y == 0 )
        {
            stack.push( unit );

            if ( basePosition.x != 0 )
                basePosition.x--;
            else
                basePosition.y--;

            newPosition.x = basePosition.x;
            newPosition.y = basePosition.y;
            calculateResult( newPosition, result, 0, carry, basePosition );
        }
        else
        {
            newPosition.x++;
            newPosition.y--;
            calculateResult( newPosition, result, carry, unit, basePosition );
        }
    }
}

class Position
{
    int x;
    int y;

    Position( int x, int y )
    {
        this.x = x;
        this.y = y;
    }
}